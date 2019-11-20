package com.khasianowebb.fantasyfootballstats.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AlertDialog.Builder;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProviders;
import com.khasianowebb.fantasyfootballstats.R;
import com.khasianowebb.fantasyfootballstats.viewmodel.PlayerInfoViewModel;

public class PlayerInfoFragment extends DialogFragment {


  private PlayerInfoViewModel viewModel;
  private View view;
  private TextView jersey;
  private TextView firstName;
  private TextView lastName;
  private TextView position;
  private TextView college;


  public static PlayerInfoFragment newInstance(long id){
    PlayerInfoFragment fragment = new PlayerInfoFragment();
    Bundle args = new Bundle();
    args.putLong("player_id", id);
    fragment.setArguments(args);
    return fragment;
  }

  @NonNull
  @Override
  public AlertDialog onCreateDialog(@Nullable Bundle savedInstanceState) {
    view = getActivity().getLayoutInflater().inflate(R.layout.fragment_info_player, null);
    jersey = view.findViewById(R.id.jersey);
    firstName = view.findViewById(R.id.first_name);
    lastName = view.findViewById(R.id.last_name);
    position = view.findViewById(R.id.position);
    college = view.findViewById(R.id.college);
    return new Builder(getContext())
        .setTitle(getString(R.string.details_title))
        .setView(view)
        .setNeutralButton(getString(R.string.okay), (dialogInterface, i) -> {})
        .create();

  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    return view;
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    viewModel = ViewModelProviders.of(this).get(PlayerInfoViewModel.class);
    viewModel.setPlayerId(getArguments().getLong("player_id"));
    viewModel.getPlayer().observe(this, (player) -> {
      jersey.setText(player.getJersey());
      firstName.setText(player.getFirstName());
      lastName.setText(player.getLastName());
      college.setText(player.getCollege());
      position.setText(player.getPosition());
    });
  }
}
