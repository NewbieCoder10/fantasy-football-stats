package com.khasianowebb.fantasyfootballstats.model.pojo;

import androidx.room.Relation;
import com.khasianowebb.fantasyfootballstats.model.entity.Player;
import com.khasianowebb.fantasyfootballstats.model.entity.Team;
import java.util.List;

public class TeamWithPlayers extends Team {

  @Relation(entity = Player.class, entityColumn = "team_id", parentColumn = "team_id")
  private List<Player> players;

  public List<Player> getPlayers() {
    return players;
  }

  public void setPlayers(List<Player> players) {
    this.players = players;
  }
}
