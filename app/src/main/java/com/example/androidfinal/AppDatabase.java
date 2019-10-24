package com.example.androidfinal;

import androidx.room.Database;
import androidx.room.RoomDatabase;

// buoc 1
@Database(entities = {Vocabulary.class}, version = 1)

// buoc 2 doi class thanh abstract va copy
public abstract class AppDatabase extends RoomDatabase {
    public abstract VocabularyDao vocabularyDao();
}
