package by.academy.classwork.lesson6;

public enum TimeYear {
    Winter(1,5.3),Spring(2, 15.2),Summer(3,24.5){
        public void getDescription(){
            System.out.println("Теплое время года");
        }
    },Autumn(4,13.9);
    int i;
    double temprute;
    TimeYear(int i, double temprute){
        this.i = i;
        this.temprute = temprute;
    }
    public void getDescription(){
        System.out.println("Холодное время года");
    }
}
