package com.ParaMahalingam.readingdiaryapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class EditEntry extends AppCompatActivity {
    TextView lblEditScreen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_entry);

        lblEditScreen = (TextView) findViewById(R.id.lblEditScreen);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("key");
            lblEditScreen.setText(value);
            //The key argument here must match that used in the other activity
        }

    }
}