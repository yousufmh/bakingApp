package com.greensquare.bakingapp.ui;


import android.support.test.espresso.IdlingRegistry;
import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.greensquare.bakingapp.R;
import com.greensquare.bakingapp.utiltiy.espressoTesting.TheIdelingClass;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class RecipesActivityTestTabletMood {

    @Rule
    public ActivityTestRule<RecipesActivity> recipesTest = new ActivityTestRule<>(RecipesActivity.class);
int RecipeSize;
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
    public void recipesActivityTestTabletMood() {
        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.recipe_rv),
                        childAtPosition(
                                withId(R.id.tablet_mood),
                                0)));
        recyclerView.perform(actionOnItemAtPosition(0, click()));

        ViewInteraction recyclerView2 = onView(
                allOf(withId(R.id.steps_rv),
                        childAtPosition(
                                withClassName(is("android.widget.FrameLayout")),
                                0)));
        recyclerView2.perform(actionOnItemAtPosition(0, click()));


        ViewInteraction recyclerView3 = onView(
                allOf(withId(R.id.steps_rv),
                        childAtPosition(
                                withClassName(is("android.widget.FrameLayout")),
                                0)));
        recyclerView3.perform(actionOnItemAtPosition(1, click()));



        ViewInteraction recyclerView4 = onView(
                allOf(withId(R.id.steps_rv),
                        childAtPosition(
                                withClassName(is("android.widget.FrameLayout")),
                                0)));
        recyclerView4.perform(actionOnItemAtPosition(2, click()));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction recyclerView5 = onView(
                allOf(withId(R.id.steps_rv),
                        childAtPosition(
                                withClassName(is("android.widget.FrameLayout")),
                                0)));
        recyclerView5.perform(actionOnItemAtPosition(6, click()));

        ViewInteraction recyclerView6 = onView(
                allOf(withId(R.id.steps_rv),
                        childAtPosition(
                                withClassName(is("android.widget.FrameLayout")),
                                0)));
        recyclerView6.perform(actionOnItemAtPosition(6, click()));
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }

    @After
    public void unRegersterIdel(){
        IdlingRegistry.getInstance().unregister(TheIdelingClass.getCountingIdling());
    }


}
