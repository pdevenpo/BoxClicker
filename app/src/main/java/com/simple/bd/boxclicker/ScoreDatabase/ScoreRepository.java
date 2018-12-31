package com.simple.bd.boxclicker.ScoreDatabase;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import com.simple.bd.boxclicker.AppDatabase;
import com.simple.bd.boxclicker.GameActivity;
import com.simple.bd.boxclicker.R;


public class ScoreRepository {
    private AppDatabase db;

    public ScoreRepository(Context context){
        db = Room.databaseBuilder(context, AppDatabase.class, "ScoreDatabase").allowMainThreadQueries().build();
    }

    public void insertScore(int scoreId, int score, String timeStamp){
        Score s = new Score();
        s.setScoreId(scoreId);
        s.setScoreTotal(score);
        s.setTimeStamp("1.1.1");

        insertScoreHelper(s);
    }

    public void insertScoreHelper(final Score score){
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                Log.d("AsyncInsert", "ScoreID: " + score.getScoreId() + " ScoreTotal: " + score.getScoreTotal() + " added.");
                db.scoreDao().insert(score);
                return null;
            }
        }.execute();
    }

        public int getAmount(){
            int logScore = db.scoreDao().getAll();
            Log.d("AsyncInsert", "Amount of Entries: " + logScore + ".");
            return db.scoreDao().getAll();
        }

}
