package com.khasianowebb.fantasyfootballstats.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import com.khasianowebb.fantasyfootballstats.service.FantasyFootballStatsDatabase;

public class MainViewModel extends AndroidViewModel {

  private FantasyFootballStatsDatabase database;

  public MainViewModel(@NonNull Application application) {
    super(application);
  }
}
// TODO Add method to get live data thats a list of teams, and a method for a specified team and part of a players name