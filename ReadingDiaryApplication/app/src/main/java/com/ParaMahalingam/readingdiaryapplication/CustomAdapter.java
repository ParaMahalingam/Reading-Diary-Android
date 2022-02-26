package com.ParaMahalingam.readingdiaryapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private ArrayList<Entry> data;

    public CustomAdapter(ArrayList<Entry> data) {
        this.data = data;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView entryTitle;
        private final TextView entryDate;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

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
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element

        viewHolder.entryDate.setText(this.data.get(position).getDate());
        viewHolder.entryTitle.setText(this.data.get(position).getBookTitle());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return this.data.size();
    }
}
