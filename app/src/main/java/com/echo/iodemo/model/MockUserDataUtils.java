package com.echo.iodemo.model;

import com.echo.iodemo.db.AppDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by echo on 5/18/17.
 */

public class MockUserDataUtils {


    public static void initializeDb(AppDatabase db) {
        List<UserEntity> userEntities = new ArrayList<UserEntity>();
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1);
        userEntity.setAge(12);
        userEntity.setName("echo");
        userEntities.add(userEntity);
        insertData(db, userEntities);
    }



    private static void insertData(AppDatabase db, List<UserEntity> users) {
        db.beginTransaction();
        try {
            db.userDao().insertAll(users);
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }
    }




}
