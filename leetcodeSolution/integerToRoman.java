/*

Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

 */


package leetcodeSolution;

public class integerToRoman {
    public String intToRome(int num){
        String[] s = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder st = new StringBuilder();
        for(int i = 0; i < nums.length; i++){
            while(num >= nums[i]){
                num -= nums[i];
                st.append(s[i]);
            }
        }

        return st.toString();
    }

}
