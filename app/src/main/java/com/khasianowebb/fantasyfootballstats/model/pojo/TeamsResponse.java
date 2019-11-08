package com.khasianowebb.fantasyfootballstats.model.pojo;

import com.google.gson.annotations.SerializedName;
import com.khasianowebb.fantasyfootballstats.model.entity.Team;
import java.util.List;

public class TeamsResponse {

  @SerializedName("NFLTeams")
  private List<Team> teams;

  public List<Team> getTeams() {
    return teams;
  }

  public void setTeams(List<Team> teams) {
    this.teams = teams;
  }

}
