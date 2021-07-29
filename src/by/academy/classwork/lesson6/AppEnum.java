package by.academy.classwork.lesson6;

public class AppEnum {
    public static void main(String[] args) {
        int myF = 3;
        for (TimeYear a: TimeYear.values()
             ) {
            if(a.i==myF){
                System.out.println(a);
            }
        }
        whatIlike(TimeYear.valueOf("Summer"));
        StringBuilder strb = new StringBuilder();
        for (TimeYear a: TimeYear.values()
             ) {
            strb.append("Время года ").append(a).append(", средняя температура ").append(a.temprute);
            System.out.println(strb.toString());
            strb.setLength(0);
        }
    }
    public static void whatIlike(TimeYear a){
        switch(a){
            case Autumn:
                System.out.println("I like " + a);
                break;
            case Spring:
                System.out.println("I like " + a);
                break;
            case Summer:
                System.out.println("I like " + a);
                break;
            case Winter:
                System.out.println("I like " + a);
                break;
            default:
                System.out.println("I like nothing");
        }
    }

}
