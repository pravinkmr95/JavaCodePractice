package LeetcodeJava;

import java.util.Arrays;

public class ValidAnagram {
    public boolean isAnagramSorted(String s, String t){
        char[] charsS = s.toCharArray();
        Arrays.sort(charsS);
        s = new String(charsS);

        char[] charT = t.toCharArray();
        Arrays.sort(charT);
        t = new String(charT);
        return s.equals(t);
    }
    public boolean isAnagram(String s, String t) {
        if (s.isEmpty() && t.isEmpty()){
            return true;
        }
        int[] arrS = new int[26];
        if (s.length() != t.length()){
            return false;
        }
        for (int i=0; i<s.length(); i++){
            arrS[s.charAt(i) - 'a']++;
        }
        for (int i=0; i<t.length(); i++){
            arrS[t.charAt(i) - 'a']--;
        }
        for (int count: arrS){
            if (count !=0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        ValidAnagram validAnagram = new ValidAnagram();
        System.out.println(validAnagram.isAnagram("anagram", "nagaram"));

        System.out.println(validAnagram.isAnagram("rat","car"));

        System.out.println(validAnagram.isAnagramSorted("anagram", "nagaram"));

        System.out.println(validAnagram.isAnagramSorted("rat","car"));

    }
}
