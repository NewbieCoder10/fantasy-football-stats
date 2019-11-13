package com.khasianowebb.fantasyfootballstats.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import com.google.gson.annotations.SerializedName;

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

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Long getTeamId() {
    return teamId;
  }

  public void setTeamId(Long teamId) {
    this.teamId = teamId;
  }

  public String getTempTeam() {
    return tempTeam;
  }

  public void setTempTeam(String tempTeam) {
    this.tempTeam = tempTeam;
  }

  public String getJersey() {
    return jersey;
  }

  public void setJersey(String jersey) {
    this.jersey = jersey;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public String getCollege() {
    return college;
  }

  public void setCollege(String college) {
    this.college = college;
  }
}
