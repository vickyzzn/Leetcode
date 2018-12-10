package leetcodeSolution;

import java.util.ArrayList;
import java.util.List;

/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

Example:

Input: "aab"
Output:
[
  ["aa","b"],
  ["a","a","b"]
]
time: O(n*2^n)
space: O(n)
 */
public class PalindromePartitiom {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> com = new ArrayList<>();
        if(s == null || s.length() == 0) return res;
        helper(s, res, com, 0);
        return res;
    }

    public void helper(String s, List<List<String>> res, List<String> com, int start){
        if(com.size() > 0 && start >= s.length()){
            res.add(new ArrayList<>(com));
            return;
        }

        for(int i = start; i < s.length(); i++){
            if(isPalindrome(s, i, start)) {
                if (i == start) {
                    com.add(Character.toString(s.charAt(i)));
                } else {
                    com.add(s.substring(start, i + 1));
                }
                helper(s, res, com, i+1);
                com.remove(com.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s, int i, int j){
        if(i == j) return true;
        while(j < i){
            if(s.charAt(j) != s.charAt(i)) return false;
            i--;
            j++;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitiom res = new PalindromePartitiom();
        String s = "abb";
        System.out.println(res.partition(s));
    }
    }
