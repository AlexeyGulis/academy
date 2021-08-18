package by.academy.homework.hmwk5.task3;

import java.util.Iterator;

public class TwoDimArrayIterator<T> implements Iterator<T> {
    private int elements = 0;
    private int count = 0;
    private int columnIndex = 0;
    private int lineIndex = 0;
    private int line = 0;
    T[][] items;

    public TwoDimArrayIterator(T[][] items) {
        this.line = items.length;
        this.items = items;
        getCountElements();
    }

    private void getCountElements() {
        for (T[] lineArr : items
        ) {
            elements += lineArr.length;
        }
    }

    public boolean hasNext() {
        if (line == 0 && elements == 0) {
            System.out.println("Элементы не найдены");
            return false;
        }
        if (lineIndex < line - 1) {
            if (columnIndex == items[lineIndex].length) {
                if (count < elements) {
                    while (items[lineIndex + 1].length == 0) {
                        lineIndex++;
                    }
                    columnIndex = 0;
                } else {
                    return false;
                }
            }
            return true;
        } else if (lineIndex == line - 1 && columnIndex < items[lineIndex].length) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public T next() {
        count++;
        return (T) items[lineIndex][columnIndex++];
    }
}