package com.example.myapplication.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import pageActions.ConsultingPageActions;

import com.example.myapplication.Controller.Controller;
import com.example.myapplication.R;

public class ConsultingActivity extends AppCompatActivity {

    Controller controller;
    ConsultingPageActions mainActivityListenners;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulting);

        init();
        mainActivityListenners.addPageEventListenners();

    }

    private void init(){

        controller = Controller.getInstance();
        mainActivityListenners = new ConsultingPageActions(this);
    }

}