package com.example.admin.report;

import java.io.Serializable;

/**
 * Created by Admin on 8/21/2017.
 */

public class Report implements Serializable{

    private String Name, Surname, Email, Comment;
    private int Maths;
    private int English;
    private int Isizilu;
    private int LifeScience;
    private int Computer;
    private int Physicalscience;
    private int Total;
    private int Id;
    private byte[] Image;

    public Report() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getSurname() {
        return Surname;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getEmail() {
        return Email;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public String getComment() {
        return Comment;
    }

    public void setEnglish(int english) {
        English = english;
    }

    public int getEnglish() {
        return English;
    }

    public void setMaths(int maths) {
        Maths = maths;
    }

    public int getMaths() {
        return Maths;
    }

    public void setIsizilu(int isizilu) {
        Isizilu = isizilu;
    }

    public int getIsizilu() {
        return Isizilu;
    }

    public void setLifeScience(int lifeScience) {
        LifeScience = lifeScience;
    }

    public int getLifeScience() {
        return LifeScience;
    }

    public void setComputer(int computer) {
        Computer = computer;
    }

    public int getComputer() {
        return Computer;
    }

    public void setPhysicalscience(int physicalscience) {
        Physicalscience = physicalscience;
    }

    public int getPhysicalscience() {
        return Physicalscience;
    }

    public void setTotal(int total) {
        Total = total;
    }

    public int getTotal() {
        return Total;
    }

    public void setImage(byte[] image) {
        Image = image;
    }

    public byte[] getImage() {
        return Image;
    }

}
