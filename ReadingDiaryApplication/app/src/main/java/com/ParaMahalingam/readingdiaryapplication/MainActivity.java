package com.ParaMahalingam.readingdiaryapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    DiaryDatabase diaryDatabaseDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        diaryDatabaseDB = new DiaryDatabase(this);


//        fragmentOrActivity.yourArray.remove(holder.getAdapterPosition());
//        fragmentOrActivity.yourAdapter.notifyDataSetChanged();
//

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new CustomAdapter(diaryDatabaseDB.getAllEntries()));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));






//        Button btn = (Button)findViewById(R.id.openNewEntryButton);
        FloatingActionButton btn = (FloatingActionButton) findViewById(R.id.openNewEntryButton);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //entryDB.addNewEntry("test","01/01/2020","1-5","I like books!","I am glad you liked the book!");
                startActivity(new Intent(MainActivity.this, NewEntry.class));
            }
        });
    }

    private List<String> generateData() {
        List<String> data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            data.add(String.valueOf(i) + "th Element");
        }
        return data;
    }



}