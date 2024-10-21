package LeetcodeJava;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        String output="";
        int maxSize=0;
        for (int x=0; x<s.length(); x++){
            int i = x;
            int j = x;
            while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
                if (j-i+1 > maxSize){
                    output = s.substring(i, j+1);
                    maxSize = j-i+1;
                }
                i--;
                j++;

            }

            i = x;
            j = x+1;
            while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
                if (j-i+1 > maxSize){
                    output = s.substring(i, j+1);
                    maxSize = j-i+1;
                }
                i--;
                j++;

            }
        }
        return output;
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
//        System.out.println(longestPalindromicSubstring.longestPalindrome("babad"));
//
//        System.out.println(longestPalindromicSubstring.longestPalindrome("cbbd"));

        System.out.println(longestPalindromicSubstring.longestPalindrome("a"));
    }
}
