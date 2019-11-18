package com.khasianowebb.fantasyfootballstats.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;


/**
 * The type Team.
 */
@Entity(
    indices = {
        @Index(value = "abbreviation", unique = true),
        @Index(value = "full_name", unique = true),
        @Index(value = "short_name", unique = true)
    }
)
public class  Team {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "team_id")
  private long id;
  private String abbreviation;
  @ColumnInfo(name ="full_name")
  private String fullName;
  @ColumnInfo(name = "short_name")
  private String shortName;

  /**
   * Gets id.
   *
   * @return the id
   */
  public long getId() {
    return id;
  }

  /**
   * Gets abbreviation.
   *
   * @return the abbreviation
   */
  public String getAbbreviation() {
    return abbreviation;
  }

  /**
   * Gets full name.
   *
   * @return the full name
   */
  public String getFullName() {
    return fullName;
  }

  /**
   * Gets short name.
   *
   * @return the short name
   */
  public String getShortName() {
    return shortName;
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
   * Sets abbreviation.
   *
   * @param abbreviation the abbreviation
   */
  public void setAbbreviation(String abbreviation) {
    this.abbreviation = abbreviation;
  }

  /**
   * Sets full name.
   *
   * @param fullName the full name
   */
  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  /**
   * Sets short name.
   *
   * @param shortName the short name
   */
  public void setShortName(String shortName) {
    this.shortName = shortName;
  }
}
