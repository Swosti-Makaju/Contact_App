package com.example.contact.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contact.R;
import com.example.contact.activities.AddEditContactActivity;
import com.example.contact.adapter.ContactAdapter;
import com.example.contact.database.DBHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.recyclerView);
        FloatingActionButton fabAdd = findViewById(R.id.fabAdd);
        dbHelper = new DBHelper(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        fabAdd.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, AddEditContactActivity.class))
        );
    }

    @Override
    protected void onResume() {
        super.onResume();
        recyclerView.setAdapter(
                new ContactAdapter(dbHelper.getAllContacts(), this)
        );
    }
}
