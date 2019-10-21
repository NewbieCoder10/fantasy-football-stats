package com.khasianowebb.fantasyfootballstats;

import android.app.Application;
import com.facebook.stetho.Stetho;
import com.khasianowebb.fantasyfootballstats.service.FantasyFootballStatsDatabase;

public class FantasyFootballStatsApplication extends Application {
    @Override
    public void onCreate() {
      super.onCreate();
      Stetho.initializeWithDefaults(this);
        FantasyFootballStatsDatabase.setApplicationContext(this);
      final FantasyFootballStatsDatabase database = FantasyFootballStatsDatabase.getInstance();
      new Thread(new Runnable() {
        @Override
        public void run() {
          database.getTeamDao().delete();
        }
      }).start();
    }
  }
