package by.academy.deal.annotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface ProductProvider{
    String country() default "Belarus";
    int lifeTime();
    String[] parts();
}