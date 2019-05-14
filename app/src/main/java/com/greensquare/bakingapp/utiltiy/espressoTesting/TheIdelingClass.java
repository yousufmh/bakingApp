package com.greensquare.bakingapp.utiltiy.espressoTesting;


import android.support.test.espresso.IdlingResource;
import android.support.test.espresso.idling.CountingIdlingResource;

public  class TheIdelingClass {

    private static CountingIdlingResource countingIdling = new CountingIdlingResource("RecipesClass");

    public static void increamnet(){
        countingIdling.increment();
    }

    public static void decrement(){
        countingIdling.decrement();
    }

    public static IdlingResource getCountingIdling(){
        return countingIdling;
    }

}
