package CollectionsPractice;

public class Car1 implements Comparable<Car1> {

    int id;
    String name;

    Car1(int id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public int compareTo(Car1 o) {
        //return this.name.compareTo(o.name); // for string comparison
        return this.id - o.id;
    }

    @Override
    public String toString(){
        return name + "->" + id;
    }
}
