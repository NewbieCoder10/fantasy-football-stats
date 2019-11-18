package com.khasianowebb.fantasyfootballstats.viewmodel;

import android.app.Application;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.khasianowebb.fantasyfootballstats.model.entity.Player;
import com.khasianowebb.fantasyfootballstats.model.entity.Team;
import com.khasianowebb.fantasyfootballstats.service.FantasyFootballStatsDatabase;

public class MainViewModel extends AndroidViewModel {

  private FantasyFootballStatsDatabase database;
//
   private SharedPreferences preferences;
   private String teamKey;
   private String playerKey;

   private MutableLiveData<Long> teamId;
   private LiveData<Team> team;
   private MutableLiveData<Long> playerId;
   private LiveData<Player> player;

  public MainViewModel(@NonNull Application application) {
    super(application);
  }









}
// TODO Add method to get live data thats a list of teams, and a method for a specified team and part of a players name