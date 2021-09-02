package by.academy.classwork.lesson13;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface TestReflex {
    public String name();
    public int type();
}
