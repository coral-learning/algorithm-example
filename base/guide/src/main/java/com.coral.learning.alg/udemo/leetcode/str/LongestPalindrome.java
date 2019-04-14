package com.coral.learning.alg.udemo.leetcode.str;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba"也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 * 解答：
 * 回文串就是正着读和反着读一样的字符串
 * ，如“abba”，"abcba"，最长回文子串是字符串的子串中最长的属于回文串的子串。
 * 如字符串"abbaabccba"的最长回文子串为"abccba"，
 * 本文采用动态规划算法来查找最长回文子串，算法时间复杂度为O（n²）
 * 。设状态dp[j][i]表示索引j到索引i的子串是否是回文串。则易得转移方程如下：
 * <p>
 * 为了改进暴力法，我们首先观察如何避免在验证回文时进行不必要的重复计算。考虑 \textrm{“ababa”}“ababa” 这个示例。如果我们已经知道 \textrm{“bab”}“bab” 是回文，那么很明显，\textrm{“ababa”}“ababa” 一定是回文，因为它的左首字母和右尾字母是相同的。
 * <p>
 * 我们给出 P(i,j)P(i,j) 的定义如下：
 * P(i,j)={true,false,如果子串Si…Sj是回文子串其它情况
 * P(i,j)={true,如果子串Si…Sj是回文子串false,其它情况
 * 因此，
 * P(i, j) = ( P(i+1, j-1) \text{ and } S_i == S_j ) P(i,j)=(P(i+1,j−1) and Si==Sj)
 * 基本示例如下：
 * P(i, i) = true P(i,i)=true
 * P(i, i+1) = ( S_i == S_{i+1} ) P(i,i+1)=(Si ==Si+1)
 * 这产生了一个直观的动态规划解法，我们首先初始化一字母和二字母的回文，然后找到所有三字母回文，并依此类推…
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        System.out.println(longestPalindrome.longestPalindrome(""));
        System.out.println(longestPalindrome.longestPalindrome("1"));
        System.out.println(longestPalindrome.longestPalindrome("abcdbbfcba"));
    }

    String longestPalindrome(String s) {
        int n = s.length();
        if (n <= 0) {
            return s;
        }
        boolean dp[][] = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = false;
            }
        }
        int max_len = 1; //保存最长回文子串长度
        int start = 0;  //保存最长回文子串起点
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j <= i; ++j) {
                //i为主索引，j为字串
                if (i - j < 2) {
                    dp[j][i] = (s.charAt(i) == s.charAt(j));
                } else {
                    //j < i - 2
                    dp[j][i] = (s.charAt(i) == s.charAt(j) && dp[j + 1][i - 1]);
                }

                if (dp[j][i] && max_len < (i - j + 1)) {
                    max_len = i - j + 1;
                    start = j;
                }
            }
        }
        return s.substring(start, start + max_len);
    }

    public String longestPalindromeTwo(String s) {
        int index = 0;
        String result = "";
        if(s.length() > 0){
            result = s.charAt(0) + "";
        }

        if(s.length() == 2 && s.charAt(0) == s.charAt(1)){
            return s;
        }
        int i = (s.length() + 1) /2;
        while(i - index > 0){
            result = selectPalindrome(s, result, i - index);
            result = selectPalindrome(s, result, i + index);
            index++;
            if(result.length() > 2 * (i - index) + 1){
                break;
            }
        }
        return result;
    }

    public static String selectPalindrome(String s, String result, int i){
        String tmp = "";
        int index = 1;
        int start = i;
        int end = i;
        if(i >= s.length() - 1){
            return result;
        }
        if(s.charAt(i) == s.charAt(i + 1)){
            end = i + 1;
            while(i - index >= 0 && i + index < s.length() - 1){
                start = i - index;
                end = i + index + 1;
                if(s.charAt(start) == s.charAt(end)){
                    index++;
                }else{
                    index--;
                    start += 1;
                    end -= 1;
                    break;
                }
            }
            if(i - index < 0){
                index--;
            }
            tmp = s.substring(start, end + 1);
        }else if(s.charAt(i) == s.charAt(i - 1)){
            end = i - 1;
            while(i - index >= 0){
                start = i - index;
                end = i + index - 1;
                if(s.charAt(start) == s.charAt(end)){
                    index++;
                }else{
                    index--;
                    start += 1;
                    end -= 1;
                    break;
                }
            }
            if(i - index < 0){
                index--;
            }
            tmp = s.substring(start, end + 1);
        }
        if(tmp.length() > result.length()){
            result = tmp.toString();
        }
        if(i > 0 && s.charAt(i - 1) == s.charAt(i + 1)){
            while(i - index >= 0 && i + index < s.length()){
                start = i - index;
                end = i + index;
                if(s.charAt(i - index) == s.charAt(i + index)){
                    index++;
                }else{
                    index--;
                    start += 1;
                    end -= 1;
                    break;
                }
            }
            if(i - index < 0){
                index--;
            }
            tmp = s.substring(start, end + 1);
        }
        if(tmp.length() > result.length()){
            result = tmp.toString();
        }
        return result;
    }
}
