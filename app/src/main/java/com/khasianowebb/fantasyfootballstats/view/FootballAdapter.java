package com.khasianowebb.fantasyfootballstats.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * The type Football adapter of the public class, that extends the RecyclerView.adapter.
 */
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

  /**
   * The type Football holder that extends the RecyclerView.
   */
  class FootballHolder extends RecyclerView.ViewHolder {

    /**
     * The public View itemView.
     */
    public View itemView;

    /**
     * Instantiates a new Football holder from the public @NonNull View itemView.
     *
     * @param itemView the item view
     */
    public FootballHolder(@NonNull View itemView) {
      super(itemView);
      this.itemView = itemView;
    }
  }

}
