package com.khasianowebb.fantasyfootballstats.model.pojo;

import com.google.gson.annotations.SerializedName;
import com.khasianowebb.fantasyfootballstats.model.entity.Team;
import java.util.List;

/**
 * The type Teams response from the public class TeamResponse.
 */
public class TeamsResponse {

  @SerializedName("NFLTeams")
  private List<Team> teams;

  /**
   * Gets teams from the public List, of team, to getTeams.
   *
   * @return the teams from the public List, of team, to getTeams.
   */
  public List<Team> getTeams() {
    return teams;
  }

  /**
   * Sets teams from the public void setTeams, List of team to teams.
   *
   * @param teams the teams from the public void setTeams, List of team to teams.
   */
  public void setTeams(List<Team> teams) {
    this.teams = teams;
  }

}
