package com.khasianowebb.fantasyfootballstats.controller;

import android.os.Bundle;
import androidx.preference.PreferenceFragmentCompat;
import com.khasianowebb.fantasyfootballstats.R;

/**
 * The type Settings fragment.
 */
public class SettingsFragment extends PreferenceFragmentCompat {

  @Override
  public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
    setPreferencesFromResource(R.xml.root_preferences, rootKey);
  }
}
