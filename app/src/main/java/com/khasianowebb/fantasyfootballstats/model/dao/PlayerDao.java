package com.khasianowebb.fantasyfootballstats.model.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.khasianowebb.fantasyfootballstats.model.entity.Player;
import com.khasianowebb.fantasyfootballstats.model.entity.Team;
import java.util.Collection;
import java.util.List;

@Dao
public interface PlayerDao {

  @Insert
  List<Long> insert(Collection<Player> players);

  @Query("SELECT * FROM Player WHERE player_id = :playerId")
  LiveData<Player> getByPlayerId(long playerId);

  @Query("SELECT * FROM Player ORDER BY player_id ASC")
  LiveData<List<Player>> getAllPlayers();

  @Query("SELECT * FROM Player WHERE team_id = :teamId")
  LiveData<List<Player>> getAllPlayersByTeamId(long teamId);

  @Update
  int update(Player player);

  @Delete
  int delete(Player... players);

}
