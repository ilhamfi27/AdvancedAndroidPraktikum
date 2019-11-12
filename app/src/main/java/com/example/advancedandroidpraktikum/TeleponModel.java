package com.example.advancedandroidpraktikum;

public class TeleponModel {

    int id;
    int idContact;
    String nomor;
    String jenisContact;

    public TeleponModel(int id, int idContact, String nomor, String jenisContact) {
        this.id = id;
        this.idContact = idContact;
        this.nomor = nomor;
        this.jenisContact = jenisContact;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdContact() {
        return idContact;
    }

    public void setIdContact(int idContact) {
        this.idContact = idContact;
    }

    public String getNomor() {
        return nomor;
    }

    public void setNomor(String nomor) {
        this.nomor = nomor;
    }

    public String getJenisContact() {
        return jenisContact;
    }

    public void setJenisContact(String jenisContact) {
        this.jenisContact = jenisContact;
    }
}
