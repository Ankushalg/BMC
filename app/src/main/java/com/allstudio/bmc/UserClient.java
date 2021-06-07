package com.allstudio.bmc;

import com.allstudio.bmc.Objects.Login;
import com.allstudio.bmc.Objects.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserClient {
    @POST("singin")
    Call<User> login(@Body Login login);
}