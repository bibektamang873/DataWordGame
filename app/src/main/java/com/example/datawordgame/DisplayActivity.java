package com.example.datawordgame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.datawordgame.Adaptor.StdAdapter;
import com.example.datawordgame.models.Student;

import java.util.List;


public class DisplayActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Button btnBackToAddStudents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_student);
        recyclerView = findViewById(R.id.recyclerViewStudents);
        btnBackToAddStudents = findViewById(R.id.btnBackToAdd);

        DbHelper dbHelper = new DbHelper(DisplayActivity.this);
        List<Student> studentList = dbHelper.displayStudents();

        StdAdapter studentAdapter = new StdAdapter(DisplayActivity.this, studentList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(studentAdapter);

        btnBackToAddStudents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DisplayActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
