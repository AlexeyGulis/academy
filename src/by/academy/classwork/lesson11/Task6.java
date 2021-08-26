package by.academy.classwork.lesson11;

import java.util.function.Consumer;

class HeavyBox {
    int h;
    int w;
    int l;

    HeavyBox(int h, int w, int l) {
        this.h = h;
        this.w = w;
        this.l = l;
    }

    public int getH() {
        return h;
    }
}

public class Task6 {
    public static void main(String[] args) {
        Consumer<HeavyBox> lyamda = heavyBox -> System.out.println("Отгрузили ящик весом " + heavyBox.getH());
        Consumer<HeavyBox> lyamda1 = heavyBox -> System.out.println("Отправляем ящик весом " + heavyBox.getH());
        lyamda.andThen(lyamda1).accept(new HeavyBox(1,2,3));

    }
}
