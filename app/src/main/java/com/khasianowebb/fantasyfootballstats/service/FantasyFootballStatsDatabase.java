package com.khasianowebb.fantasyfootballstats.service;

import android.app.Application;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.khasianowebb.fantasyfootballstats.BuildConfig;
import com.khasianowebb.fantasyfootballstats.FantasyFootballStatsApplication;
import com.khasianowebb.fantasyfootballstats.model.dao.PlayerDao;
import com.khasianowebb.fantasyfootballstats.model.dao.TeamDao;
import com.khasianowebb.fantasyfootballstats.model.entity.Player;
import com.khasianowebb.fantasyfootballstats.model.entity.Team;
import io.reactivex.schedulers.Schedulers;
import java.util.Date;

@Database(
    entities = {Player.class, Team.class}, version = 1,
    exportSchema = true)

 //@TypeConverters(BlackjackDatabase.Converters.class)
public abstract class FantasyFootballStatsDatabase extends RoomDatabase {

  protected FantasyFootballStatsDatabase() {}

  private static Application applicationContext;

  public abstract PlayerDao getPlayerDao();

  public abstract TeamDao getTeamDao();



  public static void setApplicationContext(Application applicationContext) {
    FantasyFootballStatsDatabase.applicationContext = applicationContext;
  }

  public static FantasyFootballStatsDatabase getInstance(){
    return InstanceHolder.INSTANCE;
  }
  private static class InstanceHolder {

    private static final FantasyFootballStatsDatabase INSTANCE;

    static {
      INSTANCE =
          Room.databaseBuilder(applicationContext, FantasyFootballStatsDatabase.class,
              "fantasyfootballstats_db")
              .addCallback(new Callback() {
                @Override
                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                  super.onCreate(db);
                  FootballService service = FootballService.getInstance();
                  service.getTeams(BuildConfig.API_KEY)
                      .subscribeOn(Schedulers.io())
                      .subscribe((response) -> {
                        FantasyFootballStatsDatabase.getInstance().getTeamDao()
                            .insert(response.getTeams());
                      }, (e) -> {
                        Log.d("Preload", e.getMessage(), e);
                      });
                }
              })
              .build();
    }

  }

  // public static class Converters {

  }
