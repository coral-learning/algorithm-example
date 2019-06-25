package com.coral.learning.alg.udemo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 方法 1：回溯
 想法

 如果没有星号（正则表达式中的 * ），问题会很简单——我们只需要从左到右检查匹配串 s 是否能匹配模式串 p 的每一个字符。

 当模式串中有星号时，我们需要检查匹配串 s 中的不同后缀，以判断它们是否能匹配模式串剩余的部分。一个直观的解法就是用回溯的方法来体现这种关系。

 如果模式串中有星号，它会出现在第二个位置，即 \text{pattern[1]}pattern[1] 。这种情况下，我们可以直接忽略模式串中这一部分，或者删除匹配串的第一个字符，前提是它能够匹配模式串当前位置字符，即 \text{pattern[0]}pattern[0] 。如果两种操作中有任何一种使得剩下的字符串能匹配，那么初始时，匹配串和模式串就可以被匹配。


 */
public class RegularExpressionMatching {
    public static void main(String[] args) {
        RegularExpressionMatching rem = new RegularExpressionMatching();
        System.out.println(rem.isMatch("abab", ""));
        rem.isMatch("abab", "");
    }
    public boolean isMatch(String s, String p) {
        if (s == null && p == null){
            return true;
        }
        if (p.contains("*")){
            //针对有*
            int index[] = getIndex(p, '*');
            for (int i = 0 ; i < index.length; i++) {

            }
        }else {
            //针对没有*
            if (s.length() == p.length()){
                for (int i = 0 ; i < s.length(); i++) {
                    if (s.charAt(i) == p.charAt(i) || p.charAt(i) == '.'){

                    } else {
                        return false;
                    }
                }
            } else {
                return false;
            }
        }
        return false;
    }
//    public boolean mathRange(int start, int end, );
    public int[] getIndex(String s, char p){
        List<Integer> indexP = new ArrayList<>();
        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) == p){
                indexP.add(i);
            }
        }
        int[] match = new int[indexP.size()];
        for (int i = 0; i < indexP.size(); i++){
            match[i] = indexP.get(i);
        }

        return match;
    }
}
