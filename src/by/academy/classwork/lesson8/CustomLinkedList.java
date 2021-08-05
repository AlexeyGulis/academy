package by.academy.classwork.lesson8;

public class CustomLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private Integer size = 0;

    public void add(T item){

    }

    public void remove(int index){

    }

    public void set(int index,T item){

    }

    public T get(int index){
        return null;
    }

    class Node<T>{
        Node<T> next;
        Node<T> pref;
        T value;

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Node{");
            sb.append("next=").append(next);
            sb.append(", pref=").append(pref);
            sb.append(", value=").append(value);
            sb.append('}');
            return sb.toString();
        }
    }
}
