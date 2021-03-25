package by.Kachanova.bookshop.bookstore;

import by.Kachanova.bookshop.publishing.Publishing;
import java.util.ArrayList;

public class Bookstore {
    String name;

    public Bookstore(String name) {
        this.name = name;
    }

    public Bookstore() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    ArrayList<Publishing> book=new ArrayList<>();

    public void setBook(ArrayList<Publishing> book) {
        if(book==null)
            throw new NullPointerException("Null pointer");
        this.book=book;
    }

    public ArrayList<Publishing> getBook() {
        return book;
    }

    public void AddBook (Publishing edit) {        //добавить
        if(edit == null)
            throw new NullPointerException("Null pointer");
        System.out.println("Была добавлена "+edit.toString());
        this.book.add(edit);
    }
    public void Sell (Publishing edit) {        //добавить
        if(edit == null)
            throw new NullPointerException("Null pointer");
        this.book.remove(edit);
        System.out.println("Была продана книга "+edit.getName());
    }

    public ArrayList<Publishing> GetBook() {
        return this.book;
    }



}
