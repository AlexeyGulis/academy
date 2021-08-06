package by.academy.homework.hmwk4;

import java.util.Arrays;

public class Application<T> {
    private T[] items;
    private int size = 0;

    public Application() {
        items = (T[]) new Object[16];
    }

    public Application(int size) {
        this.items = (T[]) new Object[size];

    }

    public Application(T[] items) {
        this.items = items;
    }

    public void add(T item) {
        if (size >= items.length) {
            growth();
        }
        items[size++] = item;
    }

    public T getLast() {
        return items[size - 1];
    }

    public T getFirst() {
        return items[0];
    }

    public int getSize() {
        return items.length;
    }

    public int lastAddIndex() {
        return size-1;
    }

    private void growth() {
        T[] temp = (T[]) new Object[2 * items.length + 1];
        System.arraycopy(items, 0, temp, 0, items.length);
        items = temp;
    }

    public void remove(int index) {
        if (index >= size || index < 0) {
            System.out.println("Попытка удаления пустого элемента");
            return;
        }

        if (index < size) {
            System.arraycopy(items, index + 1, items, index, size - index - 1);
        }
        items[--size] = null;
    }

    public void set(int index, T item) {
        if (index >= items.length || index < 0) {
            System.out.println(index + " indexOutBoundOfArray");
            return;
        }
        if (index >= size) {
            items[size++] = item;
        } else {
            items[index] = item;
        }
    }

    public T get(int index) {
        if (index >= size || index < 0) {
            System.out.println("Выход за предел массива");
            return null;
        } else {
            return items[index];
        }
    }

    public T[] getItems() {
        return items;
    }

    // флаг добавить на одно удаление или удалить все элементы
    public void remove(T obj) {
        if (obj != null) {
            int index = 0;
            for (T item : items
            ) {
                if (obj.equals(item)) {
                    remove(index);
                }
                index++;
            }
        }
    }

}
