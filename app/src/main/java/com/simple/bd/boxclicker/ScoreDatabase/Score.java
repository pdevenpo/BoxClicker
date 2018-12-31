package com.simple.bd.boxclicker.ScoreDatabase;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;

//import com.google.common.reflect.TypeToken;
//import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.ArrayList;

@Entity(tableName = "Score")
public class Score {
    //id number of the score we wish to view
    @PrimaryKey
    @android.support.annotation.NonNull
    private int scoreId;

    //score
    @ColumnInfo(name = "score")
    private int scoreTotal;

    //score time
    @ColumnInfo(name = "time")
    private String timeStamp;

    //score
    public int getScoreTotal(){return scoreTotal;}
    public void setScoreTotal(int scoreTotal) { this.scoreTotal = scoreTotal;}
    public int getScoreId() {
        return scoreId;
    }
    public void setScoreId(int scoreId) {
        this.scoreId = scoreId;
    }
    public String getTimeStamp() {
        return timeStamp;
    }
    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

}

