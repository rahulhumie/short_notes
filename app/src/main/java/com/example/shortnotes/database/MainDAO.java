package com.example.shortnotes.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.shortnotes.models.Notes;

import java.util.List;

@Dao
public interface MainDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Notes notes);

    @Query("SELECT * FROM notes ORDER BY Id DESC")
    List<Notes> getAll();

    @Query("UPDATE notes SET title = :title, notes = :notes WHERE Id = :id")
    void update(int id, String title, String notes);

    @Delete
    void delete(Notes notes);

    @Query("UPDATE notes SET pinned = :pin Where ID = :id")
    void pin (int id , boolean pin);
}
