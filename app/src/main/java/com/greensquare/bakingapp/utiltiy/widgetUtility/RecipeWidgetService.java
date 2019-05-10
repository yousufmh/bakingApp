package com.greensquare.bakingapp.utiltiy.widgetUtility;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.RemoteViewsService;

public class RecipeWidgetService extends RemoteViewsService {
    public RecipeWidgetService() {
    }

    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        return new RecipeWidegentRemoteFactory(getApplicationContext(),intent);
    }




}
