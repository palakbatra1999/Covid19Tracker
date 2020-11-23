package com.example.covid19tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Details_state extends AppCompatActivity {
    private  int positionState;
    TextView tvstate,tvCases,tvDeaths,tvRecovered,tvActive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_state);

        initActionBar();
        initViews();
        Intent intent = getIntent();
        positionState= intent.getIntExtra("position",0);

        initViews();
        tvCases.setText(MainActivity2.districtList.get(positionState).getConfirmed());
        tvstate.setText(MainActivity2.districtList.get(positionState).getState_name());
        tvDeaths.setText(MainActivity2.districtList.get(positionState).getDeaths());
        tvRecovered.setText(MainActivity2.districtList.get(positionState).getRecovered());
        tvActive.setText(MainActivity2.districtList.get(positionState).getActive());
    }

    private void initViews() {
        tvCases = findViewById(R.id.tvCases);
        tvstate = findViewById(R.id.tvstate);
        tvRecovered = findViewById(R.id.tvRecovered);
        tvActive = findViewById(R.id.tvActive);
        tvDeaths = findViewById(R.id.tvDeaths);
    }
    private void initActionBar() {
        getSupportActionBar().setTitle("Details of "+MainActivity2.districtList.get(positionState).getState_name());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }
}