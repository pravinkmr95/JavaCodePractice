package LeetcodeJava;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 1;
        int startIndex = 0;
        for (int i=0; i<s.length(); i++){
            Character ch = s.charAt(i);
            if (map.containsKey(ch) && (startIndex < map.get(ch)+1)){
                startIndex = map.get(ch)+1;
            } else {
                maxLength = Math.max(maxLength, i-startIndex+1);
            }
            map.put(ch, i);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters obj = new LongestSubstringWithoutRepeatingCharacters();
        String s = "abcabcbb";
        System.out.println(obj.lengthOfLongestSubstring(s));

        System.out.println(obj.lengthOfLongestSubstring("bbbbb"));

        System.out.println(obj.lengthOfLongestSubstring("pwwkew"));

        System.out.println(obj.lengthOfLongestSubstring("abcd"));
    }
}
