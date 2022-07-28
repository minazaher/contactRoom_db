package com.example.androidroom.Utilites;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.androidroom.Data.ContactDao;
import com.example.androidroom.Model.Contact;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Contact.class}, version = 1 , exportSchema = false)
public abstract class ContactsRoomDatabase extends RoomDatabase {

    public abstract ContactDao contactDao();
    public static final int NO_OF_THREADS = 4;

    private static volatile ContactsRoomDatabase Instance;
    public static final ExecutorService DatabaseWriterExecutor = Executors.newFixedThreadPool(NO_OF_THREADS);

    public static ContactsRoomDatabase getInstance(final Context context){
        if (Instance == null){
            synchronized (ContactsRoomDatabase.class){
                if (Instance == null){
                    Instance = Room.databaseBuilder(context.getApplicationContext(), ContactsRoomDatabase.class,
                            "contacts_db").addCallback(sRoomDatabaseCallback).build();
                }
            }
        }
        return Instance;
    }

    private static final RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback()
    {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            DatabaseWriterExecutor.execute(() -> {
                ContactDao contactDao = Instance.contactDao();
                contactDao.DeleteAll();
            });
        }
    };
}
