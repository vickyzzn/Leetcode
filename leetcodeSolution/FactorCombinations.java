package leetcodeSolution;

import java.util.ArrayList;
import java.util.List;

/*
Numbers can be regarded as product of its factors. For example,

8 = 2 x 2 x 2;
  = 2 x 4.
Write a function that takes an integer n and return all possible combinations of its factors.

Note:

You may assume that n is always positive.
Factors should be greater than 1 and less than n.

time: O(nlogn)
space: O(n)
 */
public class FactorCombinations {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> com = new ArrayList<>();
        if(n <= 1) return res;
        helper(res, com, n, 2);
        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> com, int n, int start){
        if(n == 1){
            if(com.size() > 1) res.add(new ArrayList<>(com));
            return;
        }
        for(int i = start; i < n; i++){
            if(n % i == 0) {
                com.add(i);
                helper(res, com, n/i, i+1);
                com.remove(com.size() - 1);
            }

        }
    }
    }
