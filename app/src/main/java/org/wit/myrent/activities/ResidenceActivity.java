

package org.wit.myrent.activities;

<<<<<<< HEAD
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;

import org.wit.myrent.R;
import org.wit.myrent.app.MyRentApp;
import org.wit.myrent.models.Portfolio;
import org.wit.myrent.models.Residence;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import android.app.DatePickerDialog;
import android.view.View;
import static org.wit.myrent.helpers.IntentHelper.navigateUp;



public class ResidenceActivity extends AppCompatActivity implements TextWatcher,
        CompoundButton.OnCheckedChangeListener,
        View.OnClickListener,
        DatePickerDialog.OnDateSetListener


{
    private EditText geolocation;
    private Residence residence;

    private CheckBox rented;
    private Button dateButton;

    private Portfolio portfolio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_residence);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        geolocation = (EditText) findViewById(R.id.geolocation);
        residence = new Residence();

        // Register a TextWatcher in the EditText geolocation object
        geolocation.addTextChangedListener(this);

        dateButton = (Button) findViewById(R.id.registration_date);
        dateButton  .setOnClickListener(this);

        rented = (CheckBox) findViewById(R.id.isrented);

        MyRentApp app = (MyRentApp) getApplication();
        portfolio = app.portfolio;
        Long resId = (Long) getIntent().getExtras().getSerializable("RESIDENCE_ID");
        residence = portfolio.getResidence(resId);
        if (residence != null) {
            updateControls(residence);
        }
    }

    public void updateControls(Residence residence) {
        geolocation.setText(residence.geolocation);
        rented.setOnCheckedChangeListener(this);

        dateButton.setText(residence.getDateString());
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        residence.setGeolocation(editable.toString());
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        Log.i(this.getClass().getSimpleName(), "rented Checked");
        residence.rented = isChecked;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
=======

import org.wit.myrent.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

public class ResidenceActivity extends AppCompatActivity
{
    ActionBar actionBar;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_container);

        actionBar = getSupportActionBar();

        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.fragmentContainer);
        if (fragment == null)
>>>>>>> 71a3b4e1b9d41b1028368295a43c53b64c2cb358
        {
            fragment = new ResidenceFragment();
            manager.beginTransaction().add(R.id.fragmentContainer, fragment).commit();
        }
    }
<<<<<<< HEAD

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        Date date = new GregorianCalendar(year, monthOfYear, dayOfMonth).getTime();
        residence.date = date.getTime();
        dateButton.setText(residence.getDateString());
    }

    @Override
    public void onPause()
    {
        super.onPause();
        portfolio.saveResidences();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case android.R.id.home:  navigateUp(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
=======
}
>>>>>>> 71a3b4e1b9d41b1028368295a43c53b64c2cb358
