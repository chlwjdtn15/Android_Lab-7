package com.example.lab7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.List;

public class activity_second extends AppCompatActivity {


    MyDatabase database;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        database = MyDatabase.getInstance(this);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);


        new Thread(new Runnable() {
            @Override
            public void run() {
                List<User> userList = database.userDAO().getAll();



                MyAdaptor adaptor = new MyAdaptor(userList);


                recyclerView.setLayoutManager(new LinearLayoutManager(activity_second.this));

                recyclerView.setAdapter(adaptor);
            }
        }).start();


    }

    public void backToFirstPage(View view) {
        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);


    }
}