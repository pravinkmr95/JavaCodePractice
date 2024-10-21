package Reflections;

public class Bird {
    private int legs;
    private String name;

    private static final String specie="x";

    Bird(int legs, String name){
        this.legs = legs;
        this.name = name;
    }

    public int getLegs(){
        return this.legs;
    }

    public String getName(){
        return this.name + specie;
    }

    @Override
    public String toString() {
        return name + " -> " + legs;
    }
}
