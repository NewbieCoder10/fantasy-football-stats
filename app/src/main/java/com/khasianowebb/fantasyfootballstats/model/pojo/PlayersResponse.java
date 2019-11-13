package com.khasianowebb.fantasyfootballstats.model.pojo;

import com.google.gson.annotations.SerializedName;
import com.khasianowebb.fantasyfootballstats.model.entity.Player;
import java.util.List;

public class PlayersResponse {

  @SerializedName("Players")
  private List<Player> players;

  public List<Player> getPlayers() {
    return players;
  }

  public void setPlayers(List<Player> players) {
    this.players = players;
  }
}
