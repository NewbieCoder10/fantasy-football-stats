package com.khasianowebb.fantasyfootballstats.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.khasianowebb.fantasyfootballstats.R;

public class MainFragment extends Fragment {


  ImageButton searchButton;
  EditText searchBar;


  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_main, container, false);
    searchButton = view.findViewById(R.id.search_button);
    searchBar = view.findViewById(R.id.search_bar);
    searchButton.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        Toast.makeText(getActivity(), searchBar.getText(), Toast.LENGTH_LONG).show();
      }
    });
    return view;

  }
}
