package LeetcodeJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> output = new ArrayList<>();
        HashMap<String, List<String>> stringListHashMap = new HashMap<>();
        for (String str: strs){
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String sortedString = new String(charArr);
            if (stringListHashMap.containsKey(sortedString)){
                stringListHashMap.get(sortedString).add(str);
            } else {
                List<String> arrayList = new ArrayList<>();
                arrayList.add(str);
                stringListHashMap.put(sortedString, arrayList);
            }
        }
        stringListHashMap.forEach((k, v) -> output.add(v));
        return output;
    }
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        GroupAnagram groupAnagram = new GroupAnagram();
        System.out.println(groupAnagram.groupAnagrams(strs));
    }
}
