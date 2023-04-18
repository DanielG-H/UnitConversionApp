package com.example.unitconversionrapp.activities;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {User.class, UnitRecord.class}, version = 1)
public abstract class ConversionDatabase extends RoomDatabase {

    public abstract UserDao userDao();
    public abstract UnitRecordDao unitRecordDao();

    public static ConversionDatabase INSTANCE;
    public static ConversionDatabase getDatabase(final Context context){
        if (INSTANCE == null){
            synchronized (ConversionDatabase.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ConversionDatabase.class, "ConversionDatabase").fallbackToDestructiveMigration().build();
                }
            }
        }

        return INSTANCE;
    }
//    private static final String DB_NAME = "person_db";
//    private static ConversionDatabase instance;
//    public static synchronized ConversionDatabase getInstance(Context context) {
//        if (instance == null) {
//            instance = Room.databaseBuilder(context.getApplicationContext(), ConversionDatabase.class,
//                            DB_NAME).fallbackToDestructiveMigration().build();
//            }
//            return instance;
//        }

}
