package by.Kachanova.bookshop.main;

import by.Kachanova.bookshop.Lab4.SaxParser;
import by.Kachanova.bookshop.books.Book;
import by.Kachanova.bookshop.books.BookType;
import by.Kachanova.bookshop.bookstore.Bookstore;
import by.Kachanova.bookshop.giftCard.GiftCard;
import by.Kachanova.bookshop.giftCard.Size;
import by.Kachanova.bookshop.giftCard.Type;
import by.Kachanova.bookshop.magazines.Magazines;
import by.Kachanova.bookshop.publishing.Publishing;
import by.Kachanova.bookshop.salesman.Salesman;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.xml.sax.XMLReader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    static {
        new DOMConfigurator().doConfigure("log/log4j.xml", LogManager.getLoggerRepository());
    }

    private static final Logger LOG = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        try{
            Salesman saleman=new Salesman();
            Bookstore store1=new Bookstore("HELP");

            LOG.info("_______________Start to full fill my shop__________________________");
            ArrayList<Publishing> h = new ArrayList<Publishing>();
            Book book1 = new Book("Эрагон","Кристофер Паолини",2009,22000,20,"Как-то там",BookType.Fantasy);
            Book book2 = new Book("Артемис Фаул", "Оуэн Колфер",2001,28000,29,"Зачем-то",BookType.Fantasy);
            Magazines magazine1 = new Magazines("Хёрст Шкулёв Паблишинг","PSYCHOLOGIES",2020,32000,13);
            GiftCard giftcard1 = new GiftCard(2, Type.Birthday, Size.A5,2000);
            h.add(book1);
            h.add(book2);
            h.add(magazine1);
            h.add(giftcard1);
            /*store1.AddBook(book1);
            store1.AddBook(book2);
            store1.AddBook(magazine1);
            store1.AddBook(giftcard1);
            for (Publishing ed:
                    store1.getBook()) {
                System.out.println(ed.toString());

            }
            LOG.info("_______________Sort my books__________________________");
            saleman.sort(store1);

            for (Publishing ed:
                    store1.getBook()) {
                System.out.println(ed.toString());

            }
            LOG.info("_______________Add one more book__________________________");
            store1.AddBook(magazine1);
            for (Publishing ed:
                    store1.getBook()) {
                System.out.println(ed.toString());

            }



            LOG.info("_______________Find book__________________________");
            saleman.find(store1,"Кристофер Паолини");
            //store1.AddBook(magazine1);

            for (Publishing ed:
                    store1.getBook()) {
                System.out.println(ed.toString());

            }

            LOG.info("_______________Find book__________________________");
            //saleman.find(store1,"Кристофер Паолини");
            LOG.info("_______________Sell another book__________________________");
            //store1.Sell(book1);*/
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            SaxParser saxp = new SaxParser();
            parser.parse(new File("files/Books.xml"), saxp);
            Book some1 = saxp.getResult();
            System.out.println(some1.author);
            System.out.println(some1.name);
            System.out.println(some1.year);
            System.out.println(some1.edition);
            System.out.println(some1.cost);

            //--Сериализация XML
            System.out.println("--------------Сериализация XML------------------");
            FileOutputStream out = new FileOutputStream("files/Serialize.xml");
            XMLEncoder xmlEncoder = new XMLEncoder(out);
            xmlEncoder.writeObject(some1);
            xmlEncoder.close();
            //--Десиреализация XML
            System.out.println("--------------Десериализация XML------------------");
            FileInputStream in = new FileInputStream("files/Serialize.xml");
            XMLDecoder xmlDecoder = new XMLDecoder(in);
            Book some2 = (Book) xmlDecoder.readObject();
            xmlDecoder.close();
            System.out.println(some2.author);
            System.out.println(some2.name);
            System.out.println(some2.year);
            System.out.println(some2.edition);
            System.out.println(some2.cost);
            //--Сериализация Json
            System.out.println("-----------------Сериализация JSON---------------");
            Gson gson = new GsonBuilder().create();
            String json = gson.toJson(some1);
            System.out.println(json);
            FileOutputStream jsonOut = new FileOutputStream("files/Serialize.json");
            byte[] outText = json.getBytes(StandardCharsets.UTF_8);
            jsonOut.write(outText, 0, outText.length);
            //--Десериализация Json
            System.out.println("--------------Десериализация JSON---------------");
            Scanner scanner = new Scanner(new File("files/Serialize.json"));
            String res = "";
            while(scanner.hasNext())
                res += scanner.nextLine();
            scanner.close();
            Book m3 = gson.fromJson(res, Book.class);
            System.out.println(m3.author);
            System.out.println(m3.name);
            System.out.println(m3.year);
            System.out.println(m3.edition);
            System.out.println(m3.cost);
            //--Stream API
            System.out.println("-------------------Stream API-------------");
            Stream<Publishing> res_stream = h.stream().filter(w -> w.getCost() > 20);
            for(var x: res_stream.collect(Collectors.toList()))
            {
                System.out.println(x.name + " " + x.cost);
            }
            System.out.println("----------------------------------");
            Stream<Publishing> res_stream2 = h.stream().limit(2);
            for(var x: res_stream2.collect(Collectors.toList()))
            {
                System.out.println(x.name + " " + x.cost);
            }





        }
        catch (Exception e){

        }
    }
}
