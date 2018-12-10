package leetcodeSolution;

import java.util.ArrayList;
import java.util.List;

/*
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Note:

All numbers will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Example 2:

Input: k = 3, n = 9
Output: [[1,2,6], [1,3,5], [2,3,4]]

time: O(2^n) -> n = 9 -> O(1)
space: O(n)
 */
public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if(k <= 0 || n <= 0) return res;
        List<Integer> com = new ArrayList<>();
        helper(k, n, res, com, 1);
        return res;
    }

    public void helper(int k, int n, List<List<Integer>> res, List<Integer> com, int start){
        if(com.size() == k){
            if(n == 0) res.add(new ArrayList<>(com));
            return;
        }

        for(int i = start; i <= 9; i++){
            com.add(i);
            helper(k, n - i, res, com, i + 1);
            com.remove(com.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSumIII res = new CombinationSumIII();
        int k = 3;
        int n = 9;
        System.out.println(res.combinationSum3(k, n));
    }
    }
