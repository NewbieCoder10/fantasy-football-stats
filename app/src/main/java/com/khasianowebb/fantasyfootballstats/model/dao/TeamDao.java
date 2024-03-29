package com.khasianowebb.fantasyfootballstats.model.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;
import com.khasianowebb.fantasyfootballstats.model.entity.Team;
import com.khasianowebb.fantasyfootballstats.model.pojo.TeamWithPlayers;
import java.util.Collection;
import java.util.List;

/**
 * The interface Team dao.
 */
@Dao
public interface TeamDao {

  /**
   * Insert list of the Collection of teams.
   *
   * @param teams the teams
   * @return the list of Long, collection of teams.
   */
  @Insert
  List<Long> insert(Collection<Team> teams);

  /**
   * Gets by team id from the LiveData team.
   *
   * @param teamId the team id
   * @return the by team id from the LiveData of long teamId.
   */
  @Query("SELECT * FROM Team WHERE team_id = :teamId")
  LiveData<Team> getByTeamId(long teamId);

  @Transaction
  @Query("SELECT * FROM Team WHERE team_id = :teamId")
  LiveData<TeamWithPlayers> getByTeamIdWithPlayers(long teamId);

  /**
   * Gets by abbreviation.
   *
   * @param abbreviation the abbreviation of the Long.
   * @return the by abbreviation from the String abbreviation.
   */
  @Query("SELECT team_id FROM Team WHERE abbreviation = :abbreviation")
  Long getByAbbreviation(String abbreviation);

  /**
   * Gets all teams.
   *
   * @return the all teams from the LiveData to getAllTeams.
   */
  @Query("SELECT * FROM Team")
  LiveData<List<Team>> getAllTeams();

  /**
   * Update int.
   *
   * @param team the team int is updated.
   * @return the int on an update of a Team, team.
   */
  @Update
  int update(Team team);

  /**
   * Delete int.
   *
   * @param teams the teams
   * @return the int of delete of team, teams.
   */
  @Delete
  int delete(Team... teams);

}
