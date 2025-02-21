/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author SideQuest
 */
public class BookDTO {
    private String BookID;
    private String title;
    private String author;
    private int publishYear;
    private double price;
    private int quantity;

    public BookDTO() {
    }

    
    
    public BookDTO(String BookID, String title, String author, int publishYear, double price, int quantity) {
        this.BookID = BookID;
        this.title = title;
        this.author = author;
        this.publishYear = publishYear;
        this.price = price;
        this.quantity = quantity;
    }

    public String getBookID() {
        return BookID;
    }

    public void setBookID(String BookID) {
        this.BookID = BookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
}
