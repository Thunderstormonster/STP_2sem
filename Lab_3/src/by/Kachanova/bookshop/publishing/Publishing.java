package by.Kachanova.bookshop.publishing;

public abstract class Publishing {
    public String author;
    public String name;
    public int year;
    public int edition;//тираж книги
    public int cost;

    public Publishing(String author, String name, int year, int edition, int cost) {
        this.author = author;
        this.name = name;
        this.year = year;
        this.edition = edition;
        this.cost = cost;
    }

    public Publishing() {
    }


    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        if(cost>300 && cost <7){
            System.out.println("Такой книги не может быть");
        }
        this.cost = cost;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        if(edition>200000 && edition <10000){
            System.out.println("Такой книги не может быть");
        }
        this.edition = edition;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if(year>2021 && year <1900){
            System.out.println("Такой книги не может быть");
        }
        this.year = year;
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





}
