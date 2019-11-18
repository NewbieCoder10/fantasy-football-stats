package com.khasianowebb.fantasyfootballstats.model.pojo;

import com.google.gson.annotations.SerializedName;
import com.khasianowebb.fantasyfootballstats.model.entity.Player;
import java.util.List;

/**
 * The type Players response.
 */
public class PlayersResponse {

  @SerializedName("Players")
  private List<Player> players;

  /**
   * Gets players.
   *
   * @return the players
   */
  public List<Player> getPlayers() {
    return players;
  }

  /**
   * Sets players.
   *
   * @param players the players
   */
  public void setPlayers(List<Player> players) {
    this.players = players;
  }
}
