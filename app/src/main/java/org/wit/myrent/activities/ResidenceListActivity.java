package org.wit.myrent.activities;

import org.wit.myrent.R;
<<<<<<< HEAD
import org.wit.myrent.app.MyRentApp;
import org.wit.myrent.models.Portfolio;

import android.view.Menu;
import android.view.MenuInflater;
import android.widget.AdapterView;
import android.widget.ListView;
import android.support.v7.app.AppCompatActivity;
=======
>>>>>>> 71a3b4e1b9d41b1028368295a43c53b64c2cb358
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class ResidenceListActivity extends AppCompatActivity
{
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_container);

        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.fragmentContainer);
        if (fragment == null)
        {
            fragment = new ResidenceListFragment();
            manager.beginTransaction().add(R.id.fragmentContainer, fragment).commit();
        }
    }
}