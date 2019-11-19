package com.khasianowebb.fantasyfootballstats.model.pojo;

import androidx.room.Relation;
import com.khasianowebb.fantasyfootballstats.model.entity.Player;
import com.khasianowebb.fantasyfootballstats.model.entity.Team;
import java.util.List;

/**
 * The type Team with players from the public class extends team.
 */
public class TeamWithPlayers extends Team {

  @Relation(entity = Player.class, entityColumn = "team_id", parentColumn = "team_id")
  private List<Player> players;

  /**
   * Gets players from the public List with Player.
   *
   * @return the players from the public List with Player.
   */
  public List<Player> getPlayers() {
    return players;
  }

  /**
   * Sets players from the public void, setPlayers with List, of players.
   *
   * @param players the players from the public void, setPlayers with List, of players.
   */
  public void setPlayers(List<Player> players) {
    this.players = players;
  }
}
