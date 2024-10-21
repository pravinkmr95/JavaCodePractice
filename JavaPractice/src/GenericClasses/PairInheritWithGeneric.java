package GenericClasses;

public class PairInheritWithGeneric<K, V> extends Pair<K, V> {
    public PairInheritWithGeneric(K key, V value){
        super(key, value);
    }
}
