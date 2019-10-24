package com.juaracoding.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Date;

public class AddActivity extends AppCompatActivity {
    public static int RESULT_CODE=222;
    EditText txtTitle, txtNotes;
    CalendarView txtDate;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addactivity);

        txtTitle = findViewById(R.id.txttitle);
        txtDate = findViewById(R.id.kalender);
        txtNotes = findViewById(R.id.txtnote);

        btnSave = findViewById(R.id.buttonsave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToDoModel toDoModel = new ToDoModel(txtTitle.getText().toString(),new Date(txtDate.getDate()),txtNotes.getText().toString());

                Intent intent = new Intent();
                intent.putExtra("data",toDoModel);

                setResult(RESULT_CODE,intent);
                finish();

            }
        });
    }
}
