package com.kennyyou.project_1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static com.kennyyou.project_1.MainActivity.tv;

public class Option5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option5);
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

    public void Remove(View view) {
        tv.setText("");

        try {


            EditText et1 = (EditText) findViewById(R.id.edit_text_remove);
            String usercode = et1.getText().toString();
            ResortList the_list = ResortList.getInstance();
            boolean test = false;
            for (int i = 0; i < the_list.size(); i++) {
                System.out.println(the_list.get(i));
                if (usercode.equals(the_list.get(i).getCode())) {
                    the_list.remove(i);
                    test = true;
                }

            }
            if (test) {
                Toast.makeText(Option5.this,
                        "Resort Removed",
                        Toast.LENGTH_SHORT).show();
            }
        }
        catch (Exception e){
            Toast.makeText(Option5.this,
                    "Failed to remove resort",
                    Toast.LENGTH_SHORT).show();
        }


    }
}
