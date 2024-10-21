package Reflections;

import java.lang.reflect.Array;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws ClassNotFoundException {
        Class className = Class.forName("Reflections.Bird");
        Class className1 = Bird.class;
        Bird bird = new Bird(2, "Eagle");
        System.out.println(bird);
        Class className2 = bird.getClass();
        System.out.println(className1.getName());
        System.out.println(Modifier.toString(className.getModifiers()));
        System.out.println(className1.getConstructors().length);
    }
}
