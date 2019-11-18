package com.khasianowebb.fantasyfootballstats.controller;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.khasianowebb.fantasyfootballstats.R;
import com.khasianowebb.fantasyfootballstats.service.GoogleSignInService;

/**
 * The type Main activity.
 */
public class MainActivity extends AppCompatActivity
    implements BottomNavigationView.OnNavigationItemSelectedListener, SharedPreferences.OnSharedPreferenceChangeListener {

  private BottomNavigationView navigation;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  public boolean onCreateOptionsMenu(Menu menu) {
    super.onCreateOptionsMenu(menu);
    getMenuInflater().inflate(R.menu.options, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(@NonNull MenuItem item) {
    boolean handled = true;
    Intent intent;
    switch (item.getItemId()) {
      case R.id.sign_out:
        signOut();
        break;
      case R.id.preferences:
        intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
        break;
      default:
        handled = super.onOptionsItemSelected(item);
    }
    return handled;
  }

  private void signOut() {
    GoogleSignInService.getInstance().signOut()
        .addOnCompleteListener((task) -> {
          Intent intent = new Intent(this, LoginActivity.class);
          intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
          startActivity(intent);
        });
  }


  @Override
  public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
    Fragment fragment = null;
    switch (menuItem.getItemId()) {
      case R.id.teams:
        fragment = TeamsFragment.newInstance();
        break;
      case R.id.players:
        fragment = PlayersFragment.newInstance();
        break;
    }
    getSupportFragmentManager().beginTransaction()
        .replace(R.id.fragment_container, fragment, fragment.getClass().getSimpleName())
        .commit();
    return true;
  }

  @Override
  public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
    //todo: handle changed user preference
  }
}
