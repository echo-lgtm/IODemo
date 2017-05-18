package com.echo.iodemo.model;

import com.echo.iodemo.db.AppDatabase;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.Nullable;

import static com.echo.iodemo.db.AppDatabase.DATABASE_NAME;

/**
 * Created by echo on 5/18/17.
 */

public class DatabaseCreator {

    private AppDatabase mDb;

    private static DatabaseCreator sInstance;

    // For Singleton instantiation
    private static final Object LOCK = new Object();

    public synchronized static DatabaseCreator getInstance(Context context) {
        if (sInstance == null) {
            synchronized (LOCK) {
                if (sInstance == null) {
                    sInstance = new DatabaseCreator();
                }
            }
        }
        return sInstance;
    }


    @Nullable
    public AppDatabase getDb() {
        return mDb;
    }


    public void createDb(final Context context) {

        new AsyncTask<Context, Void, Void>() {
            @Override
            protected Void doInBackground(Context... contexts) {
                context.deleteDatabase(DATABASE_NAME);
                mDb = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class,
                        DATABASE_NAME).build();
                MockUserDataUtils.initializeDb(mDb);

                return null;
            }


        }.execute(context.getApplicationContext());

    }

}
