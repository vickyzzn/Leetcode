package leetcodeSolution;

import java.util.ArrayList;
import java.util.List;

/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

Time:O(n^min(n, n-k))
Space: O(n)
 */
public class combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if(n <= 0 || k <= 0) return res;
        List<Integer> com = new ArrayList<>();
        helper(n, k, res, com, 1);
        return res;
    }

    public void helper(int n, int k, List<List<Integer>> res, List<Integer> com, int start){
        if(com.size() == k){
            res.add(new ArrayList<>(com));
            return;
        }

        for(int i = start; i <= n; i++){
            com.add(i);
            helper(n, k, res, com, i + 1);
            com.remove(com.size() - 1);
        }
    }

    public static void main(String[] args) {
        combinations res = new combinations();
        System.out.println(res.combine(4,2));
    }
    }
