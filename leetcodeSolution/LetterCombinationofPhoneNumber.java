/*
Given a string containing digits from 2-9 inclusive,
return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

Note that 1 does not map to any letters.

Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

 */

package leetcodeSolution;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationofPhoneNumber {
    public List<String> lettercombinations(String digits){
        List<String> res = new ArrayList<>();
        String[] letter = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        char[] combine = new char[digits.length()];
        combine(digits, letter, res, combine, 0);
        return res;
    }

    private void combine(String digits, String[] letter, List<String> res, char[] combine, int start){
        if(start == digits.length()){
            if(start > 0){
                res.add(new String(combine));
            }
            return;
        }
        String s = letter[digits.charAt(start) - '0'];
        for(int i = 0; i < s.length(); i++){
            combine[start] = s.charAt(i);
            combine(digits, letter, res, combine,  start + 1);
        }
    }
}
