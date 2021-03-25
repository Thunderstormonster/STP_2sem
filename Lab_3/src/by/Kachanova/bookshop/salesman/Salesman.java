package by.Kachanova.bookshop.salesman;

import by.Kachanova.bookshop.publishing.Publishing;
import java.util.*;
import by.Kachanova.bookshop.bookstore.Bookstore;

public class Salesman implements ISalesman {

    public Salesman() {
    }


    @Override
    public void sort(Bookstore ed) {
        ArrayList<Publishing> e = ed.GetBook();
        e.sort(new Comparator<Publishing>() {
            @Override
            public int compare(Publishing o1, Publishing o2) {
                return o1.getYear() > o2.getYear() ? -1 : (o1.getYear() > o2.getYear()) ? 1 : 0;
            }
        });
    }

    @Override
    public Bookstore find(Bookstore ed, String name) {
        if (name != null) {
            Bookstore sh = new Bookstore();
            for (Publishing e : ed.GetBook()) {
                if(e.getName().equals(name)) {
                    System.out.println("В магазине "+ed.getName().toString()+" была найдена книга "+e.getName().toString());
                    sh.AddBook(e);
                }
            }
            return sh;
        }
        else {
            throw new NullPointerException("Null pointer");
        }
    }



}
