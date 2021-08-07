package by.academy.homework.hmwk4;

import java.util.Iterator;

public class ArrayIterator<T> implements Iterator<T> {
    private int index = 0;
    private int size = 0;
    T[] items;

    ArrayIterator(int size, final T[] items) {
        this.size = size;
        this.items = items;
    }

    public boolean hasNext() {
        if (size == 0) {
            System.out.println("Элементы не найдены");
            return false;
        }
        return index < size;
    }

    @Override
    public T next() {
        return (T) items[index++];
    }
}
