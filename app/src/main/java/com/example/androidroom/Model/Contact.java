package com.example.androidroom.Model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "contacts_table")
public class Contact {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int ID ;

    @ColumnInfo(name = "name")
    private String Name;

    @ColumnInfo(name = "occupation")
    private String Occupation;

    public Contact() {
    }

    public Contact(@NonNull String name, String occupation) {
        Name = name;
        Occupation = occupation;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getOccupation() {
        return Occupation;
    }

    public void setOccupation(String occupation) {
        Occupation = occupation;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                ", Occupation='" + Occupation + '\'' +
                '}';
    }
}
