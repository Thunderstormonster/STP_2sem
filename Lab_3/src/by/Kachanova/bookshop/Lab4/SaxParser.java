package by.Kachanova.bookshop.Lab4;

import by.Kachanova.bookshop.books.Book;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxParser extends DefaultHandler {

    Book book=new Book();
    String thisElement = "";
    public Book getResult(){return book;};
    @Override
    public void startDocument() throws SAXException {
        System.out.println("----> Start parse XML...");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("----> Stop parse XML...");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        thisElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        thisElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(thisElement.equals("author")){
            book.author=new String(ch,start,length);
        }else if(thisElement.equals("name")){
            book.name=new String(ch,start,length);
        }else if(thisElement.equals("year")){
            book.year=new Integer(new String(ch, start, length));
        }else if(thisElement.equals("edition")){
            book.edition=new Integer(new String(ch, start, length));
        }else if(thisElement.equals("cost")){
            book.cost=new Integer(new String(ch, start, length));
        }
    }
}
