package com.allstudio.bmc;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.allstudio.bmc.Objects.Login;
import com.allstudio.bmc.Objects.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LaunchActivity extends AppCompatActivity {
    private EditText eEmail, ePass;
    private SharedMemory shared;

    Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl("https://bmkauth.herokuapp.com/api/v1/user/")
            .addConverterFactory(GsonConverterFactory.create());
    Retrofit retrofit = builder.build();
    private final UserClient userClient = retrofit.create(UserClient.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        if(getSupportActionBar() != null) getSupportActionBar().hide();

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Welcome Back!");
        Button bLogin = findViewById(R.id.b_login);
        eEmail = findViewById(R.id.e_email);
        ePass = findViewById(R.id.e_pass);

        shared = new SharedMemory(this);
        if(shared.getUToken() != null){
            Intent i = new Intent(LaunchActivity.this, MainActivity.class);
            startActivity(i);
            finish();
        }

        bLogin.setOnClickListener(v -> {
            String email = eEmail.getText().toString().trim();
            String pass = ePass.getText().toString().trim();
            if(isValidEmail(email)){
                if(pass.length() > 5){
                    login(email, pass);
                } else {
                    ts("Password must be 6 or more characters long");
                }
            } else {
                ts("Please Enter a Valid Email ID");
            }
        });



    }

    private void login(String email, String pass) {
        Login login = new Login(email, pass, 0);
        Call<User> call = userClient.login(login);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful() && response.body() != null){
                    ts("User Logged In: " + response.body().toString());
                    shared.setUToken(response.body().getToken());
                    Intent i = new Intent(LaunchActivity.this, MainActivity.class);
                    startActivity(i);
                    finish();
                } else {
                    ts("User Credentials Not Correct");
                    Log.d("LaunchActivity", response.toString());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                ts("Error: Unable to login");
            }
        });
    }

    private boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

    private void ts(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}