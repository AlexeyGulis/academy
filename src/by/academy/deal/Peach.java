package by.academy.deal;

import by.academy.deal.annotations.ProductProvider;

@ProductProvider(country = "China",lifeTime = 15,parts = {"ящик","пакет"})
public class Peach extends Product {
    protected double ageDis = 5.0;
    protected String typeDis = "Кардинал";
    protected String type;
    protected double age;
    protected double discount = 0.15;

    public Peach(String name, double price, int quantity, double age, String type) {
        super(name, price, quantity);
        this.type = type;
        this.age = age;
    }

    protected double getDiscount() {
        double result = 0.0;
        if (age >= ageDis && typeDis.equals(type)) {
            result = discount;
        }
        return result;
    }

    public String[] getFeature() {
        String[] prodFeature = new String[2];
        prodFeature[0] = type;
        prodFeature[1] = String.valueOf(age);
        return prodFeature;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public double getAgeDis() {
        return ageDis;
    }

    public void setAgeDis(double ageDis) {
        this.ageDis = ageDis;
    }

    public String getTypeDis() {
        return typeDis;
    }

    public void setTypeDis(String typeDis) {
        this.typeDis = typeDis;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append("{Имя продукта = '").append(getName()).append('\'');
        sb.append(", Тип персика = ").append(getType());
        sb.append(", Возраст = ").append(getAge());
        sb.append(", Цена (включая скидку) = ").append(String.format("%.2f", getPrice()));
        sb.append(", Количество = ").append(getQuantity());
        sb.append(", Общая цена = ").append(String.format("%.2f", getSumPrice()));
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Peach peach = (Peach) o;

        if (Double.compare(peach.age, age) != 0) return false;
        if (Double.compare(peach.discount, discount) != 0) return false;
        return type != null ? type.equals(peach.type) : peach.type == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = type != null ? type.hashCode() : 0;
        temp = Double.doubleToLongBits(age);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(discount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
