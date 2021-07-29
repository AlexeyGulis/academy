package by.academy.homework.hmwk3;

public class Tea extends Product {
    private static String typeDis = "Chernyi";
    private static int countPackDis = 20;
    private int countPack;
    private String type;
    private double discount = 0.25;

    protected double getDiscount() {
        double result = 0.0;
        if (countPack >= countPackDis && typeDis.equals(type)) {
            result = discount;
        }
        return result;
    }

    public Tea(String name, double price, int quantity, int countPack, String type) {
        super(name, price, quantity);
        this.countPack = countPack;
        this.type = type;
    }

    public int getCountPack() {
        return countPack;
    }

    public void setCountPack(int countPack) {
        this.countPack = countPack;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append("{Product name = '").append(getName()).append('\'');
        sb.append(", type = ").append(getType());
        sb.append(", countPackets = ").append(getCountPack());
        sb.append(", price (included discount) = ").append(String.format("%.2f",getPrice()));
        sb.append(", quantity = ").append(getQuantity());
        sb.append(", sumPrice = ").append(String.format("%.2f",getSumPrice()));
        sb.append('}');
        return sb.toString();
    }
}

