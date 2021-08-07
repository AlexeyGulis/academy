package by.academy.classwork.lesson8;

import java.util.Iterator;

public class CustomLinkedList<T> implements Iterable<T> {

    private Node<T> head;
    private Node<T> tail;
    private Integer size = 0;

    public void add(T item) {

        Node<T> node = new Node<>();
        node.value = item;

        if (tail == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    public void print() {
        Node<T> value = head;
        while (value != null) {
            System.out.print(value.value + " ");
            value = value.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        list.add(4);
        list.add(55);
        list.add(23);

        list.print();

        list.remove(2);
        list.print();
    }

    public void remove(int index) {
        if (size == 1 && index == 0) {
            head = null;
            tail = null;
            size = 0;
            return;
        }
        if (index == size - 1) {
            Node<T> pref = tail.prev;
            pref.next = null;
            tail = pref;
            size--;
            return;
        }
        if (index >= 0 || index < size) {
            System.out.println("remove");
            int count = 0;
            Node<T> value = head;
            while (value != null) {
                if (count == index) {
                    break;
                }
                value = value.next;
                count++;
            }
            Node<T> pref = value.prev;
            Node<T> next = value.next;
            if (index == 0) {
                head = next;
            }
            if (pref != null) {
                pref.next = next;
            }
            next.prev = pref;
            size--;
            return;
        }
        System.out.println("indexOutBound");
    }

    public void set(int index, T item) {

    }

    public T get(int index) {
        return null;
    }

    @Override
    public InnerIterator<T> iterator() {
        return new InnerIterator<>();
    }

    class InnerIterator<T> implements Iterator<T> {
        Node<T> current = null;

        @Override
        public boolean hasNext() {
            if (current == null) {
                return head != null;
            }
            return current.next != null;
        }

        @Override
        public T next() {
            if (current == null) {
                //current = head;
            }
            return current.next.value;
        }
    }

    class Node<T> {
        Node<T> next;
        Node<T> prev;
        T value;

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("Node{");
            sb.append("next=").append(next);
            sb.append(", pref=").append(prev);
            sb.append(", value=").append(value);
            sb.append('}');
            return sb.toString();
        }
    }
}
