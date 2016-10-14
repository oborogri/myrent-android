package org.wit.myrent.models;

import static org.wit.myrent.helpers.LogHelpers.info;

import java.util.ArrayList;

import android.util.Log;
import static org.wit.myrent.helpers.LogHelpers.info;

public class Portfolio
{
<<<<<<< HEAD
    private PortfolioSerializer   serializer;
    public ArrayList<Residence> residences;
=======
    public  ArrayList<Residence>  residences;
    private PortfolioSerializer   serializer;
>>>>>>> 71a3b4e1b9d41b1028368295a43c53b64c2cb358

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
<<<<<<< HEAD
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
=======
>>>>>>> 71a3b4e1b9d41b1028368295a43c53b64c2cb358
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

    public void addResidence(Residence residence)
    {
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
<<<<<<< HEAD

=======
>>>>>>> 71a3b4e1b9d41b1028368295a43c53b64c2cb358
}