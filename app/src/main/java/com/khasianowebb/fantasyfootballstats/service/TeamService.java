package com.khasianowebb.fantasyfootballstats.service;

import com.khasianowebb.fantasyfootballstats.BuildConfig;
import com.khasianowebb.fantasyfootballstats.model.entity.Team;
import com.khasianowebb.fantasyfootballstats.model.entity.Player;
import io.reacivex.Single;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TeamService {

}

  static TeamService getInstance() { return InstanceHolder.INSTANCE; }

  @GET("team/players")
  Single<Team> newTeam(@Query("team_count") int count);

  class InstanceHolder {

    private static final TeamService INSTANCE;

    static {
      // TODO Skip Creation of interceptor and client for production.
      HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
      interceptor.setLevel(Level.BODY);
      OkHttpClient client = new OkHttpClient.Builder()
          .addInterceptor(interceptor)
          .build();
      Retrofit retrofit = new Retrofit.Builder()
          .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
          .addConverterFactory(GsonConverterFactory.create())
          .baseUrl(BuildConfig.BASE_URL)
          .client(client) // TODO Leave this out for production.
          .build();
      INSTANCE = retrofit.create(DeckOfCardsService.class);
    }

  }

}