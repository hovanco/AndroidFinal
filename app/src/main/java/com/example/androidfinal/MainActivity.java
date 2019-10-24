package com.example.androidfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import static android.widget.Toast.LENGTH_SHORT;

// buoc 9
public class MainActivity extends AppCompatActivity implements VocabularyAdapter.OnItemClicked{
    //buoc 1
    public Button ButtonAdd;

    // buoc 7
    AppDatabase db;
    RecyclerView recyclerviewVocabulary;
    VocabularyAdapter vocabularyAdapter;
    public static List<Vocabulary> vocabularies;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // buoc 8
        recyclerviewVocabulary = findViewById(R.id.recycler_view_vocabulary);
        recyclerviewVocabulary.setLayoutManager(new LinearLayoutManager((this)));

        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name").build();



        // buoc 2
        // buoc 3
        ButtonAdd = findViewById(R.id.btnAdd);
        ButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // buoc 2
                //Toast.makeText(MainActivity.this, "YOUR MESSAGE", LENGTH_SHORT).show();

                // buoc 3
                openAddScreen();

            }
        });

    }
    // buoc 4
    // Hàm để xuất ra màn hình những data đã adđ được
    public void getAllStudent() {
        new AsyncTask<Void, Void, List<Vocabulary>>() {
            @Override
            protected List<Vocabulary> doInBackground(Void... voids) {
                vocabularies = db.vocabularyDao().getAll();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        vocabularyAdapter = new VocabularyAdapter(this, vocabularies);
                        vocabularyAdapter.setOnClick(MainActivity.this);
                        recyclerviewVocabulary.setAdapter(vocabularyAdapter);
                        //Toast.makeText(MainActivity.this, "size" + memories.size(), Toast.LENGTH_SHORT).show();
                    }
                });
                return null;
            }
        }.execute();
    }
    // buoc 6
    @Override
    protected void onResume() {
        super.onResume();
        getAllStudent();
    }

    // buoc 5
    public void openAddScreen() {
        Intent intent = new Intent(MainActivity.this, Add.class);
        startActivity(intent);
    }

    // buoc 10
    @Override
    public void onItemDeleteClick(int position) {
        deleteVocabulary(position);
    }

    // buoc 11
    void deleteVocabulary(final int position){
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                db.vocabularyDao().delete(vocabularyAdapter.getVocabularies().get(position));
                return null;
            }
            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                vocabularyAdapter.getVocabularies().remove(position);
                vocabularyAdapter.notifyDataSetChanged();
            }
        }.execute();
    }
}
