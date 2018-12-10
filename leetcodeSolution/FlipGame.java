package leetcodeSolution;

import java.util.ArrayList;
import java.util.List;

/*
Input: s = "++++"
Output:
[
  "--++",
  "+--+",
  "++--"
]

 */
public class FlipGame {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<>();
        if(s == null || s.length() == 0) return res;
        for(int i = 0; i < s.length() - 1; i++){
            if(s.charAt(i) == '+' && s.charAt(i + 1) == '+'){
                res.add(s.substring(0, i) + "--" + s.substring(i + 2));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FlipGame res = new FlipGame();
        String s = "++++";
        System.out.println(res.generatePossibleNextMoves(s));
    }
    }
