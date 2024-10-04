package com.example.smart_phone_application_assignment_03;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextTouristName, editTextTouristEmail, editTextPhoneNumber;
    private Spinner spinnerRoomQuality;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editTextTouristName = findViewById(R.id.editTextTouristName);
        editTextTouristEmail = findViewById(R.id.editTextTouristEmail);
        editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber);
        spinnerRoomQuality = findViewById(R.id.spinnerRoomQuality);
        buttonSubmit = findViewById(R.id.buttonSubmit);


        String[] roomQualities = {"Select Room Quality", "3 Star", "5 Star", "7 Star"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, roomQualities);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRoomQuality.setAdapter(adapter);


        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateForm();
            }
        });
    }


    private void validateForm() {
        String name = editTextTouristName.getText().toString().trim();
        String email = editTextTouristEmail.getText().toString().trim();
        String phone = editTextPhoneNumber.getText().toString().trim();
        String roomQuality = spinnerRoomQuality.getSelectedItem().toString();


        if (!name.matches("[a-zA-Z\\s]+")) {
            editTextTouristName.setError("Enter a valid name (letters only)");
            return;
        }


        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (!email.matches(emailPattern)) {
            editTextTouristEmail.setError("Enter a valid email address");
            return;
        }


        if (!phone.matches("^[0-9]{11}$")) {
            editTextPhoneNumber.setError("Enter a valid 11-digit phone number");
            return;
        }


        if (roomQuality.equals("Select Room Quality")) {
            Toast.makeText(this, "Please select a room quality", Toast.LENGTH_SHORT).show();
            return;
        }


        Toast.makeText(this, "Form Submitted Successfully\n" +
                "Name: " + name + "\n" +
                "Email: " + email + "\n" +
                "Phone: " + phone + "\n" +
                "Room: " + roomQuality, Toast.LENGTH_LONG).show();
    }
}
