package leetcodeSolution;
/*
Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false

Space: O(n)
Time: O(n)
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        if(s == null && t == null || s.length() == 0 && t.length() == 0) return true;
        int[] count = new int[128];
        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i)]++;
        }
        for(int i = 0; i < t.length(); i++){
            if(count[t.charAt(i)] > 0) count[t.charAt(i)]--;
        }
        for(int i = 0; i < s.length(); i++){
            if(count[s.charAt(i)] != 0) return false;
        }

        return true;
    }

    }
