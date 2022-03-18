package com.ParaMahalingam.readingdiaryapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EmailEntry extends AppCompatActivity {
    Button btnSend;
    EditText emailAddress, emailSubject, emailContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Email Entry");
        setContentView(R.layout.activity_email_entry);

        btnSend = (Button) findViewById(R.id.btnSend);
        emailAddress = (EditText) findViewById(R.id.txtEmailAddress);
        emailSubject = (EditText) findViewById(R.id.txtEmailSubject);
        emailContent = (EditText) findViewById(R.id.txtEmailContent);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            setTitle("Email Entry | ID: " + extras.getInt("ID"));
            emailContent.setText("Hi,\n\nTranscribe the following diary entry to the system.\n\nBook Title: " + extras.getString("BookTitle") + "\nDate: " + extras.getString("Date") + "\nPages Read: " + extras.getString("PagesRead") + "\nChild Comment: " + extras.getString("ChildComment") + "\nTeacher / Parent Comment: " + extras.getString("TPComment") + "\n\nThank you");
        }

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendEmail = new Intent(Intent.ACTION_SEND);
                sendEmail.setType("message/rfc822");
                sendEmail.putExtra(Intent.EXTRA_EMAIL, new String[]{emailAddress.getText().toString()});
                sendEmail.putExtra(Intent.EXTRA_SUBJECT, emailSubject.getText().toString());
                sendEmail.putExtra(Intent.EXTRA_TEXT, emailContent.getText().toString());
                try {
                    startActivity(Intent.createChooser(sendEmail, "Choose an Email Client"));
                    finish();
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(EmailEntry.this, "No Email Client Installed!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}