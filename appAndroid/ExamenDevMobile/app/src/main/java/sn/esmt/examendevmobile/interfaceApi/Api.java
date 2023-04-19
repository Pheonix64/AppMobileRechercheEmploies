package sn.esmt.examendevmobile.interfaceApi;

import androidx.annotation.Nullable;

import org.jetbrains.annotations.Contract;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import sn.esmt.examendevmobile.User;

public interface Api {

    @GET("userscv/all")
    Call<ArrayList<User>> all();


    @POST("userscv/save")
    Call<User> createUser(@Body User user);
}
