package com.kennyyou.project_1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import static com.kennyyou.project_1.MainActivity.tv;

public class Option10 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option10);
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

    public void Save(View view)
            throws java.io.IOException {
        tv.setText("");
        try {

            ResortList the_list = ResortList.getInstance();

            EditText et1 = (EditText) findViewById(R.id.edit_text_save);
            String outfile = et1.getText().toString();

            File writefile = new File(getExternalFilesDir(null), outfile); //outfile is user specified
            FileWriter fw = new FileWriter(writefile);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            //Printing out the list
            for (int j = 0; j < the_list.size(); j++) {
                pw.append(the_list.get(j).getName() + "\n");
                pw.append(the_list.get(j).getLocation() + "\n");
                pw.append(the_list.get(j).getCode() + "\n");
                pw.append(String.valueOf(the_list.get(j).getYear()) + "\n");
                pw.append(String.valueOf(the_list.get(j).getPpnpg()) + "\n");
                pw.append(String.valueOf(the_list.get(j).getResortfee()) + "\n");
                pw.append(String.valueOf(the_list.get(j).getTaxrate()) + "\n");
                pw.append(the_list.get(j).getImageURL());
            }

            //close the writer
            pw.close();

            Toast.makeText(Option10.this,
                    "File Saved",
                    Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Toast.makeText(Option10.this,
                    "Failed to save file",
                    Toast.LENGTH_SHORT).show();

        }

    }
}

