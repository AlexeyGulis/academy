package by.academy.deal;

public class Tea extends Product {
    protected String typeDis = "Черный";
    protected int countPackDis = 20;
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

    public String getTypeDis() {
        return typeDis;
    }

    public void setTypeDis(String typeDis) {
        this.typeDis = typeDis;
    }

    public int getCountPackDis() {
        return countPackDis;
    }

    public void setCountPackDis(int countPackDis) {
        this.countPackDis = countPackDis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tea tea = (Tea) o;

        if (countPackDis != tea.countPackDis) return false;
        if (countPack != tea.countPack) return false;
        if (Double.compare(tea.discount, discount) != 0) return false;
        if (typeDis != null ? !typeDis.equals(tea.typeDis) : tea.typeDis != null) return false;
        return type != null ? type.equals(tea.type) : tea.type == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = typeDis != null ? typeDis.hashCode() : 0;
        result = 31 * result + countPackDis;
        result = 31 * result + countPack;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        temp = Double.doubleToLongBits(discount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
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

