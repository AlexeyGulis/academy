package by.academy.homework.hmwk4;

import java.util.Arrays;

public class Application<T> {
    T[] items;
    int tos;

    Application() {
        items = (T[]) new Object[16];
        tos = -1;
    }

    Application(int i) {
        this.items = (T[]) new Object[i];
        tos = -1;
    }

    Application(T[] items) {
        this.items = items;
        tos = -1;
    }

    public void add(T obj) {
        if (tos < items.length) {
            items[++tos] = obj;
        } else {
            T[] temp = Arrays.copyOf(items, items.length + items.length / 2);
            items = temp;
            items[++tos] = obj;
        }
    }
    public T get(int i){
        return items[i];
    }
    public T getLast(){
        return items[items.length-1];
    }
    public T getFirst(){
        return items[0];
    }
    public int getSize(){
        return items.length;
    }
    public int lastAddIndex(){
        return tos;
    }
    // флаг добавить на одно удаление
    public void remove(int i){
        if(tos < 0){
            System.out.println("Пустой массив");
        }else{
            T[] temp = (T[]) new Object[items.length-1];
            int index = 0;
            for (int j = 0; j < items.length; j++) {
                if(j != i){
                    temp[index++] = items[j];
                }else if(j<=tos){
                    tos--;
                }
            }
            items = temp;
        }
    }
    // флаг добавить на одно удаление или удалить все элементы
    public void remove(T obj){
        if(tos < 0){
            System.out.println("Пустой массив");
        }else if(obj!=null){
            T[] temp = (T[]) new Object[items.length-1];
            int index = 0;
            for (int j = 0; j < items.length; j++) {
                if(!obj.equals(items[j])){
                    temp[index++] = items[j];
                }else if(j<=tos){
                    tos--;
                }
            }
            items = temp;
        }
    }

}
