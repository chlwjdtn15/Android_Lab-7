package com.example.lab7;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = User.class, version =  2)
public abstract class MyDatabase extends RoomDatabase {

    public abstract UserDAO userDAO();


    public static MyDatabase instance;

    public static MyDatabase getInstance(Context context){

        if( instance == null ){

            instance = Room.databaseBuilder(context, MyDatabase.class, "MyDB")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();

        }


        return instance;


    }


}
