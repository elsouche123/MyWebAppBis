package models;

import java.sql.Timestamp;

public class Annonce {
    private int id;
    private String title;
    private String description;
    private String adress;
    private String mail;
    private Timestamp date;

    public Annonce(String title, String description, String adress, String mail, Timestamp date) {
        this.title = title;
        this.description = description;
        this.adress = adress;
        this.mail = mail;
        this.date = date;
    }

    public Annonce(int id, String title, String description, String adress, String mail, Timestamp date) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.adress = adress;
        this.mail = mail;
        this.date = date;
    }


    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getAdress() { return adress; }
    public String getMail() { return mail; }
    public Timestamp getDate() { return date; }

}
