package com.juaracoding.todolist;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static int REQUEST_CODE = 111;
    public ArrayList<ToDoModel> itemList = new ArrayList<ToDoModel>();

    Button btnTambah;
    RecyclerView lstTodo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTambah = findViewById(R.id.buttontambah);
        lstTodo = findViewById(R.id.listdo);


        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AddActivity.class);
                startActivityForResult(intent,REQUEST_CODE);
            }
        });
        setList();
    }

    public void setList() {
        ToDoListAdapter itemArrayAdapter = new ToDoListAdapter(R.layout.item_todolist, itemList);

        lstTodo.setLayoutManager(new LinearLayoutManager(this));
        lstTodo.setItemAnimator(new DefaultItemAnimator());
        lstTodo.setAdapter(itemArrayAdapter);
    }

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == MainActivity.REQUEST_CODE && resultCode == AddActivity.RESULT_CODE){
            ToDoModel toDoModel = data.getParcelableExtra("data");

            itemList.add(toDoModel);
            setList();
            Toast.makeText(MainActivity.this, toDoModel.getTitle()+""+toDoModel.getTanggal().toString()+""+toDoModel.getNotes().toString(),Toast.LENGTH_LONG).show();
        }
    }
}
