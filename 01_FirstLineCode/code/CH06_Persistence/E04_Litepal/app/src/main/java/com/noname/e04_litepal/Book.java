package com.noname.e04_litepal;

public class Book {
    private int id;
    private String author;
    private String name;
    private double price;
    private int pages;

    public Book(int id, String author, String name, double price, int pages) {
        this.id = id;
        this.author = author;
        this.name = name;
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
}
