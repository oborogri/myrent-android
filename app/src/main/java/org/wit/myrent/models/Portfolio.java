package org.wit.myrent.models;
import java.util.ArrayList;

import android.util.Log;
import static org.wit.myrent.helpers.LogHelpers.info;

public class Portfolio
{
    private PortfolioSerializer   serializer;
    public ArrayList<Residence> residences;

    public Portfolio(PortfolioSerializer serializer)
    {
        this.serializer = serializer;
        try
        {
            residences = serializer.loadResidences();
        }
        catch (Exception e)
        {
            info(this, "Error loading residences: " + e.getMessage());
            residences = new ArrayList<Residence>();
        }
    }

    public boolean saveResidences()
    {
        try
        {
            serializer.saveResidences(residences);
            info(this, "Residences saved to file");
            return true;
        }
        catch (Exception e)
        {
            info(this, "Error saving residences: " + e.getMessage());
            return false;
        }
    }

    public void addResidence(Residence residence) {
        residences.add(residence);
    }

    public Residence getResidence(Long id)
    {
        Log.i(this.getClass().getSimpleName(), "Long parameter id: "+ id);

        for (Residence res : residences)
        {
            if(id.equals(res.id))
            {
                return res;
            }
        }
        info(this, "failed to find residence. returning first element array to avoid crash");
        return null;
    }

    public void deleteResidence(Residence residence)
    {
        residences.remove(residence);
        saveResidences();
    }

}