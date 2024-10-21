package GenericClasses;

import java.lang.annotation.Documented;
import java.util.ArrayList;


public class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value){
        this.key = key;
        this.value = value;
    }

    public K getKey(){
        return this.key;
    }

    public V getValue(){
        return this.value;
    }
    @Override
    public String toString(){
        return "(" + this.key + ", " + this.value + ")";
    }

    public static void main(String[] args) {
        ArrayList<Pair<Integer, Integer>> arrayList = new ArrayList<>();
        arrayList.add(new Pair<>(10, 20));
        arrayList.add(new Pair<>(20, 30));
        arrayList.add(new Pair<>(0, 10));
        arrayList.add(new Pair<>(100, 10));
        System.out.println(arrayList);
//        Collections.sort(arrayList, (a, b) -> a.getKey().compareTo(b.getKey()));
//        arrayList.sort((a, b) -> a.getKey().compareTo(b.getKey()));
        arrayList.sort((a, b) -> a.getKey().compareTo(b.getKey()));
        System.out.println(arrayList);
        arrayList.sort((a, b) -> a.getValue().compareTo(b.getValue()));
        System.out.println(arrayList);

        ArrayList<Pair<String, Integer>> stringPairList = new ArrayList<>();
        stringPairList.add(new Pair<>("a", 1));
        stringPairList.add(new Pair<>("c", 3));
        stringPairList.add(new Pair<>("f", 6));
        stringPairList.add(new Pair<>("b", 2));
        System.out.println(stringPairList);
        stringPairList.sort((a, b) -> a.getKey().compareTo(b.getKey()));
        System.out.println(stringPairList);
    }
}
