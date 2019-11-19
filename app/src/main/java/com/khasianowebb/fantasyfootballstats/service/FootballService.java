package com.khasianowebb.fantasyfootballstats.service;

import com.khasianowebb.fantasyfootballstats.BuildConfig;
import com.khasianowebb.fantasyfootballstats.model.entity.Player;
import com.khasianowebb.fantasyfootballstats.model.entity.Team;
import com.khasianowebb.fantasyfootballstats.model.pojo.PlayersResponse;
import com.khasianowebb.fantasyfootballstats.model.pojo.TeamsResponse;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.List;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * The interface Football service from the public interface FootballService.
 */
public interface FootballService {

  /**
   * Gets teams with the @GET from the nfl-teams/json, with an API key.
   *
   * @param apiKey the api key with the @GET from the nfl-teams/json, with an API key.
   * @return the teams with the @GET from the nfl-teams/json, with an API key.
   */
  @GET("nfl-teams/json/{apiKey}")
  Single<TeamsResponse> getTeams(@Path("apiKey") String apiKey);

  /**
   * Gets players with the @GET from the players/json, with an API key
   *
   * @param apiKey the api key with the @GET from the nfl-teams/json, with an API key.
   * @return the players with the @GET from the nfl-teams/json, with an API key.
   */
  @GET("players/json/{apiKey}")
  Single<PlayersResponse> getPlayers(@Path("apiKey") String apiKey);

  /**
   * Gets instance of the FootballService of getInstance().
   *
   * @return the instance of the FootballService of getInstance().
   */
  static FootballService getInstance() { return InstanceHolder.INSTANCE; }

  /**
   * The type Instance holder for the class.
   */
  class InstanceHolder {

    private static final FootballService INSTANCE;

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
      INSTANCE = retrofit.create(FootballService.class);
    }

  }

}