package com.allstudio.bmc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private SharedMemory shared;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        shared = new SharedMemory(this);
        findViewById(R.id.logout).setOnClickListener(v -> {
            shared.setUToken(null);
            Intent i = new Intent(MainActivity.this, LaunchActivity.class);
            startActivity(i);
            finish();
        });
    }
}