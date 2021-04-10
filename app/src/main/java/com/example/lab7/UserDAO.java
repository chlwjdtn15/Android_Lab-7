package com.example.lab7;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDAO {


    @Insert
    public void addUser(User u);


    @Query("Delete from users")
    public void deleteUser();

    @Query("Delete from users where name = :editName")
    public void deleteUserByName(String editName);


    @Query("select * from users")
    public List<User> getAll();

    @Query("select rating from users where name = :editName")
    float getRating(String editName);

    @Query("select comment from users where name = :editName")
    String getComment(String editName);

    @Query("UPDATE users SET rating =:editRating, comment =:editComment WHERE name = :editName")
    public void updateData(double editRating, String editComment, String editName );

}
