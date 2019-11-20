package com.khasianowebb.fantasyfootballstats.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import com.google.gson.annotations.SerializedName;

/**
 * The type Player entity.
 */
@Entity(
    foreignKeys = {
        @ForeignKey(
        entity = Team.class,
        childColumns = "team_id",
        parentColumns = "team_id",
        onDelete = ForeignKey.CASCADE
        )
    }
)
public class Player {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "player_id")
  private long id;

  @ColumnInfo(name = "team_id", index = true)
  private Long teamId;

  @Ignore
  @SerializedName("team")
  private String tempTeam;

  @ColumnInfo(index = true)
  private String jersey;

  @ColumnInfo(name = "last_name", index = true)
  @SerializedName("lname")
  private String lastName;

  @ColumnInfo(name = "first_name", index = true)
  @SerializedName("fname")
  private String firstName;

  @ColumnInfo(index = true)
  private String position;

  @ColumnInfo(index = true)
  private String college;

  /**
   * Gets id of the public long getId
   *
   * @return the id of the public long id.
   */
  public long getId() {
    return id;
  }

  /**
   * Sets id of the long.
   *
   * @param id the id of the public void id.
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Gets team id from the public Long getTeamId
   *
   * @return the team id of the public Long return, the id.
   */
  public Long getTeamId() {
    return teamId;
  }

  /**
   * Sets team id of the setTeamId.
   *
   * @param teamId the team id of the public void, setTeamId,
   */
  public void setTeamId(Long teamId) {
    this.teamId = teamId;
  }

  /**
   * Gets temp team from the @String getTempTeam.
   *
   * @return the @String for the getTempTeam.
   */
  public String getTempTeam() {
    return tempTeam;
  }

  /**
   * Sets temp team, from the public void setTempTeam.
   *
   * @param tempTeam the temp team from the public void setTempTeam.
   */
  public void setTempTeam(String tempTeam) {
    this.tempTeam = tempTeam;
  }

  /**
   * Gets @String jersey for the player.
   *
   * @return the @String jersey for the player.
   */
  public String getJersey() {
    return jersey;
  }

  /**
   * Sets jersey from the public void setJersey method.
   *
   * @param jersey the jersey from public void, setJersey method.
   */
  public void setJersey(String jersey) {
    this.jersey = jersey;
  }

  /**
   * Gets last name from the @String of getLastName.
   *
   * @return the last name from the @String of getLastName.
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Sets last name from the public void setLastName.
   *
   * @param lastName the last name from public void setNameName.
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * Gets first name from the @String of getFirstName.
   *
   * @return the first name from the public @String getFirstName.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Sets first name from the public void setFirstName.
   *
   * @param firstName the first name of the public void setFirstName.
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * Gets position from the @String of getPosition.
   *
   * @return the position from the @String of getPosition.
   */
  public String getPosition() {
    return position;
  }

  /**
   * Sets position from the public void setPosition.
   *
   * @param position the position from the public void setPosition.
   */
  public void setPosition(String position) {
    this.position = position;
  }

  /**
   * Gets college from the @String of getCollege.
   *
   * @return the college @String of the getCollege.
   */
  public String getCollege() {
    return college;
  }

  /**
   * Sets college from the public void, setCollege.
   *
   * @param college the college from public void, setCollege.
   */
  public void setCollege(String college) {
    this.college = college;
  }

  @Override
  public String toString() {
    return lastName + ", " + firstName;
  }
}
