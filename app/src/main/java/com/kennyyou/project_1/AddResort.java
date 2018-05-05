package com.kennyyou.project_1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class AddResort extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_resort);
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
    }
    //Also Known as Option1
    public void addItem(View view) {
        try{

            ResortList the_list = ResortList.getInstance();

            //Read values from user
            EditText et1 = (EditText) findViewById(R.id.edit_item1);
            String name = et1.getText().toString();

            EditText et2 = (EditText) findViewById(R.id.edit_item2);
            String location = et2.getText().toString();

            EditText et3 = (EditText) findViewById(R.id.edit_item3);
            String code = et3.getText().toString();

            EditText et4 = (EditText) findViewById(R.id.edit_item4);
            int year = Integer.parseInt(et4.getText().toString());

            EditText et5 = (EditText) findViewById(R.id.edit_item5);
            double ppnpg = Double.parseDouble(et5.getText().toString());

            EditText et6 = (EditText) findViewById(R.id.edit_item6);
            double resortfee = Double.parseDouble(et6.getText().toString());

            EditText et7 = (EditText) findViewById(R.id.edit_item7);
            double tax = Double.parseDouble(et7.getText().toString());

            EditText et8 = (EditText) findViewById(R.id.edit_item8);
            String url = et8.getText().toString();
            //Put the resort at the end

            Resort newresort = new Resort(name, location, code, year, ppnpg, resortfee, tax, url);
            the_list.add(the_list.size(), newresort);

            Toast.makeText(AddResort.this,
                    " Resort added to the list",
                    Toast.LENGTH_SHORT).show();
        }

        catch (Exception e){
            Toast.makeText(AddResort.this,
                    " Resort failed to add to the list",
                    Toast.LENGTH_SHORT).show();
        }

    } // end addItem
}