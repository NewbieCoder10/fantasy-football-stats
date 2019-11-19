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
   * Insert list from the Collection of players.
   *
   * @param players the players
   * @return the list of the players in the Dao interface.
   */
  @Insert
  List<Long> insert(Collection<Player> players);

  /**
   * Gets by player id from the long playerId.
   *
   * @param playerId the player id
   * @return the by player id from the LiveData.
   */
  @Query("SELECT * FROM Player WHERE player_id = :playerId")
  LiveData<Player> getByPlayerId(long playerId);

  /**
   * Gets all players from the query of LiveData
   *
   * @return the all players from the query of LiveData.
   */
  @Query("SELECT * FROM Player ORDER BY player_id ASC")
  LiveData<List<Player>> getAllPlayers();

  /**
   * Gets all players by team id.
   *
   * @param teamId the team id
   * @return the all players by team id in the long teamId.
   */
  @Query("SELECT * FROM Player WHERE team_id = :teamId")
  LiveData<List<Player>> getAllPlayersByTeamId(long teamId);

  @Query("SELECT * FROM Player WHERE first_name LIKE :namePart OR last_name LIKE :namePart ORDER BY last_name, first_name")
  LiveData<List<Player>> search(String namePart);

  @Query("SELECT * FROM Player WHERE team_id = :teamId AND (first_name LIKE :namePart OR last_name LIKE :namePart) ORDER BY last_name, first_name")
  LiveData<List<Player>> search(long teamId, String namePart);

  /**
   * Update int from the player, player.
   *
   * @param player the player
   * @return the int updated with the Player, player.
   */
  @Update
  int update(Player player);

  /**
   * Delete int of the player, & players.
   *
   * @param players the players
   * @return the int of the delete call of player, players.
   */
  @Delete
  int delete(Player... players);

}
