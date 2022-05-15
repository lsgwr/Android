package com.noname.e04_litepal;

import org.litepal.crud.LitePalSupport;

public class Book extends LitePalSupport{
    private int id;
    private String author;
    private String name;
    private String press;
    private double price;
    private int pages;

    public Book(String name,String author, String press, double price, int pages) {
        this.author = author;
        this.name = name;
        this.press = press;
        this.price = price;
        this.pages = pages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }
}
