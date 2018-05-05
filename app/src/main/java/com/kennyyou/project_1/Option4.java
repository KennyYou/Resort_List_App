package com.kennyyou.project_1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

import static com.kennyyou.project_1.MainActivity.tv;

public class Option4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option4);
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

    public void Details(View view) {
        tv.setText("");
        ResortList the_list = ResortList.getInstance();
        try {
            EditText et1 = (EditText) findViewById(R.id.edit_text_code);
            String usercode = et1.getText().toString();

            EditText et2 = (EditText) findViewById(R.id.edit_text_guests);
            double guests = Double.parseDouble(et2.getText().toString());

            EditText et3 = (EditText) findViewById(R.id.edit_text_nights);
            double nights = Double.parseDouble(et3.getText().toString());

            DecimalFormat df2 = new DecimalFormat(".##");

            for (int i = 0; i < the_list.size(); i++) {
                if (usercode.equals(the_list.get(i).getCode())) {
                    tv.append(the_list.get(i).getName() + "\n");
                    tv.append(the_list.get(i).getLocation() + "\n");

                    //Total 1
                    double total1 = the_list.get(i).getPpnpg() * guests * nights;
                    tv.append("Total Price: " + df2.format(total1) + "\n");

                    //Total 2
                    double total2 = the_list.get(i).getResortfee() * guests;
                    tv.append("Total Resort Fee: " + df2.format(total2) + "\n");

                    //Recheck this
                    double taxrate = the_list.get(i).getTaxrate() / 100;
                    tv.append("Taxrate: " + df2.format(taxrate) + "% \n");

                    double tax = taxrate * (total1 + total2);
                    tv.append("Tax: " + df2.format(tax) + "\n");


                    double grandtotal = total1 + total2 + tax;
                    tv.append("Grand Total: " + df2.format(grandtotal) + "\n");
                }
            }
            Toast.makeText(Option4.this,
                    "Found Resort",
                    Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(Option4.this,
                    "Failed to find resort, try again",
                    Toast.LENGTH_SHORT).show();
        }

    }

}
