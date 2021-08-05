package by.academy.classwork.lesson8;

public class ArrayListCustom<T> {
    private T[] items;
    private int size;
    public ArrayListCustom(){
        super();
        items = (T[]) new Object[10];
    }
    public ArrayListCustom(int initCap){
        super();
        items = (T[]) new Object[initCap];
    }
    public ArrayListCustom(T[] items){
        super();
        this.items = items;
    }
    private void growth() {
        T[] temp = (T[]) new Object[2*items.length+1];
        System.arraycopy(items,0,temp,0,items.length);
        items = temp;
    }
    public void add(T item){
        if(size>=items.length){
            growth();
        }
        items[size++]=item;
    }
    public void remove(int index){
        if(index >= size || index < 0){
            return;
        }
        if(index>=size){

        }

    }
    public void set(int index,T item){

    }
    public T get(int index){
        return items[index];
    }
}
