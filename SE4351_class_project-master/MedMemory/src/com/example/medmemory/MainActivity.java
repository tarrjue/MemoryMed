package com.example.medmemory;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public void gotomeds(View view) {
        Intent myintent = new Intent(this, Meds.class);
        startActivity(myintent);
    }

    public void gotodoctor(View view) {
        Intent myintent = new Intent(this, Doctor.class);
        startActivity(myintent);
    }

    public void gotopharms(View view) {
//    	Intent myintent = new Intent(this, Pharm.class);
        Intent myintent = new Intent(Intent.ACTION_VIEW);
        myintent.setData(Uri.parse("geo:0,0?q=pharmacy"));
        if (myintent.resolveActivity(getPackageManager()) != null)
            startActivity(myintent);
        else
            Toast.makeText(this, "There is no Maps app on this device.", Toast.LENGTH_SHORT).show();
    }


    public void gotoaddmedication(View view) {
        Intent myintent = new Intent(this, AddMedication.class);
        startActivity(myintent);
    }
}
