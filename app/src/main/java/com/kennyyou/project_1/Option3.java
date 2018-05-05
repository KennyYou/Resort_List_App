package com.kennyyou.project_1;

import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;

import java.text.DecimalFormat;

import static com.kennyyou.project_1.MainActivity.tv;

public class Option3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option3);
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

    public void Find(View view) {

        TextView tv1 = (TextView) findViewById(R.id.text_main_1);
        tv1.setText("");
        EditText et2 = (EditText) findViewById(R.id.edit_text);
        String usercode = et2.getText().toString();

        ResortList the_list = ResortList.getInstance();
        try {
            for (int i = 0; i < the_list.size(); i++) {
                if (usercode.equals(the_list.get(i).getCode())) {
                    tv1.append(the_list.get(i).getName() + "\n");
                    tv1.append(the_list.get(i).getLocation() + "\n");

                    //Resort getage = new getage(the_list.get(i).getYear());
                    if (the_list.get(i).getYear() - 2018 == 0) {
                        tv1.append("Newly Opened" + "\n");
                    } else {
                        tv1.append(2018 - the_list.get(i).getYear() + "\n");
                    }


                    tv1.append(the_list.get(i).getPpnpg() + "\n");

                    tv1.append(the_list.get(i).getResortfee() + "\n");

                    double test = the_list.get(i).getTaxrate() / 100;
                    DecimalFormat df2 = new DecimalFormat(".##");
                    tv1.append( the_list.get(i).getTaxrate() + "%" + "\n");

                    //This displays a image in the current textview
                    String image_url = the_list.get(i).getImageURL();
                    Uri uri = Uri.parse(image_url); // image_url is a string
                    SimpleDraweeView draweeView = (SimpleDraweeView) findViewById(R.id.image_area);
                    draweeView.setImageURI(uri);

                    Toast.makeText(Option3.this,
                            "Resort Information found",
                            Toast.LENGTH_SHORT).show();
                }
            }
        } catch (Exception e) {
            Toast.makeText(Option3.this,
                    "Failed to find resort",
                    Toast.LENGTH_SHORT).show();
        }

    }
}
