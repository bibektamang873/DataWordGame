package com.example.datawordgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.datawordgame.models.Student;


public class Db extends AppCompatActivity {

    EditText etName, etPhone, etEmail;
    DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        Button btnOK = findViewById(R.id.btnOK);
        Button btnDisplay = findViewById(R.id.btnDisplay);
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);

        dbHelper = new DbHelper(Db.this);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String phone = etPhone.getText().toString();
                String email = etEmail.getText().toString();

                boolean sts = dbHelper.insertStudent(new Student(0, name, email, phone));

                if(sts){
                    Toast.makeText(Db.this, "Student Added Successful!", Toast.LENGTH_SHORT).show();
                    etName.getText().clear();
                    etEmail.getText().clear();
                    etPhone.getText().clear();
                } else {
                    Toast.makeText(Db.this, "Something Went Wrong!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Db.this, DisplayActivity.class);
                startActivity(intent);
            }
        });

    }
}
