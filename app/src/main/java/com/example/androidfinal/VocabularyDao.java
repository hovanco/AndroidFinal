package com.example.androidfinal;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

// buoc 1
@Dao
// buoc 2 chuyen tu class thanh interface
public interface VocabularyDao {
    // buoc 3
    @Query("SELECT * FROM vocabulary")
    List<Vocabulary> getAll();

    // buoc 4
    @Insert
    void insert(Vocabulary vocabulary);

    // buoc 5
    @Update
    void update(Vocabulary vocabulary);

    // buoc 6
    @Delete
    void delete(Vocabulary vocabulary);




}
