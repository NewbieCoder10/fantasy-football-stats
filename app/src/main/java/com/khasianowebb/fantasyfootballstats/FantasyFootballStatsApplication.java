package com.khasianowebb.fantasyfootballstats;

import android.app.Application;
import com.facebook.stetho.Stetho;
import com.khasianowebb.fantasyfootballstats.service.FantasyFootballStatsDatabase;
import com.khasianowebb.fantasyfootballstats.service.GoogleSignInService;

/**
 * The type Fantasy football stats application extends Application.
 */
public class FantasyFootballStatsApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    GoogleSignInService.setApplicationContext(this);
    Stetho.initializeWithDefaults(this);
    GoogleSignInService.setApplicationContext(this);
    FantasyFootballStatsDatabase.setApplicationContext(this);
    FantasyFootballStatsDatabase database = FantasyFootballStatsDatabase.getInstance();
    new Thread(new Runnable() {
      @Override
      public void run() {
        database.getTeamDao().delete();
      }
    }).start();
  }

}
