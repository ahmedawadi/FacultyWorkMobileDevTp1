package com.example.myapplication.View;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import pageActions.ResultPageActions;


public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //getting the result passed from the consulting intent
        String patientResult = getIntent().getStringExtra("result");

        //displaying result and addition of the come back button action
        ResultPageActions resultPageActions = new ResultPageActions(this, patientResult);

    }
}
