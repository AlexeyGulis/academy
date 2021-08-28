package by.academy.classwork.lesson11;

public class Task10<T> {
    interface FuncTest<T>{
        boolean func(T v1, T v2);
    }
    public int hTemp;
    Task10(int i){
        hTemp = i;
    }
    boolean sameH(Task10 ex){
        return hTemp == ex.hTemp;
    }
    static <T> int counter(T[] val,FuncTest<T> test,T val1){
        int count = 0;
        for (int i = 0; i < val.length; i++) {
            if(test.func(val[i],val1)){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Task10[] eee = {new Task10(10),new Task10(10),new Task10(10),new Task10(10)};
        System.out.println(counter(eee,Task10::sameH,new Task10(11)));
    }
}
