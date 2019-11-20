package com.khasianowebb.fantasyfootballstats.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import com.khasianowebb.fantasyfootballstats.model.entity.Player;
import com.khasianowebb.fantasyfootballstats.service.FantasyFootballStatsDatabase;

public class PlayerInfoViewModel extends AndroidViewModel {

  private FantasyFootballStatsDatabase database;
  private MutableLiveData<Long> playerId = new MutableLiveData<>();
  private LiveData<Player> player;


  public PlayerInfoViewModel(@NonNull Application application) {
    super(application);
    database = FantasyFootballStatsDatabase.getInstance();
    player = Transformations.switchMap(playerId, (id)-> database.getPlayerDao().getByPlayerId(id));
  }

  public void setPlayerId(long playerId) {
    this.playerId.setValue(playerId);
  }

  public LiveData<Player> getPlayer() {
    return player;
  }
}
