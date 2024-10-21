package LeetcodeJava;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakProblem {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        //StringBuilder sb = new StringBuilder(s);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i=1; i<s.length()+1; i++){
            for (int j=0; j<i; j++){
                if (set.contains(s.substring(j, i)) && dp[j]){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        WordBreakProblem wordBreakProblem = new WordBreakProblem();
        System.out.println(wordBreakProblem.wordBreak(s, wordDict));

        String s1 = "applepenapple";
        List<String> wordDict1 = Arrays.asList("apple", "pen");
        System.out.println(wordBreakProblem.wordBreak(s1, wordDict1));

        String s2 = "catsandog";
        List<String> wordDict2 = Arrays.asList("cats","dog","sand","and","cat");
        System.out.println(wordBreakProblem.wordBreak(s2, wordDict2));

    }
}
