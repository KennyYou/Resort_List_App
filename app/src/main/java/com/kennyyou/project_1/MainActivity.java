package com.kennyyou.project_1;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


import java.text.DecimalFormat;


////////////////////
//MY CUSTOM OPTION DISPLAYS THE MOST EXPENSIVE HOTEL PRICE
////////////////////

public class MainActivity extends AppCompatActivity {

    public static TextView tv;
    public static ResortList the_list = ResortList.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Code neeeded to get url for option 9
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        //Set up text view
        tv = (TextView) findViewById(R.id.text_main);
        tv.setText("Text is displayed here.");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onOption1(MenuItem i) {
        //Displays the resorts
        tv.setText("");
        the_list = ResortList.getInstance();

        //Displays all results
        for (int j = 0; j < the_list.size(); j++) {
            tv.append(the_list.get(j).getName() + ", ");
            tv.append(the_list.get(j).getLocation() + ", ");
            tv.append(the_list.get(j).getCode() + ", $");
            tv.append(the_list.get(j).getPpnpg() + "\n");
        }
    }

    public void onOption2(MenuItem i) {
        //Adds new resort
        startActivity(new Intent(this, AddResort.class));
    }

    public void onOption3(MenuItem i) {
        //Show details of a resort
        startActivity(new Intent(this, Option3.class));
    }

    public void onOption4(MenuItem i) {
        //Details of a stay
        startActivity(new Intent(this, Option4.class));
    }

    public void onOption5(MenuItem i) {
        //Remove a resort
        startActivity(new Intent(this, Option5.class));
    }

    public void onOption6(MenuItem i) {
        the_list = ResortList.getInstance();

        String test12 = "";
        //Show oldest resort
        tv.setText("");
        int newyear = the_list.get(0).getYear();
        for (int j = 0; j < the_list.size(); j++) {
            if (newyear > the_list.get(j).getYear()) {
                test12 = the_list.get(j).getName();
                newyear = the_list.get(j).getYear();
            }
        }
        int newnewyear = 2018 - newyear;
        tv.append("Name: " + test12 + "\n");
        tv.append("Oldest Resort age is: " + newnewyear);

    }

    public void onOption7(MenuItem i) {
        the_list = ResortList.getInstance();

        //Show average price per night
        tv.setText("");
        double total = 0;
        double count = 0;
        for (int j = 0; j < the_list.size(); j++) {
            total = total + the_list.get(j).getPpnpg();
            count++;
        }
        total = total / count;
        DecimalFormat df2 = new DecimalFormat(".##");
        tv.append("Average price per night for all hotels: $" + df2.format(total));
    }

    public void onOption8(MenuItem i) {
        //Custom option: Display most expensive hotel
        tv.setText("");

        ResortList the_list = ResortList.getInstance();
        DecimalFormat df2 = new DecimalFormat(".##");

        Double mostexpen = the_list.get(0).getResortfee() + the_list.get(0).getPpnpg();
        for (int o = 0; o < the_list.size(); o++) {
            if (the_list.get(o).getResortfee() + the_list.get(o).getPpnpg() > mostexpen) {
                mostexpen = the_list.get(o).getResortfee() + the_list.get(o).getPpnpg();
            }
        }
        tv.append("The most expensive Hotel costs for a night: $" + df2.format(mostexpen));

    }

    public void onOption9(MenuItem i) {
        //Load file
        startActivity(new Intent(this, Option9.class));
    }

    public void onOption10(MenuItem i) {
        //Save file
        startActivity(new Intent(this, Option10.class));
    }
}//End
