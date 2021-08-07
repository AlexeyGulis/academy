package by.academy.homework.hmwk4;

public class Iterator<T> implements java.util.Iterator<T> {
    T[] items;
    T nextItem;
    T previosItem;

    public boolean hasNext(){
        return false;
    }

    @Override
    public T next() {
        return null;
    }

    boolean hasPrevios(){
        return false;
    }

    void add(){
    }

    public void remove(){
    }
}
