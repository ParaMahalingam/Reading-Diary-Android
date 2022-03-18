package com.ParaMahalingam.readingdiaryapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class EditEntry extends AppCompatActivity {
    Button btnModifyEntry;
    DiaryDatabase diaryDatabaseDB;
    EditText booktitle, pagesread, childcomment, tpcomment;
    DatePicker datePicker;
    Integer ID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Edit Entry");
        setContentView(R.layout.activity_edit_entry);

        diaryDatabaseDB = new DiaryDatabase(this);

        btnModifyEntry = (Button) findViewById(R.id.btnUpdate);
        booktitle = (EditText) findViewById(R.id.txtEditBookTitle);
        pagesread = (EditText) findViewById(R.id.txtEditPagesRead);
        childcomment = (EditText) findViewById(R.id.txtEditChildComment);
        tpcomment = (EditText) findViewById(R.id.txtEditTPComment);
        datePicker = (DatePicker) findViewById(R.id.EditdatePicker);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            ID = extras.getInt("ID");
            booktitle.setText(extras.getString("BookTitle"));
            String[] dateSplit = extras.getString("Date").split("/");
            datePicker.updateDate(Integer.parseInt(dateSplit[2]), Integer.parseInt(dateSplit[1]) - 1, Integer.parseInt(dateSplit[0]));
            pagesread.setText(extras.getString("PagesRead"));
            childcomment.setText(extras.getString("ChildComment"));
            tpcomment.setText(extras.getString("TPComment"));
            setTitle("Edit Entry | ID: " + ID);
        }

        btnModifyEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(booktitle.getText()) | TextUtils.isEmpty(pagesread.getText()) | TextUtils.isEmpty(childcomment.getText()) | TextUtils.isEmpty(tpcomment.getText())) {
                    Toast.makeText(EditEntry.this, "All fields are required!", Toast.LENGTH_SHORT).show();
                } else {
                    diaryDatabaseDB.updateEntry(ID, booktitle.getText().toString(), datePicker.getDayOfMonth() + "/" + (datePicker.getMonth() + 1) + "/" + datePicker.getYear(), pagesread.getText().toString(), childcomment.getText().toString(), tpcomment.getText().toString());
                    Toast.makeText(EditEntry.this, "Entry has been modified!", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(EditEntry.this, MainActivity.class));
                }
            }
        });
    }
}