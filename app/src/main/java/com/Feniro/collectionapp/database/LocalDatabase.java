package com.Feniro.collectionapp.database;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.Feniro.collectionapp.database.dao.DAO_Global;
import com.Feniro.collectionapp.database.dao.DAO_Local;
import com.Feniro.collectionapp.database.entities.DatabaseLocalEntities;

@androidx.room.Database(entities = {DatabaseLocalEntities.class}, version = 1)
public abstract class LocalDatabase extends RoomDatabase {
    public abstract DAO_Local dao();
    public static LocalDatabase INSTANCE;
    public static LocalDatabase getDatabase(Context context) {
        if(INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), LocalDatabase.class, "localDatabase").allowMainThreadQueries().build();
        }
        return INSTANCE;
    }
}
