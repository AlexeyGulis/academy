package by.academy.homework.hmwk2;

public class Card {
    String cardnum;
    String cardmast;

    public Card(String cardnum, String cardmast) {
        this.cardnum = cardnum;
        this.cardmast = cardmast;
    }

    public String getCardnum() {
        return cardnum;
    }

    public String getCardmast() {
        return cardmast;
    }

    @Override
    public String toString() {
        if (this != null) {
            return cardnum +
                    "  " + cardmast;
        }
        return " Карта не найдена ";

    }
}
