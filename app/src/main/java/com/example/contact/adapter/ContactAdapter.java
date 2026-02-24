package com.example.contact.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contact.R;
import com.example.contact.activities.AddEditContactActivity;
import com.example.contact.database.DBHelper;
import com.example.contact.model.Contact;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    private List<Contact> list;
    private Context context;

    public ContactAdapter(List<Contact> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context)
                .inflate(R.layout.item_contact, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Contact c = list.get(position);
        holder.name.setText(c.getName());
        holder.phone.setText(c.getPhone());

        // Open Add/Edit screen when clicking the contact
        holder.itemView.setOnClickListener(v -> {
            Intent i = new Intent(context, AddEditContactActivity.class);
            i.putExtra("id", c.getId());
            i.putExtra("name", c.getName());
            i.putExtra("phone", c.getPhone());
            context.startActivity(i);
        });

        // Delete contact when clicking the delete button
        holder.btnDelete.setOnClickListener(v -> {
            new AlertDialog.Builder(context)
                    .setTitle("Delete Contact")
                    .setMessage("Are you sure you want to delete this contact?")
                    .setPositiveButton("Yes", (dialog, which) -> {
                        // Delete from database
                        DBHelper dbHelper = new DBHelper(context);
                        dbHelper.deleteContact(c.getId());

                        // Remove from list and update RecyclerView
                        list.remove(position);
                        notifyItemRemoved(position);
                        notifyItemRangeChanged(position, list.size());
                    })
                    .setNegativeButton("No", null)
                    .show();
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, phone;
        Button btnDelete;

        ViewHolder(View v) {
            super(v);
            name = v.findViewById(R.id.tvName);
            phone = v.findViewById(R.id.tvPhone);
            btnDelete = v.findViewById(R.id.btnDelete);
        }
    }
}