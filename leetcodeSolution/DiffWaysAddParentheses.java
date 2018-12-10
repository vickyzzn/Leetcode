package leetcodeSolution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.

Example 1:

Input: "2-1-1"
Output: [0, 2]
Explanation:
((2-1)-1) = 0
(2-(1-1)) = 2


time: O(catalan number)
space: O(n)
 */
public class DiffWaysAddParentheses {
    HashMap<String, List<Integer>> map = new HashMap<>();

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        if(input == null || input.length() == 0) return res;
        if(map.containsKey(input)) return map.get(input);
        for(int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            if(c == '-' || c == '*' || c == '+'){
                String s1 = input.substring(0, i);
                String s2 = input.substring(i + 1);
                List<Integer> p1 = diffWaysToCompute(s1);
                List<Integer> p2 = diffWaysToCompute(s2);
                for(int a : p1){
                    for(int b : p2){
                        if(c == '-'){
                            res.add(a - b);
                        }
                        if(c == '+'){
                            res.add(a + b);
                        }
                        if(c == '*'){
                            res.add(a * b);
                        }
                    }
                }
            }
        }
        if(res.size() == 0) res.add(Integer.valueOf(input));
        map.put(input, res);
        return res;
    }

    public static void main(String[] args) {
        DiffWaysAddParentheses res = new DiffWaysAddParentheses();
        String input = "2*3-4*5";
        System.out.println(res.diffWaysToCompute(input));
    }

    }
