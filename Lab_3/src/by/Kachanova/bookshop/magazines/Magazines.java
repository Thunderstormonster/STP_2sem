package by.Kachanova.bookshop.magazines;

import by.Kachanova.bookshop.publishing.Publishing;

public class Magazines extends Publishing {

    public Magazines(String author, String name, int year, int edition, int cost) {
        super(author, name, year, edition, cost);
    }

    public Magazines(){
        super();
    }

    @Override
    public String toString() {
        return "Журнал "+getName()+
                " издатель "+getAuthor()+
                " год выпуска "+getYear()+
                " стоимость "+getCost()+
                " тираж "+getEdition();
    }
}
