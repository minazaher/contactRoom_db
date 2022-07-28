package com.example.androidroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.androidroom.Model.Contact;
import com.example.androidroom.Model.ContactViewModel;

public class MainActivity extends AppCompatActivity {
    private ContactViewModel contactViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactViewModel = new ViewModelProvider.AndroidViewModelFactory(MainActivity.this.getApplication())
                                .create(ContactViewModel.class);

        //adding a contact
        Contact contact = new Contact("Mina", "Student");
        contactViewModel.Insert(contact);



        contactViewModel.getAllContacts().observe(this, allContacts -> {
            for (Contact c: allContacts) {
                System.out.println("Item " + c.toString());
            }
        });
    }
}