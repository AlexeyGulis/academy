package by.academy.deal;

public class Chips extends Product {
    protected String nameDis = "Лейс";
    protected String tasteDis = "С сыром";
    protected String name;
    protected String taste;
    protected double discount = 0.05;


    public Chips(String name, double price, int quantity, String nameChips, String taste) {
        super(name, price, quantity);
        this.name = nameChips;
        this.taste = taste;
    }

    protected double getDiscount() {
        double result = 0.0;
        if (nameDis.equals(name) && tasteDis.equals(taste)) {
            result = discount;
        }
        return result;
    }

    public String[] getFeature() {
        String[] prodFeature = new String[2];
        prodFeature[0] = name;
        prodFeature[1] = taste;
        return prodFeature;
    }

    public String getNameChips() {
        return name;
    }

    public void setNameChips(String name) {
        this.name = name;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append("{Имя продукта = '").append(getName()).append('\'');
        sb.append(", Название чипсов = ").append(getNameChips());
        sb.append(", Вкус чипсов = ").append(getTaste());
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

        Chips chips = (Chips) o;

        if (Double.compare(chips.discount, discount) != 0) return false;
        if (nameDis != null ? !nameDis.equals(chips.nameDis) : chips.nameDis != null) return false;
        if (tasteDis != null ? !tasteDis.equals(chips.tasteDis) : chips.tasteDis != null) return false;
        if (name != null ? !name.equals(chips.name) : chips.name != null) return false;
        return taste != null ? taste.equals(chips.taste) : chips.taste == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = nameDis != null ? nameDis.hashCode() : 0;
        result = 31 * result + (tasteDis != null ? tasteDis.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (taste != null ? taste.hashCode() : 0);
        temp = Double.doubleToLongBits(discount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
