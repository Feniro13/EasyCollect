package com.Feniro.collectionapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;

import com.Feniro.collectionapp.adapter.CollectionAdapter;
import com.Feniro.collectionapp.database.GlobalDatabase;
import com.Feniro.collectionapp.database.entities.DatabaseGlobalEntities;

import java.util.ArrayList;
import java.util.List;

public class CollectionEdit extends AppCompatActivity {
    RecyclerView collectionRecycler;
    CollectionAdapter collectionAdapter;

    List<String> list;
    GlobalDatabase globalDatabase;
    List<DatabaseGlobalEntities> listGlobal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_collections);

        list = new ArrayList<>();
        globalDatabase = GlobalDatabase.getDatabase(this); // Глобальная база данных
        listGlobal = globalDatabase.dao_global().getAll();// Записи в виде малых баз данных
        if(listGlobal.size() > 0) {
            for (int i = 0; i < listGlobal.size(); i++) {                // получение названий
                list.add(listGlobal.get(i).name);
            }
            setCollectionRecycler(list);
        }

    }
    public void setCollectionRecycler(List<String> list) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        collectionRecycler = findViewById(R.id.CollectionRecycler);
        collectionRecycler.setLayoutManager(layoutManager);
        ViewGroup viewGroup = findViewById(android.R.id.content);
        collectionAdapter = new CollectionAdapter(this, list, viewGroup);
        collectionRecycler.setAdapter(collectionAdapter);
    }
    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(CollectionEdit.this, ActivityStart.class);
        startActivity(intent);
    }

}


