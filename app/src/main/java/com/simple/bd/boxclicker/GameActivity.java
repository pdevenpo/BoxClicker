package com.simple.bd.boxclicker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    private String VALUE_STATE_KEY;
    private Button mBlackButton;
    private TextView mScoreTextView;
    private TextView mValueTextView;
    private String mValueString;
    int mCurrentScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        mBlackButton = findViewById(R.id.blackButton);
        mScoreTextView = findViewById(R.id.scoreString);
        mValueTextView = findViewById(R.id.valueString);
        if (savedInstanceState != null) {
            mCurrentScore = savedInstanceState.getInt(VALUE_STATE_KEY);
            mValueTextView.setText(Integer.toString(mCurrentScore));
        }else{
            mValueTextView.setText(Integer.toString(mCurrentScore));
        }



        mBlackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentScore++;
                mValueTextView.setText(Integer.toString(mCurrentScore));
            }
        });

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
