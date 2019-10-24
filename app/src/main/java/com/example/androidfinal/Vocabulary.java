package com.example.androidfinal;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

//buoc 1
@Entity
public class Vocabulary {
    //buoc 2, copy 2 cai cung mot luc
    @PrimaryKey(autoGenerate = true)
    private int id;

    // buoc 3 khai bao thuoc tinh
    private String vocabulary;
    private String mean;

    // buoc 4 khai bao ham set va get

    // buoc 5: Alt + insert -> shift + chon 3 cai
    public Vocabulary(int id, String vocabulary, String mean) {
        this.id = id;
        this.vocabulary = vocabulary;
        this.mean = mean;
    }

    // buoc 6
    public Vocabulary(){

    }


    // buoc 7: Alt + Insert -> Get +Set -> Chon 3 cai
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVocabulary() {
        return vocabulary;
    }

    public void setVocabulary(String vocabulary) {
        this.vocabulary = vocabulary;
    }

    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }
}
