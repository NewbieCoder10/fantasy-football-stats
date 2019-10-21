package com.khasianowebb.fantasyfootballstats.model.dao;


import androidx.room.Dao;
import androidx.room.Delete;
import com.khasianowebb.fantasyfootballstats.model.entity.Team;

@Dao
public interface TeamDao {

  @Delete
  int delete(Team... teams);

}
