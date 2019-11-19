package com.khasianowebb.fantasyfootballstats.viewmodel;

import android.app.Application;
import android.content.SharedPreferences;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import com.khasianowebb.fantasyfootballstats.model.entity.Player;
import com.khasianowebb.fantasyfootballstats.model.entity.Team;
import com.khasianowebb.fantasyfootballstats.model.pojo.TeamWithPlayers;
import com.khasianowebb.fantasyfootballstats.service.FantasyFootballStatsDatabase;
import java.util.List;

/**
 * The type Main view model extends AndroidViewModel with the public class.
 */
public class MainViewModel extends AndroidViewModel {

  private FantasyFootballStatsDatabase database;
  //
  private SharedPreferences preferences;
  private String teamKey;
  private String playerKey;

  private MutableLiveData<Long> teamId = new MutableLiveData<>();
  private LiveData<TeamWithPlayers> team;
  private MutableLiveData<Long> playerId = new MutableLiveData<>();
  private LiveData<Player> player;
  private MutableLiveData<String> nameSearch = new MutableLiveData<>();
  private LiveData<List<Player>> searchPlayers;
  private SearchData searchData = new SearchData(teamId, nameSearch);

  /**
   * Instantiates a new Main view model with the public, and also @NonNull Application.
   *
   * @param application the application with a new Main view model with the public,
   * and also @NonNull Application.
   */
  public MainViewModel(@NonNull Application application) {
    super(application);
    database = FantasyFootballStatsDatabase.getInstance();
    team = Transformations
        .switchMap(teamId, (id) -> database.getTeamDao().getByTeamIdWithPlayers(id));
    player = Transformations.switchMap(playerId, (id) -> database.getPlayerDao().getByPlayerId(id));
    searchPlayers = Transformations.switchMap(searchData, (data) -> {
      return (data.first == null) ? database.getPlayerDao().search(data.second)
          : database.getPlayerDao().search(data.first, data.second);
    });
  }

  public LiveData<List<Team>> getTeams() {
    return database.getTeamDao().getAllTeams();
  }

  public void setTeamId(long teamId) {
    this.teamId.setValue(teamId);
  }

  public LiveData<TeamWithPlayers> getTeam() {
    return team;
  }

  public void setPlayerId(long playerId) {
    this.playerId.setValue(playerId);
  }

  public LiveData<Player> getPlayer() {
    return player;
  }

  public void setNameSearch(String nameSearch) {
    this.nameSearch.setValue(nameSearch);
  }

  private static class SearchData extends MediatorLiveData<Pair<Long, String>>{
    public SearchData(LiveData<Long> teamId, LiveData<String> namePart) {
      addSource(teamId, new Observer<Long>() {
        @Override
        public void onChanged(Long id) {
          setValue(Pair.create(id, namePart.getValue()));
        }
      });
      addSource(namePart, new Observer<String>() {
        @Override
        public void onChanged(String part) {
          setValue(Pair.create(teamId.getValue(), part));
        }
      });
    }
  }

  public LiveData<List<Player>> getSearchPlayers(){
    return searchPlayers;
  }

}