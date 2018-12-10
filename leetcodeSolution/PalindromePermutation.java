package leetcodeSolution;

import java.util.HashSet;

/*

Given a string, determine if a permutation of the string could form a palindrome.

Example 1:

Input: "code"
Output: false
Example 2:

Input: "aab"
Output: true
Example 3:

Input: "carerac"
Output: true

time: O(n)
space : O(1)
 */
public class PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        if(s == null || s.length() == 0) return false;
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (set.contains(c)) {
                set.remove(c);
            }else{
                set.add(c);
            }
        }
        return set.size() <= 1;
    }
    public boolean canPermutePalindrome2(String s) {
        if(s == null || s.length() == 0) return false;
        int[] count = new int[128];
        for(char c: s.toCharArray()){
            if(count[c]%2 == 0){
                count[c]++;
            }else{
                count[c]--;
            }
        }
        int odd = 0;
        for(int i = 0; i < count.length; i++){
            if(count[i]%2 !=0) odd++;
        }
        return odd <= 1;
    }

    public static void main(String[] args) {
        PalindromePermutation res = new PalindromePermutation();
        String s = "abb";
        System.out.println(res.canPermutePalindrome2(s));
    }


    }
