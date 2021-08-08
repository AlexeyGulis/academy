package by.academy.classwork.lesson8;

import java.util.ArrayList;

class HeavyBox {
    int weight;
    int height;
    int depth;
    int width;

    HeavyBox(int w, int h, int d, int m) {
        width = w;
        height = h;
        depth = d;
        weight = m;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("HeavyBox{");
        sb.append("weight=").append(weight);
        sb.append(", height=").append(height);
        sb.append(", depth=").append(depth);
        sb.append(", width=").append(width);
        sb.append('}');
        return sb.toString();
    }

    public static void main(String[] args) {
        ArrayList<HeavyBox> list = new ArrayList<>();
        list.add(new HeavyBox(1,2,3,4));
        list.add(new HeavyBox(2,3,3,4));
        list.add(new HeavyBox(3,5,3,5));
        list.add(new HeavyBox(1,2,1,1));
        list.forEach((n) -> System.out.println(n));
        System.out.println();
        System.out.println();
        System.out.println();
        list.get(0).setWeight(1);
        list.remove(list.get(list.size()-1));
        list.forEach((n) -> System.out.print(n+ "  "));
    }
}
