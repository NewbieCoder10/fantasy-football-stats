package com.khasianowebb.fantasyfootballstats.model.pojo;

import com.google.gson.annotations.SerializedName;
import com.khasianowebb.fantasyfootballstats.model.entity.Team;
import java.util.List;

/**
 * The type Teams response.
 */
public class TeamsResponse {

  @SerializedName("NFLTeams")
  private List<Team> teams;

  /**
   * Gets teams.
   *
   * @return the teams
   */
  public List<Team> getTeams() {
    return teams;
  }

  /**
   * Sets teams.
   *
   * @param teams the teams
   */
  public void setTeams(List<Team> teams) {
    this.teams = teams;
  }

}
