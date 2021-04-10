package com.example.lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import java.util.List;

public class activity_third extends AppCompatActivity {

    EditText editUserName;
    RatingBar editRatingBar;
    EditText editUserComment;
    String name = "";
    MyDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);


        database = MyDatabase.getInstance(this);
        editRatingBar = findViewById(R.id.edit_rating);
        editUserComment = findViewById(R.id.edit_user_comment);
        editUserName = findViewById(R.id.edit_user_name);

        Intent intent = getIntent();

        name = intent.getStringExtra("name");



        float editrating = database.userDAO().getRating(name);
        String editComment = database.userDAO().getComment(name);

        editRatingBar.setRating(editrating);
        editUserComment.setText(editComment);
        editUserName.setText(name);


    }



    public void deleteData(View view) {


        database.userDAO().deleteUserByName(editUserName.getText().toString());
        Toast.makeText(this, "Comment is deleted!", Toast.LENGTH_SHORT).show();


    }

    public void backToFirstPage(View view) {

        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);

    }

    public void backToReview(View view) {


        Intent intent = new Intent(this, activity_second.class);

        startActivity(intent);



    }

    public void updateComment(View view) {

        database.userDAO().updateData(editRatingBar.getRating(), editUserComment.getText().toString(), editUserName.getText().toString());

        Toast.makeText(this, "Comment is updated!", Toast.LENGTH_SHORT).show();
    }
}