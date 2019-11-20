package com.khasianowebb.fantasyfootballstats.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import com.google.gson.annotations.SerializedName;


/**
 * The type Team from the entity.
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

  @SerializedName("code")
  private String abbreviation;

  @ColumnInfo(name ="full_name")
  private String fullName;

  @ColumnInfo(name = "short_name")
  private String shortName;

  /**
   * Gets id from the public long, getId.
   *
   * @return the id from the public long, getId.
   */
  public long getId() {
    return id;
  }

  /**
   * Gets abbreviation from the @String getAbbreviation.
   *
   * @return the abbreviation from the @String getAbbreviation.
   */
  public String getAbbreviation() {
    return abbreviation;
  }

  /**
   * Gets full name from the @String getFullName.
   *
   * @return the full name from the @String from getFullName.
   */
  public String getFullName() {
    return fullName;
  }

  /**
   * Gets short name from the @String of getShortName.
   *
   * @return the short name from the @String of getShortName.
   */
  public String getShortName() {
    return shortName;
  }

  /**
   * Sets id from the public void setId of the long.
   *
   * @param id the id from the public void setId of the long
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Sets abbreviation from the public void setAbbreviation in @String.
   *
   * @param abbreviation the abbreviation from the public void setAbbreviation in @String.
   */
  public void setAbbreviation(String abbreviation) {
    this.abbreviation = abbreviation;
  }

  /**
   * Sets full name from the public void, setFullName from the @String.
   *
   * @param fullName the full name from the public void, setFullName from the @String.
   */
  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  /**
   * Sets short name from the public void, of setShortName of the @String.
   *
   * @param shortName the short name from the public void, of setShortName of the @String.
   */
  public void setShortName(String shortName) {
    this.shortName = shortName;
  }

  @Override
  public String toString() {
    return fullName;
  }
}
