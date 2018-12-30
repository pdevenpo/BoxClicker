package com.simple.bd.boxclicker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    private String VALUE_STATE_KEY;
    private TextView mScoreTextView;
    private TextView mValueTextView;
    private String mValueString;
    private Button buttons[] = new Button[9];
    int mCurrentScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        buttons[0] = findViewById(R.id.blackButton1);
        buttons[1] = findViewById(R.id.blackButton2);
        buttons[2] = findViewById(R.id.blackButton3);
        buttons[3] = findViewById(R.id.blackButton4);
        buttons[4] = findViewById(R.id.blackButton5);
        buttons[5] = findViewById(R.id.blackButton6);
        buttons[6] = findViewById(R.id.blackButton7);
        buttons[7] = findViewById(R.id.blackButton8);
        buttons[8] = findViewById(R.id.blackButton9);
        for(int i = 1; i<9;i++){
            buttons[i].setVisibility(View.GONE);
        }

        mScoreTextView = findViewById(R.id.scoreString);
        mValueTextView = findViewById(R.id.valueString);
        if (savedInstanceState != null) {
            mCurrentScore = savedInstanceState.getInt(VALUE_STATE_KEY);
            mValueTextView.setText(Integer.toString(mCurrentScore));
        }else{
            mValueTextView.setText(Integer.toString(mCurrentScore));
        }



        buttons[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentScore++;
                mValueTextView.setText(Integer.toString(mCurrentScore));

                int buttonNum = randomNum();
                decideBox(buttonNum,buttons[0],buttons);
            }
        });

        buttons[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentScore++;
                mValueTextView.setText(Integer.toString(mCurrentScore));
                int buttonNum = randomNum();
                decideBox(buttonNum,buttons[1],buttons);
            }
        });

        buttons[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentScore++;
                mValueTextView.setText(Integer.toString(mCurrentScore));
                int buttonNum = randomNum();
                decideBox(buttonNum,buttons[2],buttons);
            }
        });

        buttons[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentScore++;
                mValueTextView.setText(Integer.toString(mCurrentScore));
                int buttonNum = randomNum();
                decideBox(buttonNum,buttons[3],buttons);
            }
        });

        buttons[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentScore++;
                mValueTextView.setText(Integer.toString(mCurrentScore));
                int buttonNum = randomNum();
                decideBox(buttonNum,buttons[4],buttons);
            }
        });

        buttons[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentScore++;
                mValueTextView.setText(Integer.toString(mCurrentScore));
                int buttonNum = randomNum();
                decideBox(buttonNum,buttons[5],buttons);
            }
        });

        buttons[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentScore++;
                mValueTextView.setText(Integer.toString(mCurrentScore));
                int buttonNum = randomNum();
                decideBox(buttonNum,buttons[6],buttons);
            }
        });

        buttons[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentScore++;
                mValueTextView.setText(Integer.toString(mCurrentScore));
                int buttonNum = randomNum();
                decideBox(buttonNum,buttons[7],buttons);
            }
        });

        buttons[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentScore++;
                mValueTextView.setText(Integer.toString(mCurrentScore));
                int buttonNum = randomNum();
                decideBox(buttonNum,buttons[8],buttons);
            }
        });

    }

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

    public static int randomNum(){
        return (int) ((Math.random()*9)+1);
    }

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
