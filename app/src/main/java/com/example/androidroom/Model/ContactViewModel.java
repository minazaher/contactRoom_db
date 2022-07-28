package com.example.androidroom.Model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.androidroom.Data.ContactRepository;

import java.util.ArrayList;
import java.util.List;

public class ContactViewModel extends AndroidViewModel {
    public static ContactRepository repository;
    private LiveData<List<Contact>> allContacts ;

    public ContactViewModel(@NonNull Application application) {
        super(application);

        repository = new ContactRepository(application);
        allContacts = repository.getAllContacts();
    }

    public LiveData<List<Contact>> getAllContacts (){
        return allContacts;
    }

    public static void Insert (Contact contact){
        repository.insertContact(contact);
    }
}
