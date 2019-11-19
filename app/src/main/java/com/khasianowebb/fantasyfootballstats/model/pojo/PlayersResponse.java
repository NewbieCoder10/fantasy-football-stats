package com.khasianowebb.fantasyfootballstats.model.pojo;

import com.google.gson.annotations.SerializedName;
import com.khasianowebb.fantasyfootballstats.model.entity.Player;
import java.util.List;

/**
 * The type Players response from the public class PlayersResponse.
 */
public class PlayersResponse {

  @SerializedName("Players")
  private List<Player> players;

  /**
   * Gets players from the public List of getPlayers.
   *
   * @return the players from teh public List of getPlayers.
   */
  public List<Player> getPlayers() {
    return players;
  }

  /**
   * Sets players from the public void of setPlayers with a List of players.
   *
   * @param players the players from the public void of setPlayers with a List of players.
   */
  public void setPlayers(List<Player> players) {
    this.players = players;
  }
}
