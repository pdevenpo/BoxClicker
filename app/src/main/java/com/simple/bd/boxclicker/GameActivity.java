package com.simple.bd.boxclicker;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.simple.bd.boxclicker.ScoreDatabase.Score;
import com.simple.bd.boxclicker.ScoreDatabase.ScoreDao;
import com.simple.bd.boxclicker.ScoreDatabase.ScoreRepository;

import java.util.ArrayList;
import java.util.List;

public class GameActivity extends AppCompatActivity {

    private String VALUE_STATE_KEY;
    private static TextView mValueTextView;
    private static TextView mTimeTextView;

    private Button buttons[] = new Button[9];
    private static int mCurrentScore = 0;
    private static Score mScore;
    private static ScoreRepository mScoreRepository;
    private static int scoreId = 0;
    private static final int[] BUTTON_ID={
            R.id.blackButton1,
            R.id.blackButton2,
            R.id.blackButton3,
            R.id.blackButton4,
            R.id.blackButton5,
            R.id.blackButton6,
            R.id.blackButton7,
            R.id.blackButton8,
            R.id.blackButton9,
    };
    private long lastClickTime = 0;
    private static List<Double>mTimeAverageArray = new ArrayList<Double>();
    private double castTime;
    private double avgTime;
    private int arrayListSize = 1;
    private double timeSum =0.0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //initialize DB
        mScore = new Score();
        mScoreRepository = new ScoreRepository(getBaseContext());
        //grab text view
        mTimeAverageArray.add(0.0);
        setContentView(R.layout.activity_game);
        mValueTextView = findViewById(R.id.valueString);
        mTimeTextView = findViewById(R.id.timeString);
        //create button array
        for(int i = 0;i <9;i++){
            String buttonNum = "blackButton" + i;
            buttons[i] = findViewById(BUTTON_ID[i]);
        }
        //hide all buttons besides start button
        for(int i = 1; i<9;i++){
            buttons[i].setVisibility(View.GONE);
        }

        //handle rotations
        if (savedInstanceState != null && mValueTextView != null) {
            mCurrentScore = savedInstanceState.getInt(VALUE_STATE_KEY);
            mValueTextView.setText(Integer.toString(mCurrentScore));
        }else if(mValueTextView != null){
            mValueTextView.setText(Integer.toString(mCurrentScore));
        }

        //check database if user already has begun playing to retrieve current score after app close
        if(mScoreRepository.getAmount()>0){
            mValueTextView.setText(Integer.toString(mScoreRepository.getAmount()));
            mCurrentScore = mScoreRepository.getAmount();
            scoreId = mScoreRepository.getAmount();
            mScore.setScoreId(scoreId);
            mScore.setScoreTotal(mCurrentScore);
            mScore.setTimeStamp("testTime");
            mScoreRepository.insertScore(mScore.getScoreTotal(),mScore.getScoreId(),mScore.getTimeStamp());
        }else{
            mScore.setScoreId(0);
            mScore.setScoreTotal(0);
            mScore.setTimeStamp("0");
            mScoreRepository.insertScore(mScore.getScoreTotal(),mScore.getScoreId(),mScore.getTimeStamp());
        }
        final long bootTime = SystemClock.elapsedRealtime();
        lastClickTime = bootTime;

