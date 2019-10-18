package model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;


@Entity(
    indices = {
        @Index(value = "abbreviation", unique = true),
        @Index(value = "full_name", unique = true),
        @Index(value = "short_name", unique = true)
    }
)
public class Team {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "team_id")
  private long id;
  private String abbreviation;
  @ColumnInfo(name ="full_name")
  private String fullName;
  @ColumnInfo(name = "short_name")
  private String shortName;

  public long getId() {
    return id;
  }

  public String getAbbreviation() {
    return abbreviation;
  }

  public String getFullName() {
    return fullName;
  }

  public String getShortName() {
    return shortName;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setAbbreviation(String abbreviation) {
    this.abbreviation = abbreviation;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public void setShortName(String shortName) {
    this.shortName = shortName;
  }
}
