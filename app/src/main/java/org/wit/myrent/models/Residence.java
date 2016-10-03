package org.wit.myrent.models;

import java.util.Date;
import java.util.Random;

import org.json.JSONException;[]
import org.json.JSONObject;
import org.wit.myrent.R;
import android.content.Context;

public class Residence
{
    public Long id;
    public Long date;
    public String  tenant;
    private static final String JSON_TENANT         = "tenant";

    //a latitude longitude pair
    //example "52.4566,-6.5444"
    public String geolocation;
    public boolean rented;

    public Residence()
    {
        id = new Random().nextLong();
        date = new Date().getTime();
        geolocation = "52.253456,-7.187162";
        tenant      = ": none presently";
    }

    public Residence(JSONObject json) throws JSONException
    {
        tenant        = json.getString(JSON_TENANT);
        json.put(JSON_TENANT        , tenant);
    }

    public void setGeolocation(String geolocation)
    {
        this.geolocation = geolocation;
    }

    public String getGeolocation()
    {
        return geolocation;
    }

    public String getDateString() {
        return "Registered:" + dateString();
    }

    private String dateString() {
        String dateFormat = "EEE d MMM yyyy H:mm";
        return android.text.format.DateFormat.format(dateFormat, date).toString();
    }

    public String getResidenceReport(Context context) {
        String rentedString = "";
        if (rented) {
            rentedString = context.getString(R.string.residence_report_rented);
        }
        else {
            rentedString = context.getString(R.string.residence_report_not_rented);
        }

        String prospectiveTenant = tenant;
        if (tenant == null) {
            prospectiveTenant = context.getString(R.string.residence_report_nobody_interested);
        }
        else {
            prospectiveTenant = context.getString(R.string.residence_report_prospective_tenant, tenant);
        }
        String report = "Location " + geolocation + " Date: " + dateString() + " " + rentedString + " " + prospectiveTenant;
        return report;

    }


}