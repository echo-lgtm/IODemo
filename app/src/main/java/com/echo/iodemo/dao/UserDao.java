package com.echo.iodemo.dao;

import com.echo.iodemo.model.UserEntity;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by echo on 5/18/17.
 */

@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<UserEntity> users);

    @Query("SELECT * FROM users")
    List<UserEntity> loadAllUsers();


}
