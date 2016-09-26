package org.wit.myrent.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.text.Editable;

import org.wit.myrent.R;
import org.wit.myrent.models.Residence;

public class ResidenceActivity extends AppCompatActivity implements TextWatcher {
    private EditText geolocation;
    private Residence residence;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_residence);

        geolocation = (EditText) findViewById(R.id.geolocation);
        residence = new Residence();

        // Register a TextWatcher in the EditText geolocation object
        geolocation.addTextChangedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //inflate the menu; this adds item to the action bar if it is present
        getMenuInflater().inflate(R.menu.myrent, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //handle action bar items clicks here. The action bar will
        //automatically handle clicks on the Home/Up button, so long
        //as you specify a parent activity in AndroidManifest.xml
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
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
}
