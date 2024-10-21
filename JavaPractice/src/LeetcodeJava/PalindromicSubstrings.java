package LeetcodeJava;

public class PalindromicSubstrings {
    public int countSubstrings(String s){
        int count=0;
        for (int x=0; x<s.length(); x++){
            int i = x;
            int j = x;
            while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
                count++;
                i--;
                j++;
            }

            i = x;
            j = x+1;
            while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
                count++;
                i--;
                j++;

            }
        }
        return count;
    }

    public static void main(String[] args) {
        PalindromicSubstrings palindromicSubstrings = new PalindromicSubstrings();
        System.out.println(palindromicSubstrings.countSubstrings("abc"));

        System.out.println(palindromicSubstrings.countSubstrings("aaa"));
    }
}
