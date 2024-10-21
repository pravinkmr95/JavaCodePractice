import java.util.Arrays;

public class LongestUniformSubstring {
    public int[] findLongestUniformSubstring(String str){
        int startIndex = 0;
        int maxLen = 1;
        int currLen = 1;
        for (int i=1; i < str.length(); i++){
            if (str.charAt(i) == str.charAt(i-1)){
                currLen++;
            } else {
                if (currLen > maxLen){
                    maxLen = currLen;
                    startIndex = i - currLen;
                }
                currLen = 1;
            }
        }
        if (currLen > maxLen){
            maxLen = currLen;
            startIndex = str.length() - currLen;
        }
        // System.out.println("maxLen==" + maxLen + " " + startIndex);
        return new int[]{startIndex, maxLen};
    }
    public static void main(String[] args) {
        String s = "10000111"; //output = [1, 4]
        String s1 = "aabbbbbCdAA"; // output = [2, 5]
        String s2 = "abcd"; // output = [0, 1]
        String s3 = "aaaaa"; // output = [0, 5]
        String s4 = "1000011111"; //output = [5, 5]
        LongestUniformSubstring obj = new LongestUniformSubstring();
        System.out.println(s + " ==> " + Arrays.toString(obj.findLongestUniformSubstring(s)));
        System.out.println(s1 + " ==> " + Arrays.toString(obj.findLongestUniformSubstring(s1)));
        System.out.println(s2 + " ==> " + Arrays.toString(obj.findLongestUniformSubstring(s2)));
        System.out.println(s3 + " ==> " + Arrays.toString(obj.findLongestUniformSubstring(s3)));
        System.out.println(s4 + " ==> " + Arrays.toString(obj.findLongestUniformSubstring(s4)));
    }
}
