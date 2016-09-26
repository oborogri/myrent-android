package org.wit.myrent.app;

import org.wit.myrent.models.Portfolio;
import android.app.Application;
import static org.wit.myrent.helpers.LogHelpers.info;

public class MyRentApp extends Application
{
    public Portfolio portfolio;

    @Override
    public void onCreate()
    {
        super.onCreate();
        portfolio = new Portfolio();

        info(this, "MyRent app launched");
    }
}
