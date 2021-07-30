package by.academy.homework.hmwk3;

public class Tea extends Product {
    protected static String typeDis = "Черный";
    protected static int countPackDis = 20;
    protected int countPack;
    protected String type;
    protected double discount = 0.25;


    public Tea(String name, double price, int quantity, int countPack, String type) {
        super(name, price, quantity);
        this.countPack = countPack;
        this.type = type;
    }

    public String[] getFeature() {
        String[] prodFeature = new String[2];
        prodFeature[0] = type;
        prodFeature[1] = String.valueOf(countPack);
        return prodFeature;
    }

    protected double getDiscount() {
        double result = 0.0;
        if (countPack >= countPackDis && typeDis.equals(type)) {
            result = discount;
        }
        return result;
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
        sb.append("{Имя продукта = '").append(getName()).append('\'');
        sb.append(", Тип чая = ").append(getType());
        sb.append(", Количество пакетиков = ").append(getCountPack());
        sb.append(", Цена (включая скидку) = ").append(String.format("%.2f", getPrice()));
        sb.append(", Количество = ").append(getQuantity());
        sb.append(", Общая цена = ").append(String.format("%.2f", getSumPrice()));
        sb.append('}');
        return sb.toString();
    }
}

