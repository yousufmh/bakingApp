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
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class RecipesActivityTestTabletMood2 {

    @Rule
    public ActivityTestRule<RecipesActivity> recipesTest = new ActivityTestRule<>(RecipesActivity.class);

    int RecipeSize;
    @Before
    public void init (){
        RecyclerView rv = this.recipesTest.getActivity().findViewById(R.id.recipe_rv);
        if(rv.getAdapter().getItemCount()!=0)
            RecipeSize = rv.getAdapter().getItemCount();


            RecipeSize=4;
        IdlingRegistry.getInstance().register(TheIdelingClass.getCountingIdling());
    }


    @Test
    public void recipesActivityTestTabletMood2() {
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



        ViewInteraction recyclerView5 = onView(
                allOf(withId(R.id.steps_rv),
                        childAtPosition(
                                withClassName(is("android.widget.FrameLayout")),
                                0)));
        recyclerView5.perform(actionOnItemAtPosition(6, click()));



        ViewInteraction appCompatImageButton = onView(
                allOf(withId(R.id.exo_play), withContentDescription("Play"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                4),
                        isDisplayed()));
        appCompatImageButton.perform(click());


        ViewInteraction recyclerView6 = onView(
                allOf(withId(R.id.steps_rv),
                        childAtPosition(
                                withClassName(is("android.widget.FrameLayout")),
                                0)));
        recyclerView6.perform(actionOnItemAtPosition(5, click()));


        pressBack();

        ViewInteraction recyclerView7 = onView(
                allOf(withId(R.id.recipe_rv),
                        childAtPosition(
                                withId(R.id.tablet_mood),
                                0)));
        recyclerView7.perform(actionOnItemAtPosition(1, click()));


        ViewInteraction recyclerView8 = onView(
                allOf(withId(R.id.steps_rv),
                        childAtPosition(
                                withClassName(is("android.widget.FrameLayout")),
                                0)));
        recyclerView8.perform(actionOnItemAtPosition(0, click()));


        ViewInteraction recyclerView9 = onView(
                allOf(withId(R.id.steps_rv),
                        childAtPosition(
                                withClassName(is("android.widget.FrameLayout")),
                                0)));
        recyclerView9.perform(actionOnItemAtPosition(1, click()));



        ViewInteraction recyclerView10 = onView(
                allOf(withId(R.id.steps_rv),
                        childAtPosition(
                                withClassName(is("android.widget.FrameLayout")),
                                0)));
        recyclerView10.perform(actionOnItemAtPosition(2, click()));



        ViewInteraction recyclerView11 = onView(
                allOf(withId(R.id.steps_rv),
                        childAtPosition(
                                withClassName(is("android.widget.FrameLayout")),
                                0)));
        recyclerView11.perform(actionOnItemAtPosition(3, click()));



        ViewInteraction recyclerView12 = onView(
                allOf(withId(R.id.steps_rv),
                        childAtPosition(
                                withClassName(is("android.widget.FrameLayout")),
                                0)));
        recyclerView12.perform(actionOnItemAtPosition(4, click()));



        ViewInteraction recyclerView13 = onView(
                allOf(withId(R.id.steps_rv),
                        childAtPosition(
                                withClassName(is("android.widget.FrameLayout")),
                                0)));
        recyclerView13.perform(actionOnItemAtPosition(5, click()));



        ViewInteraction recyclerView14 = onView(
                allOf(withId(R.id.steps_rv),
                        childAtPosition(
                                withClassName(is("android.widget.FrameLayout")),
                                0)));
        recyclerView14.perform(actionOnItemAtPosition(6, click()));



        ViewInteraction recyclerView15 = onView(
                allOf(withId(R.id.steps_rv),
                        childAtPosition(
                                withClassName(is("android.widget.FrameLayout")),
                                0)));
        recyclerView15.perform(actionOnItemAtPosition(7, click()));



        ViewInteraction recyclerView16 = onView(
                allOf(withId(R.id.steps_rv),
                        childAtPosition(
                                withClassName(is("android.widget.FrameLayout")),
                                0)));
        recyclerView16.perform(actionOnItemAtPosition(8, click()));


        ViewInteraction recyclerView17 = onView(
                allOf(withId(R.id.steps_rv),
                        childAtPosition(
                                withClassName(is("android.widget.FrameLayout")),
                                0)));
        recyclerView17.perform(actionOnItemAtPosition(9, click()));



        pressBack();

        ViewInteraction recyclerView18 = onView(
                allOf(withId(R.id.recipe_rv),
                        childAtPosition(
                                withId(R.id.tablet_mood),
                                0)));
        recyclerView18.perform(actionOnItemAtPosition(2, click()));



        ViewInteraction recyclerView19 = onView(
                allOf(withId(R.id.steps_rv),
                        childAtPosition(
                                withClassName(is("android.widget.FrameLayout")),
                                0)));
        recyclerView19.perform(actionOnItemAtPosition(1, click()));



        ViewInteraction recyclerView20 = onView(
                allOf(withId(R.id.steps_rv),
                        childAtPosition(
                                withClassName(is("android.widget.FrameLayout")),
                                0)));
        recyclerView20.perform(actionOnItemAtPosition(2, click()));



        ViewInteraction recyclerView21 = onView(
                allOf(withId(R.id.steps_rv),
                        childAtPosition(
                                withClassName(is("android.widget.FrameLayout")),
                                0)));
        recyclerView21.perform(actionOnItemAtPosition(3, click()));



        ViewInteraction recyclerView22 = onView(
                allOf(withId(R.id.steps_rv),
                        childAtPosition(
                                withClassName(is("android.widget.FrameLayout")),
                                0)));
        recyclerView22.perform(actionOnItemAtPosition(4, click()));



        ViewInteraction recyclerView23 = onView(
                allOf(withId(R.id.steps_rv),
                        childAtPosition(
                                withClassName(is("android.widget.FrameLayout")),
                                0)));
        recyclerView23.perform(actionOnItemAtPosition(5, click()));



        ViewInteraction recyclerView24 = onView(
                allOf(withId(R.id.steps_rv),
                        childAtPosition(
                                withClassName(is("android.widget.FrameLayout")),
                                0)));
        recyclerView24.perform(actionOnItemAtPosition(6, click()));



        ViewInteraction recyclerView25 = onView(
                allOf(withId(R.id.steps_rv),
                        childAtPosition(
                                withClassName(is("android.widget.FrameLayout")),
                                0)));
        recyclerView25.perform(actionOnItemAtPosition(7, click()));



        ViewInteraction recyclerView26 = onView(
                allOf(withId(R.id.steps_rv),
                        childAtPosition(
                                withClassName(is("android.widget.FrameLayout")),
                                0)));
        recyclerView26.perform(actionOnItemAtPosition(8, click()));



        ViewInteraction recyclerView27 = onView(
                allOf(withId(R.id.steps_rv),
                        childAtPosition(
                                withClassName(is("android.widget.FrameLayout")),
                                0)));
        recyclerView27.perform(actionOnItemAtPosition(9, click()));



        ViewInteraction recyclerView28 = onView(
                allOf(withId(R.id.steps_rv),
                        childAtPosition(
                                withClassName(is("android.widget.FrameLayout")),
                                0)));
        recyclerView28.perform(actionOnItemAtPosition(10, click()));



        ViewInteraction recyclerView29 = onView(
                allOf(withId(R.id.steps_rv),
                        childAtPosition(
                                withClassName(is("android.widget.FrameLayout")),
                                0)));
        recyclerView29.perform(actionOnItemAtPosition(11, click()));



        ViewInteraction recyclerView30 = onView(
                allOf(withId(R.id.steps_rv),
                        childAtPosition(
                                withClassName(is("android.widget.FrameLayout")),
                                0)));
        recyclerView30.perform(actionOnItemAtPosition(12, click()));



        pressBack();

        ViewInteraction recyclerView31 = onView(
                allOf(withId(R.id.recipe_rv),
                        childAtPosition(
                                withId(R.id.tablet_mood),
                                0)));
        recyclerView31.perform(actionOnItemAtPosition(3, click()));



        ViewInteraction recyclerView32 = onView(
                allOf(withId(R.id.steps_rv),
                        childAtPosition(
                                withClassName(is("android.widget.FrameLayout")),
                                0)));
        recyclerView32.perform(actionOnItemAtPosition(0, click()));



        ViewInteraction recyclerView33 = onView(
                allOf(withId(R.id.steps_rv),
                        childAtPosition(
                                withClassName(is("android.widget.FrameLayout")),
                                0)));
        recyclerView33.perform(actionOnItemAtPosition(1, click()));



        ViewInteraction recyclerView34 = onView(
                allOf(withId(R.id.steps_rv),
                        childAtPosition(
                                withClassName(is("android.widget.FrameLayout")),
                                0)));
        recyclerView34.perform(actionOnItemAtPosition(2, click()));



        ViewInteraction recyclerView35 = onView(
                allOf(withId(R.id.steps_rv),
                        childAtPosition(
                                withClassName(is("android.widget.FrameLayout")),
                                0)));
        recyclerView35.perform(actionOnItemAtPosition(3, click()));



        ViewInteraction recyclerView36 = onView(
                allOf(withId(R.id.steps_rv),
                        childAtPosition(
                                withClassName(is("android.widget.FrameLayout")),
                                0)));
        recyclerView36.perform(actionOnItemAtPosition(4, click()));


        ViewInteraction recyclerView37 = onView(
                allOf(withId(R.id.steps_rv),
                        childAtPosition(
                                withClassName(is("android.widget.FrameLayout")),
                                0)));
        recyclerView37.perform(actionOnItemAtPosition(5, click()));



        ViewInteraction recyclerView38 = onView(
                allOf(withId(R.id.steps_rv),
                        childAtPosition(
                                withClassName(is("android.widget.FrameLayout")),
                                0)));
        recyclerView38.perform(actionOnItemAtPosition(6, click()));



        ViewInteraction recyclerView39 = onView(
                allOf(withId(R.id.steps_rv),
                        childAtPosition(
                                withClassName(is("android.widget.FrameLayout")),
                                0)));
        recyclerView39.perform(actionOnItemAtPosition(7, click()));



        ViewInteraction recyclerView40 = onView(
                allOf(withId(R.id.steps_rv),
                        childAtPosition(
                                withClassName(is("android.widget.FrameLayout")),
                                0)));
        recyclerView40.perform(actionOnItemAtPosition(8, click()));



        ViewInteraction recyclerView41 = onView(
                allOf(withId(R.id.steps_rv),
                        childAtPosition(
                                withClassName(is("android.widget.FrameLayout")),
                                0)));
        recyclerView41.perform(actionOnItemAtPosition(9, click()));



        ViewInteraction recyclerView42 = onView(
                allOf(withId(R.id.steps_rv),
                        childAtPosition(
                                withClassName(is("android.widget.FrameLayout")),
                                0)));
        recyclerView42.perform(actionOnItemAtPosition(10, click()));



        ViewInteraction recyclerView43 = onView(
                allOf(withId(R.id.steps_rv),
                        childAtPosition(
                                withClassName(is("android.widget.FrameLayout")),
                                0)));
        recyclerView43.perform(actionOnItemAtPosition(11, click()));



        ViewInteraction recyclerView44 = onView(
                allOf(withId(R.id.steps_rv),
                        childAtPosition(
                                withClassName(is("android.widget.FrameLayout")),
                                0)));
        recyclerView44.perform(actionOnItemAtPosition(12, click()));

        pressBack();

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
