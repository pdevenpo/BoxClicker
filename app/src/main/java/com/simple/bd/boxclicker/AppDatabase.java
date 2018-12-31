package com.simple.bd.boxclicker;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.simple.bd.boxclicker.ScoreDatabase.Score;
import com.simple.bd.boxclicker.ScoreDatabase.ScoreDao;

@Database(entities={Score.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ScoreDao scoreDao();

}