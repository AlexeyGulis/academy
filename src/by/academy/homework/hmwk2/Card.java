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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (cardnum != null ? !cardnum.equals(card.cardnum) : card.cardnum != null) return false;
        return cardmast != null ? cardmast.equals(card.cardmast) : card.cardmast == null;
    }

    @Override
    public int hashCode() {
        int result = cardnum != null ? cardnum.hashCode() : 0;
        result = 31 * result + (cardmast != null ? cardmast.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        if(this != null){
            return cardnum +
                    "  " + cardmast;
        }return " Карта не найдена ";

    }
}
