package com.khasianowebb.fantasyfootballstats.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import com.google.gson.annotations.SerializedName;

/**
 * The type Player.
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
   * Gets id.
   *
   * @return the id
   */
  public long getId() {
    return id;
  }

  /**
   * Sets id.
   *
   * @param id the id
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Gets team id.
   *
   * @return the team id
   */
  public Long getTeamId() {
    return teamId;
  }

  /**
   * Sets team id.
   *
   * @param teamId the team id
   */
  public void setTeamId(Long teamId) {
    this.teamId = teamId;
  }

  /**
   * Gets temp team.
   *
   * @return the temp team
   */
  public String getTempTeam() {
    return tempTeam;
  }

  /**
   * Sets temp team.
   *
   * @param tempTeam the temp team
   */
  public void setTempTeam(String tempTeam) {
    this.tempTeam = tempTeam;
  }

  /**
   * Gets jersey.
   *
   * @return the jersey
   */
  public String getJersey() {
    return jersey;
  }

  /**
   * Sets jersey.
   *
   * @param jersey the jersey
   */
  public void setJersey(String jersey) {
    this.jersey = jersey;
  }

  /**
   * Gets last name.
   *
   * @return the last name
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Sets last name.
   *
   * @param lastName the last name
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * Gets first name.
   *
   * @return the first name
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Sets first name.
   *
   * @param firstName the first name
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * Gets position.
   *
   * @return the position
   */
  public String getPosition() {
    return position;
  }

  /**
   * Sets position.
   *
   * @param position the position
   */
  public void setPosition(String position) {
    this.position = position;
  }

  /**
   * Gets college.
   *
   * @return the college
   */
  public String getCollege() {
    return college;
  }

  /**
   * Sets college.
   *
   * @param college the college
   */
  public void setCollege(String college) {
    this.college = college;
  }
}
