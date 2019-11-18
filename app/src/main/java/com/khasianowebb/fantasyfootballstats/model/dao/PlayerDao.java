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

/**
 * The interface Player dao.
 */
@Dao
public interface PlayerDao {

  /**
   * Insert list.
   *
   * @param players the players
   * @return the list
   */
  @Insert
  List<Long> insert(Collection<Player> players);

  /**
   * Gets by player id.
   *
   * @param playerId the player id
   * @return the by player id
   */
  @Query("SELECT * FROM Player WHERE player_id = :playerId")
  LiveData<Player> getByPlayerId(long playerId);

  /**
   * Gets all players.
   *
   * @return the all players
   */
  @Query("SELECT * FROM Player ORDER BY player_id ASC")
  LiveData<List<Player>> getAllPlayers();

  /**
   * Gets all players by team id.
   *
   * @param teamId the team id
   * @return the all players by team id
   */
  @Query("SELECT * FROM Player WHERE team_id = :teamId")
  LiveData<List<Player>> getAllPlayersByTeamId(long teamId);

  /**
   * Update int.
   *
   * @param player the player
   * @return the int
   */
  @Update
  int update(Player player);

  /**
   * Delete int.
   *
   * @param players the players
   * @return the int
   */
  @Delete
  int delete(Player... players);

}
