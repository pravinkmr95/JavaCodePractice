package LeetcodeJava;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0){
            return "";
        }
        String output="";
        String prefix = strs[0];
        for (int i=0; i<prefix.length(); i++){
            char ch = prefix.charAt(i); // this char should be present in the ith position in rest of the strings
            for (int j=1; j<strs.length; j++){
                String otherString = strs[j];
                if (i >= otherString.length() || otherString.charAt(i) != ch){
                    return output;
                }
            }
            output += ch;

        }
        return output;
    }

    public static void main(String[] args){
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix.longestCommonPrefix(strs));

        String[] strs1 = {"dog","racecar","car"};
        System.out.println(longestCommonPrefix.longestCommonPrefix(strs1));

        String[] strs2 = {"ab", "a"};
        System.out.println(longestCommonPrefix.longestCommonPrefix(strs2));
    }

}
