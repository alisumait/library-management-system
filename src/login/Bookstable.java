/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.util.ArrayList;

/**
 *
 * @author alisu
 */
public class Bookstable {
    
    private String name;
    private String isbn;
    private String author;
    private String publisher;
    private String status;
    
    public Bookstable(){
    
        this.name = "";
        this.isbn = "";
        this.author = "";
        this.publisher = "";
        this.status = "";
    
    }
    
    public Bookstable(String name, String isbn, String author, String publisher, String status){
        this.name = name;
        this.isbn = isbn;
        this.author = author;
        this.publisher = publisher;
         this.status = status;}
    

    Bookstable(ArrayList<String> names, ArrayList<String> isbns, ArrayList<String> authors, ArrayList<String> publishers, ArrayList<String> statuss) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Bookstable(boolean contains, String text, String text0, String text1, String available) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Bookstable(boolean contains, boolean contains0, String text, String text0, String available) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Bookstable(boolean contains, boolean contains0, boolean contains1, String text, String available) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Bookstable(boolean contains, boolean contains0, boolean contains1, boolean contains2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}