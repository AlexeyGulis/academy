package by.academy.classwork.lesson13;

public class Cat {
    public String name;
    private int cost;
    protected String location;

    public Cat(String name,int cost,String location){
        this.name = name;
        this.cost = cost;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }
    @TestReflex(name = "method setCost",type = 1)
    private void setCost(int cost) {
        this.cost = cost;
    }
}
