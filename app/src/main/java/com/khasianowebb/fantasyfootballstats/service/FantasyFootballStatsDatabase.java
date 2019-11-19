package com.khasianowebb.fantasyfootballstats.service;

import android.app.Application;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.khasianowebb.fantasyfootballstats.BuildConfig;
import com.khasianowebb.fantasyfootballstats.model.dao.PlayerDao;
import com.khasianowebb.fantasyfootballstats.model.dao.TeamDao;
import com.khasianowebb.fantasyfootballstats.model.entity.Player;
import com.khasianowebb.fantasyfootballstats.model.entity.Team;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import java.util.LinkedList;
import java.util.List;

/**
 * The type Fantasy football stats database is populated with the Teams, and Players.
 */
@Database(
    entities = {Player.class, Team.class}, version = 1,
    exportSchema = true)

 //@TypeConverters(BlackjackDatabase.Converters.class)
public abstract class FantasyFootballStatsDatabase extends RoomDatabase {

  /**
   * Instantiates a new Fantasy football stats database that was created with the populated data.
   */
  protected FantasyFootballStatsDatabase() {}

  private static Application applicationContext;

  /**
   * Gets player dao from the public abstract PlayerDao to getPlayerDao.
   *
   * @return the player dao from the public abstract PlayerDao to getPlayerDao.
   */
  public abstract PlayerDao getPlayerDao();

  /**
   * Gets team dao from the public abstract TeamDao, to getTeamDao.
   *
   * @return the team dao from the public abstract TeamDao, to getTeamDao.
   */
  public abstract TeamDao getTeamDao();


  /**
   * Sets application context from the public static void setUpApplication.
   *
   * @param applicationContext the application context from the public static void setUpApplication.
   */
  public static void setApplicationContext(Application applicationContext) {
    FantasyFootballStatsDatabase.applicationContext = applicationContext;
  }

  /**
   * Get instance fantasy football stats database from the public static FantasyFootballStatsDatabase
   * getInstance.
   *
   * @return the fantasy football stats database from the public static FantasyFootballStatsDatabase
   * getInstance.
   */
  public static FantasyFootballStatsDatabase getInstance(){
    return InstanceHolder.INSTANCE;
  }
  private static class InstanceHolder {

    private static final FantasyFootballStatsDatabase INSTANCE;

    static {
      INSTANCE =
          Room.databaseBuilder(applicationContext, FantasyFootballStatsDatabase.class,
              "fantasyfootballstats_db")
              .addCallback(new Prepopulation())
              .build();
    }

  }

  private static class Prepopulation extends Callback {

    @Override
    public void onCreate(@NonNull SupportSQLiteDatabase db) {
      super.onCreate(db);
      FootballService service = FootballService.getInstance();
      FantasyFootballStatsDatabase database = FantasyFootballStatsDatabase.getInstance();
      service.getTeams(BuildConfig.API_KEY)
          .subscribeOn(Schedulers.io())
          .doFinally(() -> {
            Log.d(getClass().getSimpleName(), "Teams done");
            service.getPlayers(BuildConfig.API_KEY)
                .subscribeOn(Schedulers.io())
                .subscribe((resp) -> {
                  Log.d(getClass().getSimpleName(), "Received players");
                  List<Player> players = new LinkedList<>();
                  for (Player player: resp.getPlayers()){
                    String abbreviation = player.getTempTeam();
                    Long teamId = database.getTeamDao().getByAbbreviation(abbreviation);
                    if (teamId != null) {
                      player.setTeamId(teamId);
                    } else {
                      Log.d(getClass().getSimpleName(), "Abbreviation not found: " + abbreviation);
                    }
                    players.add(player);
                  }
                  database.getPlayerDao().insert(players);
                  Log.d(getClass().getSimpleName(), "Players done");
                }, (e) -> {
                  Log.d("Preload", e.getMessage(), e);
                });
          })
          .subscribe((response) -> {
            Log.d(getClass().getSimpleName(), "Received teams");
            database.getTeamDao()
                .insert(response.getTeams());
          }, (e) -> {
            Log.d("Preload", e.getMessage(), e);
          });
    }
  }

  // public static class Converters {

  }
