package by.Kachanova.bookshop.books;

import by.Kachanova.bookshop.publishing.Publishing;

public class Book extends Publishing {
    class Editor{
        public String name;
        public Book book;

        public Editor(String name) {
            book=Book.this;
            this.name = name;
        }
    }

    public Editor editor;
    BookType bookType;

    public Book() {
        super();
    }

    public Book(String author, String name, int year, int edition, int cost, String editor, BookType bookType) {
        super(author, name, year, edition, cost);
        this.editor=new Editor(editor);
        this.bookType = bookType;
    }

    @Override
    public String toString() {
        return "Книга: " + getName()+
                ", автор: " + getAuthor() +
                ", год издания: " + getYear() +
                ", стоимость "+getCost()+
                ", издатель"+editor.name+
                ", тираж "+getEdition();
    }



}
