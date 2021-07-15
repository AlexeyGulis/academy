package by.academy.classwork.lesson4;

public class IndexOf {
    public static void main(String[] args) {
        String str = "Для работы со строками в языке Java используются классы String, StringBuilder, StringBuffer";
        int indexOfnum = str.indexOf("S");;
        while(indexOfnum!=-1){
            System.out.println("Элемент S содержится в массиве под номером "+ indexOfnum);
            indexOfnum=str.indexOf("S",indexOfnum+1);
        }
    }
}
