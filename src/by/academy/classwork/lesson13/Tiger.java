package by.academy.classwork.lesson13;

public class Tiger extends Cat{
    private int age;
    @TestReflex(name = "type String",type = 123)
    public String type;

    public Tiger(String name,int cost,String location,int age,String type){
        super(name,cost,location);
        this.age = age;
        this.type = type;
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
