package com.example.movieapp.data;

import android.accounts.NetworkErrorException;
import android.util.Log;

import com.example.movieapp.model.Film;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class GhibliService {

    Retrofit retrofit = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://ghibliapi.herokuapp.com/")
            .build();

    GhibliApi service = retrofit.create(GhibliApi.class);

    public void getFilmById(String id, GhibliCallback callback) {

        Call<Film> call = service.getFilm(id);
        call.enqueue(new Callback<Film>() {
            @Override
            public void onResponse(Call<Film> call, Response<Film> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        callback.onSuccess(response.body());
                        Log.d("TAG", response.body().toString());
                    } else {
                        Log.d("TAG", "response body is null");
                        callback.onFailure(new NetworkErrorException());
                    }
                }
                // throw new NullPointerException();
            }

            @Override
            public void onFailure(Call<Film> call, Throwable t) {
                Log.d("TAG", "Error");
                callback.onFailure(new Exception());
            }
        });

    }


    public interface GhibliCallback {
        void onSuccess(Film film);

        void onFailure(Exception exception);
    }

    public interface GhibliApi {
        @GET("films/{id}")
        Call<Film> getFilm(@Path("id") String filmId);
    }
}
