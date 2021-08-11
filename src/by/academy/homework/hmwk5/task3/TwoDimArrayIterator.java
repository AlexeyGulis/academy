package by.academy.homework.hmwk5.task3;

import java.util.Iterator;

public class TwoDimArrayIterator<T> implements Iterator<T> {
    private int elements = 0;
    private int count = 0;
    private int columnIndex = 0;
    private int lineIndex = 0;
    private int line = 0;
    private int column = 0;
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
        if (column == 0 && line == 0) {
            System.out.println("Элементы не найдены");
            return false;
        }
        if (lineIndex < line - 1) {
            column = items[lineIndex].length;
            if (columnIndex == column) {
                columnIndex = 0;
                int i = 1;
                if (count < elements) {
                    while (items[lineIndex + i].length == 0) {
                        i++;
                    }
                    lineIndex += i;
                } else {
                    return false;
                }
            }
            return true;
        } else if (lineIndex == line - 1) {
            column = items[lineIndex].length;
            if (columnIndex < column) {
                return true;
            } else {
                return false;
            }
        }else {
            return false;
        }
    }

    @Override
    public T next() {
        count++;
        return (T) items[lineIndex][columnIndex++];
    }
}