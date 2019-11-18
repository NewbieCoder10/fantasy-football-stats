package com.khasianowebb.fantasyfootballstats.model.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.khasianowebb.fantasyfootballstats.model.entity.Team;
import java.util.Collection;
import java.util.List;

/**
 * The interface Team dao.
 */
@Dao
public interface TeamDao {

  /**
   * Insert list.
   *
   * @param teams the teams
   * @return the list
   */
  @Insert
  List<Long> insert(Collection<Team> teams);

  /**
   * Gets by team id.
   *
   * @param teamId the team id
   * @return the by team id
   */
  @Query("SELECT * FROM Team WHERE team_id = :teamId")
  LiveData<Team> getByTeamId(long teamId);

  /**
   * Gets by abbreviation.
   *
   * @param abbreviation the abbreviation
   * @return the by abbreviation
   */
  @Query("SELECT team_id FROM Team WHERE abbreviation = :abbreviation")
  Long getByAbbreviation(String abbreviation);

  /**
   * Gets all teams.
   *
   * @return the all teams
   */
  @Query("SELECT * FROM Team")
  LiveData<List<Team>> getAllTeams();

  /**
   * Update int.
   *
   * @param team the team
   * @return the int
   */
  @Update
  int update(Team team);

  /**
   * Delete int.
   *
   * @param teams the teams
   * @return the int
   */
  @Delete
  int delete(Team... teams);

}
