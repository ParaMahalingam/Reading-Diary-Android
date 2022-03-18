package com.ParaMahalingam.readingdiaryapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Entry> data;
    DiaryDatabase diaryDatabaseDB;

    public CustomAdapter(Context context, ArrayList<Entry> data) {
        this.context = context;
        diaryDatabaseDB = new DiaryDatabase(context);
        this.data = data;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView entryTitle;
        private final TextView entryDate;

        public ViewHolder(View view) {
            super(view);

            entryTitle = view.findViewById(R.id.entryTitle);
            entryDate = view.findViewById(R.id.entryDate);
        }
    }


    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.entry, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, @SuppressLint("RecyclerView") final int position) {

        //Open the View Entry screen with selected entry details for displaying.
        viewHolder.itemView.findViewById((R.id.viewButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //This required an independant research to figure out how to send data to another screen.
                Intent viewScreen = new Intent(view.getContext(), ViewEntry.class);
                viewScreen.putExtra("BookTitle", data.get(position).getBookTitle());
                viewScreen.putExtra("Date", data.get(position).getDate());
                viewScreen.putExtra("PagesRead", data.get(position).getPagesRead());
                viewScreen.putExtra("ChildComment", data.get(position).getChildComment());
                viewScreen.putExtra("TPComment", data.get(position).getTPComment());
                view.getContext().startActivity(viewScreen);
            }
        });

        //Open the Edit Entry screen with selected entry details for modifying.
        viewHolder.itemView.findViewById((R.id.editButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //This required an independant research to figure out how to send data to another screen.
                Intent editScreen = new Intent(view.getContext(), EditEntry.class);
                editScreen.putExtra("ID", data.get(position).getID());
                editScreen.putExtra("BookTitle", data.get(position).getBookTitle());
                editScreen.putExtra("Date", data.get(position).getDate());
                editScreen.putExtra("PagesRead", data.get(position).getPagesRead());
                editScreen.putExtra("ChildComment", data.get(position).getChildComment());
                editScreen.putExtra("TPComment", data.get(position).getTPComment());
                view.getContext().startActivity(editScreen);
            }
        });

        //Open the Email Entry screen with selected entry details for sending an Email.
        viewHolder.itemView.findViewById((R.id.sendButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //This required an independant research to figure out how to send data to another screen.
                Intent emailScreen = new Intent(view.getContext(), EmailEntry.class);
                emailScreen.putExtra("ID", data.get(position).getID());
                emailScreen.putExtra("BookTitle", data.get(position).getBookTitle());
                emailScreen.putExtra("Date", data.get(position).getDate());
                emailScreen.putExtra("PagesRead", data.get(position).getPagesRead());
                emailScreen.putExtra("ChildComment", data.get(position).getChildComment());
                emailScreen.putExtra("TPComment", data.get(position).getTPComment());
                view.getContext().startActivity(emailScreen);
            }
        });

        //Delete selected entry from the database
        viewHolder.itemView.findViewById((R.id.deleteButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                diaryDatabaseDB.deleteEntry(data.get(position).getID());
                data = diaryDatabaseDB.getAllEntries();
                notifyDataSetChanged();
            }
        });


        viewHolder.entryDate.setText(this.data.get(position).getDate());
        viewHolder.entryTitle.setText(this.data.get(position).getBookTitle());
    }

    //Search filtering. Filter using the Entry Title, Date, Pages Read, Child Comment, and Teacher / Parent Comment.
    public void filter(String text) {
        text = text.toLowerCase();
        data.clear();

        if (text.isEmpty()) {
            data.addAll(diaryDatabaseDB.getAllEntries());
        } else {
            for (Entry entry : diaryDatabaseDB.getAllEntries()) {
                if (entry.getBookTitle().toLowerCase().contains(text) || entry.getDate().toLowerCase().contains(text) || entry.getPagesRead().toLowerCase().contains(text) || entry.getChildComment().toLowerCase().contains(text) || entry.getTPComment().toLowerCase().contains(text)) {
                    data.add(entry);
                }
            }
        }
        notifyDataSetChanged();
    }

    // Return the size of entries ArrayList.
    @Override
    public int getItemCount() {
        return this.data.size();
    }
}
