package com.ParaMahalingam.readingdiaryapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Entry entryDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        entryDB = new Entry(this);



        Button btn = (Button)findViewById(R.id.openNewEntryButton);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //entryDB.addNewEntry("test","01/01/2020","1-5","I like books!","I am glad you liked the book!");
                startActivity(new Intent(MainActivity.this, NewEntry.class));
            }
        });
    }



}