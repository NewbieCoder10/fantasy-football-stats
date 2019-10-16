package model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

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
  @ColumnInfo(name = "id")
  private long id;
  @ColumnInfo(name = "team_id", index = true)
  private long teamId;
  @ColumnInfo(name = "jersey", index = true)
  private String jersey;
  @ColumnInfo(name = "last_name", index = true)
  private String lastName;
  @ColumnInfo(name = "first_name", index = true)
  private String firstName;
  @ColumnInfo(name = "position")
  private String position;
  @ColumnInfo(name = "college")
  private String college;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getTeamId() {
    return teamId;
  }

  public void setTeamId(long teamId) {
    this.teamId = teamId;
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
