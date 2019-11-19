package com.khasianowebb.fantasyfootballstats.controller;


import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.lifecycle.ViewModelProviders;
import com.khasianowebb.fantasyfootballstats.R;
import com.khasianowebb.fantasyfootballstats.model.entity.Player;
import com.khasianowebb.fantasyfootballstats.model.entity.Team;
import com.khasianowebb.fantasyfootballstats.viewmodel.MainViewModel;

/**
 * A simple {@link Fragment} subclass. Use the {@link PlayersFragment#newInstance} factory method to
 * create an instance of this fragment. This is used to link the information that will be printed on
 * the screen about the player; Using a spinner, and a scrollview.
 */
public class PlayersFragment extends Fragment {

  private MainViewModel viewModel;
  private ListView playerList;



  public static PlayersFragment newInstance() {
    PlayersFragment fragment = new PlayersFragment();
    Bundle args = new Bundle();
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() != null) {
    }
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_players, container, false);
    playerList = view.findViewById(R.id.player_list);
    return view;
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    viewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);
    viewModel.getSearchPlayers().observe(this, (players) -> {
      // TODO Create new layout for showing a team logo and name. Probably LinearLayout (horizontal) with ImageView and TextView. Look at Craps Simulator for example.
      // TODO Create a subclass of ArrayAdapter that uses the new layout. Again, review Craps Simulator.
      ArrayAdapter<Player> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, players);
      playerList.setAdapter(adapter);
    });
  }

}
