package com.example.androidroom.Data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.androidroom.Model.Contact;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface ContactDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Contact contact);

    @Query("DELETE FROM contacts_table")
    void DeleteAll();

    @Query("SELECT * FROM contacts_table")
   LiveData<List<Contact>> getAll();

}
