package by.academy.classwork.lesson7;

public class MaxMin<T extends Number> {
    T[] items;

    MaxMin(T[] items){
        this.items = items;
    }

    public T[] getItems() {
        return items;
    }

    public void setItems(T[] items) {
        this.items = items;
    }

    public T minElem(){
        double temp = 0.0;
        boolean t = true;
        int i = 0;
        int indexMin = 0;
        for (T a:items
             ) {
            if(t){
                t=false;
                temp = a.doubleValue();
            }else{
                if(temp>a.doubleValue()){
                    temp = a.doubleValue();
                    indexMin = i;
                }
            }
            i++;
        }
        return items[indexMin];
    }
    public T maxElem(){
        double temp = 0.0;
        boolean t = true;
        int i = 0;
        int indexMax = 0;
        for (T a:items
        ) {
            if(t){
                t=false;
                temp = a.doubleValue();
            }else{
                if(temp<a.doubleValue()){
                    temp = a.doubleValue();
                    indexMax = i;
                }
            }
            i++;
        }
        return items[indexMax];
    }

    public static void main(String[] args) {
        Double[] numbD = {1.0,-22.0,-3.0,4.5,10.66};
        Integer[] numbInt = {1,2,-3,4,-5,6,7,9};
        MaxMin<Double> firstN = new MaxMin<>(numbD);
        MaxMin<Integer> secondN = new MaxMin<>(numbInt);
        System.out.println(firstN.maxElem());
        System.out.println(firstN.minElem());
        System.out.println(secondN.maxElem());
        System.out.println(secondN.minElem());
    }
}
