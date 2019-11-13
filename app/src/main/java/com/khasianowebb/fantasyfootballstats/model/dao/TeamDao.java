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

@Dao
public interface TeamDao {

  @Insert
  List<Long> insert(Collection<Team> teams);

  @Query("SELECT * FROM Team WHERE team_id = :teamId")
  LiveData<Team> getByTeamId(long teamId);

  @Query("SELECT team_id FROM Team WHERE abbreviation = :abbreviation")
  Long getByAbbreviation(String abbreviation);

  @Query("SELECT * FROM Team")
  LiveData<List<Team>> getAllTeams();

  @Update
  int update(Team team);

  @Delete
  int delete(Team... teams);

}
