package by.Kachanova.bookshop.salesman;

import by.Kachanova.bookshop.bookstore.Bookstore;

public interface ISalesman {
    void sort (Bookstore ed);
    Bookstore find (Bookstore ed, String name);
}
