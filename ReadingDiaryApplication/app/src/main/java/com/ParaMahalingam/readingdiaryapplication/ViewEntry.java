package com.ParaMahalingam.readingdiaryapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ViewEntry extends AppCompatActivity {
TextView lblBookTitle, lblDate, lblPagesRead, lblChildComment, lblTPComment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_entry);

        lblBookTitle = (TextView) findViewById(R.id.lblBookTitle);
        lblDate = (TextView) findViewById(R.id.lblDate);
        lblPagesRead = (TextView) findViewById(R.id.lblPagesRead);
        lblChildComment = (TextView) findViewById(R.id.lblChildComment);
        lblTPComment = (TextView) findViewById(R.id.lblTPComment);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            lblBookTitle.setText(extras.getString("BookTitle"));
            lblDate.setText(extras.getString("Date"));
            lblPagesRead.setText(extras.getString("PagesRead"));
            lblChildComment.setText(extras.getString("ChildComment"));
            lblTPComment.setText(extras.getString("TPComment"));
            //The key argument here must match that used in the other activity
        }
    }
}