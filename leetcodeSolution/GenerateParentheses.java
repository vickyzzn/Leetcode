

/*
time: O(2^n)
space: O(

 */
package leetcodeSolution;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParentheses(int n){

        List<String> res = new ArrayList<>();
        if(n == 0) return res;
        helper(res, "" , n, n);
        return res;
    }

    private void helper(List<String> res, String str, int left, int right){
        if(left > right) return;
        if(left == 0 && right == 0){
            res.add(str);
            return;
        }

        if(left > 0){
            helper(res, str + "(", left - 1, right);
        }
        if(right > 0){
            helper(res,str + ")", left, right - 1 );
        }

    }


}
