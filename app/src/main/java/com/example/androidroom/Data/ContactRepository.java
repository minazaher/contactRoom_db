package com.example.androidroom.Data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.androidroom.Model.Contact;
import com.example.androidroom.Utilites.ContactsRoomDatabase;

import java.util.ArrayList;
import java.util.List;

public class ContactRepository {
    private ContactDao contactDao;
    private LiveData<List<Contact>> allContacts;

    public ContactRepository(Application application){
        ContactsRoomDatabase db = ContactsRoomDatabase.getInstance(application);

        contactDao = db.contactDao();
        allContacts = contactDao.getAll();
    }

    public LiveData<List<Contact>> getAllContacts (){
        return allContacts;
    }

    public void insertContact (Contact contact) {
    ContactsRoomDatabase.DatabaseWriterExecutor.execute(new Runnable() {
        @Override
        public void run() {
            contactDao.insert(contact) ;
        }
    });
    }
}
