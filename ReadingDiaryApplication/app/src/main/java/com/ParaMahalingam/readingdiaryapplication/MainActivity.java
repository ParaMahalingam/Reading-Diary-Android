package com.ParaMahalingam.readingdiaryapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    DiaryDatabase diaryDatabaseDB;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Entries");
        setContentView(R.layout.activity_main);
        //Create instance of the Database
        diaryDatabaseDB = new DiaryDatabase(this);

        adapter = new CustomAdapter(this, diaryDatabaseDB.getAllEntries());


        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

//Create a Floating button (New Entry button)
        FloatingActionButton btn = (FloatingActionButton) findViewById(R.id.openNewEntryButton);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NewEntry.class));
            }
        });
    }

    @Override
    //Display a search bar on the action bar. Calls the filter() method with a query parameter to filter the results
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.searchbar, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView entriesSearch = (SearchView) menuItem.getActionView();
        entriesSearch.setQueryHint("Search Entries by title, date, etc");

        entriesSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter.filter(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.filter(newText);
                return true;
            }
        });


        return super.onCreateOptionsMenu(menu);
    }
}