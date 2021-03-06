package com.simple.bd.boxclicker.ScoreDatabase;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface ScoreDao {
    @Query("SELECT MAX(score) FROM score")
    int getAll();
//
//    @Query("DELETE FROM recipe")
//    void deleteRecipeTable();
//
//    @Query("SELECT * FROM recipe WHERE name LIKE :recipeName")
//    Recipe findByRecipeId(String recipeName);
//
        @Insert(onConflict = OnConflictStrategy.REPLACE)
        void insert(Score score);

        @Query("SELECT COUNT(*) from score")
        int getAmount();

        //@Query("SELECT COUNT(*) from score ")



}
