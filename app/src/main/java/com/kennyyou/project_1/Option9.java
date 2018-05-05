package com.kennyyou.project_1;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import static com.kennyyou.project_1.MainActivity.tv;

public class Option9 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option9);
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

    public void URL1(View view) throws MalformedURLException {
        try {

            ResortList the_list = ResortList.getInstance();
            EditText et1 = (EditText) findViewById(R.id.edit_text_load1);
            String usercode = et1.getText().toString();

            //Open Scanner
            URL file_url = new URL(usercode);
            Scanner scan = new Scanner(file_url.openStream());


            //remove the entire list
            while(the_list.size() > 0){
                the_list.remove();
            }
            //Reads list + puts into Resortlist
            while (scan.hasNext()) {
                the_list.add(new Resort(scan.nextLine(), scan.nextLine(), scan.nextLine(), Integer.parseInt(scan.nextLine()),
                        Double.parseDouble(scan.nextLine()), Double.parseDouble(scan.nextLine()), Double.parseDouble(scan.nextLine()),
                        scan.nextLine()));
            }

            scan.close();
            Toast.makeText(Option9.this,
                    "List updated",
                    Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(Option9.this,
                    "Failed to find file",
                    Toast.LENGTH_SHORT).show();
        }
    }
}