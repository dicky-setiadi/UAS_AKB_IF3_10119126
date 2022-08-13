package com.example.uas_akb_if3_10119126;
// NIM: 10119126
// Nama: Dicky Setiadi
// Kelas: IF-3

public class Model {
    String title, description, date;
    int image;

    public Model(String title, String description, int image) {
        this.title = title;
        this.description = description;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }


    public int getImage() {

        return image;
    }

    public void setImage(int image) {

        this.image = image;
    }
}
