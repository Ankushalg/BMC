package com.allstudio.bmc;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        if(getSupportActionBar() != null) getSupportActionBar().hide();
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Welcome Back!");
        
    }
}