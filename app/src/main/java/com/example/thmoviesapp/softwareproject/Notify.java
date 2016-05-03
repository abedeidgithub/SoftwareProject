package com.example.thmoviesapp.softwareproject;

/**
 * Created by Abed Eid on 01/05/2016.
 */
public class Notify  {
    String tilte;
    String Dec;
    String Subject;
    String Doctor;

    public Notify() {
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public String getDoctor() {
        return Doctor;
    }

    public void setDoctor(String doctor) {
        Doctor = doctor;
    }

    public String getTilte() {
        return tilte;
    }

    public void setTilte(String tilte) {
        this.tilte = tilte;
    }

    public String getDec() {
        return Dec;
    }

    public void setDec(String dec) {
        Dec = dec;
    }
}
