package org.wit.myrent.app;

import org.wit.myrent.models.Portfolio;
import org.wit.myrent.models.PortfolioSerializer;

import android.app.Application;
import static org.wit.myrent.helpers.LogHelpers.info;

public class MyRentApp extends Application
{
    private static final String FILENAME = "portfolio.json";
    public Portfolio portfolio;
    protected static MyRentApp app;

    @Override
    public void onCreate()
    {
        super.onCreate();
        PortfolioSerializer serializer = new PortfolioSerializer(this, FILENAME);
        portfolio = new Portfolio(serializer);

        app=this;

        info(this, "MyRent app launched");
    }
    public static MyRentApp getApp() {
        return app;
    }
}