        //TODO Fix time avg math, divide by 1000, fix styling
        //TODO save time avg to sql database on activity destroy to save total all time
        //click listeners for buttons
        buttons[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueUpdateHelper(mCurrentScore,scoreId);
                mValueTextView.setText(Integer.toString(mCurrentScore));
                int buttonNum = randomNum();
                Long timeNow = SystemClock.elapsedRealtime();
                Long timeElapsed = SystemClock.elapsedRealtime() - lastClickTime;
                lastClickTime = timeNow;
                castTime = (double) timeElapsed;
                mTimeAverageArray.add(castTime);
                for (int i = 0; i < mTimeAverageArray.size();i++){
                    timeSum = timeSum + mTimeAverageArray.get(i);
                }
                avgTime = (timeSum/mTimeAverageArray.size());
                mTimeTextView.setText(String.valueOf(avgTime));
                decideBox(buttonNum,buttons[0],buttons);
            }
        });

        buttons[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueUpdateHelper(mCurrentScore,scoreId);
                mValueTextView.setText(Integer.toString(mCurrentScore));
                int buttonNum = randomNum();
                Long timeNow = SystemClock.elapsedRealtime();
                Long timeElapsed = SystemClock.elapsedRealtime() - lastClickTime;
                lastClickTime = timeNow;
                castTime = (double) timeElapsed;
                mTimeAverageArray.add(castTime);
                for (int i = 0; i < mTimeAverageArray.size();i++){
                    timeSum = timeSum + mTimeAverageArray.get(i);
                }
                avgTime = (timeSum/mTimeAverageArray.size());
                mTimeTextView.setText(String.valueOf(avgTime));
                decideBox(buttonNum,buttons[1],buttons);
            }
        });

        buttons[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueUpdateHelper(mCurrentScore,scoreId);
                mValueTextView.setText(Integer.toString(mCurrentScore));
                int buttonNum = randomNum();
                Long timeNow = SystemClock.elapsedRealtime();
                Long timeElapsed = SystemClock.elapsedRealtime() - lastClickTime;
                lastClickTime = timeNow;
                castTime = (double) timeElapsed;
                mTimeAverageArray.add(castTime);
                for (int i = 0; i < mTimeAverageArray.size();i++){
                    timeSum = timeSum + mTimeAverageArray.get(i);
                }
                avgTime = (timeSum/mTimeAverageArray.size());
                mTimeTextView.setText(String.valueOf(avgTime));
                decideBox(buttonNum,buttons[2],buttons);
            }
        });

        buttons[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueUpdateHelper(mCurrentScore,scoreId);
                mValueTextView.setText(Integer.toString(mCurrentScore));
                mScoreRepository.getAmount();
                int buttonNum = randomNum();
                Long timeNow = SystemClock.elapsedRealtime();
                Long timeElapsed = SystemClock.elapsedRealtime() - lastClickTime;
                lastClickTime = timeNow;
                castTime = (double) timeElapsed;
                mTimeAverageArray.add(castTime);
                for (int i = 0; i < mTimeAverageArray.size();i++){
                    timeSum = timeSum + mTimeAverageArray.get(i);
                }
                avgTime = (timeSum/mTimeAverageArray.size());
                mTimeTextView.setText(String.valueOf(avgTime));
                decideBox(buttonNum,buttons[3],buttons);
            }
        });

        buttons[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueUpdateHelper(mCurrentScore,scoreId);
                mValueTextView.setText(Integer.toString(mCurrentScore));
                int buttonNum = randomNum();
                Long timeNow = SystemClock.elapsedRealtime();
                Long timeElapsed = SystemClock.elapsedRealtime() - lastClickTime;
                lastClickTime = timeNow;
                castTime = (double) timeElapsed;
                mTimeAverageArray.add(castTime);
                for (int i = 0; i < mTimeAverageArray.size();i++){
                    timeSum = timeSum + mTimeAverageArray.get(i);
                }
                avgTime = (timeSum/mTimeAverageArray.size());
                mTimeTextView.setText(String.valueOf(avgTime));
                decideBox(buttonNum,buttons[4],buttons);
            }
        });

        buttons[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueUpdateHelper(mCurrentScore,scoreId);
                mValueTextView.setText(Integer.toString(mCurrentScore));
                int buttonNum = randomNum();
                Long timeNow = SystemClock.elapsedRealtime();
                Long timeElapsed = SystemClock.elapsedRealtime() - lastClickTime;
                lastClickTime = timeNow;
                castTime = (double) timeElapsed;
                mTimeAverageArray.add(castTime);
                for (int i = 0; i < mTimeAverageArray.size();i++){
                    timeSum = timeSum + mTimeAverageArray.get(i);
                }
                avgTime = (timeSum/mTimeAverageArray.size());
                mTimeTextView.setText(String.valueOf(avgTime));
                decideBox(buttonNum,buttons[5],buttons);
            }
        });

        buttons[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueUpdateHelper(mCurrentScore,scoreId);
                mValueTextView.setText(Integer.toString(mCurrentScore));
                int buttonNum = randomNum();
                Long timeNow = SystemClock.elapsedRealtime();
                Long timeElapsed = SystemClock.elapsedRealtime() - lastClickTime;
                lastClickTime = timeNow;
                castTime = (double) timeElapsed;
                mTimeAverageArray.add(castTime);
                for (int i = 0; i < mTimeAverageArray.size();i++){
                    timeSum = timeSum + mTimeAverageArray.get(i);
                }
                avgTime = (timeSum/mTimeAverageArray.size());
                mTimeTextView.setText(String.valueOf(avgTime));
                decideBox(buttonNum,buttons[6],buttons);
            }
        });

        buttons[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueUpdateHelper(mCurrentScore,scoreId);
                mValueTextView.setText(Integer.toString(mCurrentScore));
                int buttonNum = randomNum();
                Long timeNow = SystemClock.elapsedRealtime();
                Long timeElapsed = SystemClock.elapsedRealtime() - lastClickTime;
                lastClickTime = timeNow;
                castTime = (double) timeElapsed;
                mTimeAverageArray.add(castTime);
                for (int i = 0; i < mTimeAverageArray.size();i++){
                    timeSum = timeSum + mTimeAverageArray.get(i);
                }
                avgTime = (timeSum/mTimeAverageArray.size());
                mTimeTextView.setText(String.valueOf(avgTime));
                decideBox(buttonNum,buttons[7],buttons);
            }
        });

        buttons[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueUpdateHelper(mCurrentScore,scoreId);
                mValueTextView.setText(Integer.toString(mCurrentScore));
                int buttonNum = randomNum();
                Long timeNow = SystemClock.elapsedRealtime();
                Long timeElapsed = SystemClock.elapsedRealtime() - lastClickTime;
                lastClickTime = timeNow;
                castTime = (double) timeElapsed;
                mTimeAverageArray.add(castTime);
                for (int i = 0; i < mTimeAverageArray.size();i++){
                    timeSum = timeSum + mTimeAverageArray.get(i);
                }
                avgTime = (timeSum/mTimeAverageArray.size());
                mTimeTextView.setText(String.valueOf(avgTime));
                decideBox(buttonNum,buttons[8],buttons);
            }
        });

    }

    //update all the score values and send info to DB
    public static void valueUpdateHelper(int currentScore, int scoreIdNum){
        mCurrentScore = currentScore + 1;
        scoreId = scoreIdNum + 1;
        mScore.setScoreId(scoreId);
        mScore.setScoreTotal(mCurrentScore);
        mScore.setTimeStamp("testTime");
        mValueTextView.setText(Integer.toString(mCurrentScore));
        mScoreRepository.insertScore(mScore.getScoreTotal(),mScore.getScoreId(),mScore.getTimeStamp());
    }

    //chooses random box to show next
    public static void decideBox(int number, Button currentButton, Button[] buttonsArr){
        switch(number){
            case 1:
                currentButton.setVisibility(View.GONE);
                buttonsArr[0].setVisibility(View.VISIBLE);
                break;
            case 2:
                currentButton.setVisibility(View.GONE);
                buttonsArr[1].setVisibility(View.VISIBLE);
                break;
            case 3:
                currentButton.setVisibility(View.GONE);
                buttonsArr[2].setVisibility(View.VISIBLE);
                break;
            case 4:
                currentButton.setVisibility(View.GONE);
                buttonsArr[3].setVisibility(View.VISIBLE);
                break;
            case 5:
                currentButton.setVisibility(View.GONE);
                buttonsArr[4].setVisibility(View.VISIBLE);
                break;
            case 6:
                currentButton.setVisibility(View.GONE);
                buttonsArr[5].setVisibility(View.VISIBLE);
                break;
            case 7:
                currentButton.setVisibility(View.GONE);
                buttonsArr[6].setVisibility(View.VISIBLE);
                break;
            case 8:
                currentButton.setVisibility(View.GONE);
                buttonsArr[7].setVisibility(View.VISIBLE);
                break;
            case 9:
                currentButton.setVisibility(View.GONE);
                buttonsArr[8].setVisibility(View.VISIBLE);
                break;
            default:
        }
    }

    //random num helper
    public static int randomNum(){
        return (int) ((Math.random()*9)+1);
    }

    //rotation helpers.
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        mValueTextView.setText(savedInstanceState.getString(VALUE_STATE_KEY));
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(VALUE_STATE_KEY, mCurrentScore);
        super.onSaveInstanceState(outState);
    }
}
