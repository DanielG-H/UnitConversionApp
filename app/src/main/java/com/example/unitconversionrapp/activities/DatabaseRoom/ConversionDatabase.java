package com.example.unitconversionrapp.activities.DatabaseRoom;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.unitconversionrapp.activities.UnitRecordDao;
import com.example.unitconversionrapp.activities.UserDao;
import com.example.unitconversionrapp.activities.UnitRecord;
import com.example.unitconversionrapp.activities.User;

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
