package com.greensquare.bakingapp.ui;

import android.support.test.espresso.IdlingRegistry;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;
import android.util.Size;

import com.greensquare.bakingapp.R;
import com.greensquare.bakingapp.ui.RecipesActivity;
import com.greensquare.bakingapp.utiltiy.espressoTesting.TheIdelingClass;



import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.StringDescription;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;

import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.greaterThan;

@RunWith(AndroidJUnit4.class)
public class RecipesActivityTestPhoneMood {

    @Rule
    public ActivityTestRule<RecipesActivity> recipesTest = new ActivityTestRule<>(RecipesActivity.class);

    private int RecipeSize,stepSize;
    @Before
    public void init (){
        RecyclerView rv = this.recipesTest.getActivity().findViewById(R.id.recipe_rv);
        if(rv.getAdapter().getItemCount()!=0)
            RecipeSize = rv.getAdapter().getItemCount();

        else
            RecipeSize=4;
        IdlingRegistry.getInstance().register(TheIdelingClass.getCountingIdling());
    }

    @Test
    public void recipeRecycleTest(){
        if(RecipeSize!=0)
        for(int i=0;i<RecipeSize;i++) {
            onView(withId(R.id.recipe_rv)).perform(RecyclerViewActions.actionOnItemAtPosition(i, click()));
            for (int m =0; m<7; m++){
                onView(withId(R.id.steps_rv)).perform(RecyclerViewActions.actionOnItemAtPosition(m, click()));
                pressBack();
            }
            pressBack();
        }
        else{
            onView(withId(R.id.recipe_rv)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        }

    }


@After
    public void unRegersterIdel(){
        IdlingRegistry.getInstance().unregister(TheIdelingClass.getCountingIdling());
}


}
