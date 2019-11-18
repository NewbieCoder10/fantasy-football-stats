package com.khasianowebb.fantasyfootballstats.controller;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.khasianowebb.fantasyfootballstats.R;

/**
 * The type Settings activity.
 */
public class SettingsActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super .onCreate(savedInstanceState);
    setContentView(R.layout.settings_activity);
    getSupportFragmentManager().beginTransaction().replace(R.id.settings, new SettingsFragment()).commit();

  }

}
