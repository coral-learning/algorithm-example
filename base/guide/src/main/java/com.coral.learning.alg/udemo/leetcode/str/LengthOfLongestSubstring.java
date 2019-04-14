package com.coral.learning.alg.udemo.leetcode.str;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abab"));
    }
    public static int lengthOfLongestSubstring(String s) {

        if (s.length() < 2){
            return s.length();
        }
        int index = 0;
        int length = 1;
        int curlength = 0;
        StringBuilder stringBuilder = new StringBuilder();

        char pre = '.';
        for (int i = 0; i < s.length(); i++){
            char tmp = s.charAt(i);
            stringBuilder.append(tmp);
            if (pre ==  s.charAt(i)){
                curlength = 1;
                index = i;
                stringBuilder = new StringBuilder();
                stringBuilder.append(tmp);
            } else {
                if (stringBuilder.toString().length() > 1 && (s.lastIndexOf(stringBuilder.toString()) != index ||s.indexOf(stringBuilder.toString()) != index)){
                    curlength = 0;
                    index = i + 1;
                    stringBuilder = new StringBuilder();
                } else {
                    curlength++;
                    length = curlength;
                }
            }
            pre = s.charAt(i);
        }

        return length;
    }
}
