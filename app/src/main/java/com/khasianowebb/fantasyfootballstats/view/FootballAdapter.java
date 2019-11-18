package com.khasianowebb.fantasyfootballstats.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FootballAdapter extends RecyclerView.Adapter<FootballAdapter.FootballHolder> {

  @NonNull
  @Override
  public FootballHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    return null;
  }

  @Override
  public void onBindViewHolder(@NonNull FootballHolder holder, int position) {

  }

  @Override
  public int getItemCount() {
    return 0;
  }

  class FootballHolder extends RecyclerView.ViewHolder {
    public View itemView;

    public FootballHolder(@NonNull View itemView) {
      super(itemView);
      this.itemView = itemView;
    }
  }

}
