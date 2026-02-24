package com.example.contact.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.contact.R;
import com.example.contact.database.DBHelper;
import com.example.contact.model.Contact;

public class AddEditContactActivity extends AppCompatActivity {

    EditText etName, etPhone;
    DBHelper dbHelper;
    int contactId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_edit);

        etName = findViewById(R.id.etName);
        etPhone = findViewById(R.id.etPhone);
        Button btnSave = findViewById(R.id.btnSave);

        dbHelper = new DBHelper(this);

        // If editing an existing contact
        if (getIntent().hasExtra("id")) {
            contactId = getIntent().getIntExtra("id", -1);
            etName.setText(getIntent().getStringExtra("name"));
            etPhone.setText(getIntent().getStringExtra("phone"));
        }

        btnSave.setOnClickListener(v -> {
            String name = etName.getText().toString().trim();
            String phone = etPhone.getText().toString().trim();

            // Validate input
            if (name.isEmpty()) {
                etName.setError("Name is required");
                etName.requestFocus();
                return;
            }

            if (phone.isEmpty()) {
                etPhone.setError("Phone number is required");
                etPhone.requestFocus();
                return;
            }

            if (contactId == -1) {
                // Add new contact
                dbHelper.addContact(new Contact(name, phone));
                Toast.makeText(this, "Contact added", Toast.LENGTH_SHORT).show();
            } else {
                // Update existing contact
                dbHelper.updateContact(new Contact(contactId, name, phone));
                Toast.makeText(this, "Contact updated", Toast.LENGTH_SHORT).show();
            }

            finish();
        });
    }
}
 