package com.ParaMahalingam.readingdiaryapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class NewEntry extends AppCompatActivity {
    Button btnCreateEntry;
    Entry entryDB;
    EditText booktitle, pagesread, childcomment, tpcomment;
    DatePicker datePicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_entry);

        entryDB = new Entry(this);

        btnCreateEntry = (Button) findViewById(R.id.btnCreate);
        booktitle = (EditText) findViewById(R.id.txtBookTitle);
        pagesread = (EditText) findViewById(R.id.txtPagesRead);
        childcomment = (EditText) findViewById(R.id.txtChildComment);
        tpcomment = (EditText) findViewById(R.id.txtTPComment);
        datePicker = (DatePicker) findViewById(R.id.datePicker);

        btnCreateEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entryDB.addNewEntry(booktitle.getText().toString(), datePicker.getDayOfMonth() + "/" +datePicker.getMonth() + "/" + datePicker.getYear() , pagesread.getText().toString(), childcomment.getText().toString(), tpcomment.getText().toString());
//                startActivity(new Intent(MainActivity.this, NewEntry.class));
            }
        });
    }
}