import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[5];
        int max = 105, min=100;
        for (int i = 0; i < 5; i++) {
            int x = min + (int) (Math.random() * (max - min + 1));
            arr[i] = x;
        }
        System.out.println(Arrays.toString(arr));
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.forEach((k, v) -> System.out.println(k + "->" + v));
        int a = 10;
        String x = String.valueOf(a);
        int y = Integer.parseInt(x);
        System.out.println(a==y);
        ArrayList<String> al = new ArrayList<>();
        System.out.println(al.clone());
        int z=10;
        Object obj = z;
        System.out.println(obj.getClass());
    }
}