package by.academy.classwork.lesson7;

import javax.accessibility.AccessibleValue;

public class Average<T extends Number> {
    T[] items;
    public Average(T[] items){
        this.items = items;
    }
    public T[] getItems(){
        return items;
    }
    public void setItems(T[] items){
        this.items = items;
    }
    public Double average(){
        double average = 0.0;
        for (Number n : items
             ) {
            average+=n.doubleValue();
        }
        return average/items.length;
    }
    public void compareTo(Average<?> avarageTo){
        double numb = average();
        double numb1 = avarageTo.average();
        if(numb<numb1){
            System.out.println("Меньше");
        }else if(numb>numb1){
            System.out.println("Больше");
        }else {
            System.out.println("Равно");
        }
    }

    public static void main(String[] args) {
        Double[] numb = {1.0,2.0,3.0,4.5,10.66};
        Integer[] numbInt = {1,2,3,4,5,6,7,9};
        Average<Double> averageDoub = new Average<>(numb);
        Average<Double> averageDoub1 = new Average<>(numb);

        Average<Integer> averageInt = new Average<>(numbInt);

        averageDoub.compareTo(averageDoub1);
        averageDoub.compareTo(averageInt);

        System.out.println(averageDoub.average());

        System.out.println(averageInt.average());
    }
}
