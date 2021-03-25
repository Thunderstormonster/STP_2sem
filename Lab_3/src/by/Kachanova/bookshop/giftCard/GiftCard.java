package by.Kachanova.bookshop.giftCard;

import by.Kachanova.bookshop.publishing.Publishing;

public class GiftCard extends Publishing {
    private int cost;
    private int year;
    Type type;
    Size size;


    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        if(cost>0) {
            this.cost = cost;
        }
        else{
            System.out.println("Цена не может быть отрицательной");
        }
    }
    public GiftCard(int cost, Type type, Size size,int year) {
        this.cost = cost;
        this.type = type;
        this.size = size;
        this.year=year;
    }


    @Override
    public String toString() {
        return "Открытка " + type+
                " цена " + cost +
                " размер " + size+
                " год "+year;
    }
}
