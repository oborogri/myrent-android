package org.wit.myrent.activities;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.text.Editable;

import org.wit.myrent.R;
import org.wit.myrent.app.MyRentApp;
import org.wit.myrent.models.Portfolio;
import org.wit.myrent.models.Residence;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import android.app.DatePickerDialog;
import android.view.View;
import android.view.View.OnClickListener;

import static org.wit.myrent.helpers.ContactHelper.getContact;
import static org.wit.myrent.helpers.IntentHelper.selectContact;
import android.content.Intent;

import static org.wit.myrent.helpers.IntentHelper.navigateUp;
import static org.wit.myrent.helpers.ContactHelper.sendEmail;

public class ResidenceActivity extends Activity implements TextWatcher, CompoundButton.OnCheckedChangeListener, View.OnClickListener, DatePickerDialog.OnDateSetListener
{
    private EditText geolocation;
    private Residence residence;
    private CheckBox rented;
    private Button dateButton;
    private Portfolio portfolio;
    private static final int REQUEST_CONTACT = 1;
    private Button   tenantButton;
    private String emailAddress = "";
    private Button   reportButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_residence);

        geolocation = (EditText) findViewById(R.id.geolocation);
        residence = new Residence();

        // Register a TextWatcher in the EditText geolocation object
        geolocation.addTextChangedListener(this);

        dateButton  = (Button)   findViewById(R.id.registration_date);
        dateButton  .setOnClickListener(this);
        reportButton = (Button)   findViewById(R.id.residence_reportButton);
        tenantButton = (Button)   findViewById(R.id.tenant);

        reportButton.setOnClickListener(this);

        rented  = (CheckBox) findViewById(R.id.isrented);
        rented.setOnCheckedChangeListener(this);

        MyRentApp app = (MyRentApp) getApplication();
        portfolio = app.portfolio;

        Long resId = (Long) getIntent().getExtras().getSerializable("RESIDENCE_ID");
        residence = portfolio.getResidence(resId);

        if (residence != null)
        {
            updateControls(residence);
        }
    }

    public void updateControls(Residence residence)
    {
        geolocation.setText(residence.geolocation);
        rented.setChecked(residence.rented);
        dateButton.setText(residence.getDateString());
        tenantButton.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //inflate the menu; this adds item to the action bar if it is present
        getMenuInflater().inflate(R.menu.myrent, menu);
        return true;
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


    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.registration_date      : Calendar c = Calendar.getInstance();
                DatePickerDialog dpd = new DatePickerDialog (this, this, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
                dpd.show();
                break;
            case R.id.tenant : selectContact(this, REQUEST_CONTACT);
                break;

            case R.id.residence_reportButton :
                sendEmail(this, emailAddress, getString(R.string.residence_report_subject), residence.getResidenceReport(this));
                break;
        }
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth)
    {
        Date date = new GregorianCalendar(year, monthOfYear, dayOfMonth).getTime();
        residence.date = date.getTime();
        dateButton.setText(residence.getDateString());
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        switch (requestCode)
        {
            case REQUEST_CONTACT:
                String name = "Empty contact list";
                if(data != null) {
                    name = getContact(this, data);
                }
                residence.tenant = name;
                tenantButton.setText(name);
                break;
        }
    }

    @Override
    public void afterTextChanged(Editable editable)
    {
        residence.setGeolocation(editable.toString());
    }

    @Override
    public void beforeTextChanged(CharSequence c, int start, int count, int after)
    {
    }

    @Override
    public void onTextChanged(CharSequence c, int start, int count, int after)
    {
    }

    @Override
    public void onCheckedChanged(CompoundButton arg0, boolean isChecked)
    {
        Log.i(this.getClass().getSimpleName(), "rented Checked");
        residence.rented = isChecked;
    }


}
