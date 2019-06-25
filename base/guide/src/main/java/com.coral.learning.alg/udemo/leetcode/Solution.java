package com.coral.learning.alg.udemo.leetcode;

class Solution {
    public static void main(String[] args) {
        Solution rem = new Solution();
        System.out.println(rem.isMatch("abab", ""));
        System.out.println(rem.isMatch("abb", "ab*"));
    }
    public boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty()) return text.isEmpty();
        boolean first_match = (!text.isEmpty() &&
                               (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
            return (isMatch(text, pattern.substring(2)) ||
                    (first_match && isMatch(text.substring(1), pattern)));
        } else {
            return first_match && isMatch(text.substring(1), pattern.substring(1));
        }
    }
}
