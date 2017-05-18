package com.echo.iodemo.db;

import com.echo.iodemo.dao.UserDao;
import com.echo.iodemo.model.UserEntity;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by echo on 5/18/17.
 */

@Database(entities = {UserEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase{

    public static final String DATABASE_NAME = "io-demo-db";

    public abstract UserDao userDao();

}
