package MultiThreading;

import java.util.ArrayList;
import java.util.List;

public class Pair<T, R> {
    private T key;
    private R value;
    Pair(T key, R value){
        this.key = key;
        this.value = value;
    }

    T getKey(){
        return this.key;
    }

    R getValue(){
        return this.value;
    }

    @Override
    public String toString(){
        return "(" + this.key + ", " + this.value + ")";
    }

    public static void main(String[] args) {
        Pair<String, Integer> pair = new Pair<>("1", 1);
        System.out.println(pair);
        List<Pair<String, Integer>> arrayList = new ArrayList<>();
        arrayList.add(pair);
        arrayList.add(new Pair<>("2", 2));
        arrayList.add(new Pair<>("3", 3));
        System.out.println(arrayList);
    }
}
