package com.example.unitconversionrapp.DatabaseRoom;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.unitconversionrapp.DAOs.DaoUser;
import com.example.unitconversionrapp.Entities.User;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class ConversionDatabase extends RoomDatabase {
    public abstract DaoUser userDao();

    public static ConversionDatabase INSTANCE;

    public static ConversionDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ConversionDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ConversionDatabase.class, "ConversionDatabase").fallbackToDestructiveMigration().build();
                }
            }
        }

        return INSTANCE;
    }
}
