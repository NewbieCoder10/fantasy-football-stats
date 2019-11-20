package com.khasianowebb.fantasyfootballstats.controller;


import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import com.khasianowebb.fantasyfootballstats.R;
import com.khasianowebb.fantasyfootballstats.model.entity.Team;
import com.khasianowebb.fantasyfootballstats.viewmodel.MainViewModel;

/**
 * A simple {@link Fragment} subclass. Use the {@link TeamsFragment#newInstance} factory method to
 * create an instance of this fragment. This will be used to view the teams information along with
 * an image. There will be a spinner, and a scrollview a well.
 */
public class TeamsFragment extends Fragment {


  private MainViewModel viewModel;
  private ListView teamList;


  public static TeamsFragment newInstance() {
    TeamsFragment fragment = new TeamsFragment();
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
    View view = inflater.inflate(R.layout.fragment_teams, container, false);
    teamList = view.findViewById(R.id.team_list);
    teamList.setOnItemClickListener((adapterView, v, position, l) -> {
      Team team = (Team) adapterView.getItemAtPosition(position);
      Bundle args = new Bundle();
      args.putLong("team_id", team.getId());
      Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(R.id.player_fragment, args);
    });
    return view;
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    viewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);
    viewModel.getTeams().observe(this, (teams) -> {
      // TODO Create new layout for showing a team logo and name. Probably LinearLayout (horizontal) with ImageView and TextView. Look at Craps Simulator for example.
      // TODO Create a subclass of ArrayAdapter that uses the new layout. Again, review Craps Simulator.
      ArrayAdapter<Team> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, teams);
      teamList.setAdapter(adapter);
    });
  }
}
