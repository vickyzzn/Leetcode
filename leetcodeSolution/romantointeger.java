
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

Time: O(n)
 */

package leetcodeSolution;

public class romantointeger {

    public int romantoInt(String s){
        int[] nums = new int[s.length()];
        int sum = 0;
        for(int i = 0; i < s.length(); i++){
            switch (s.charAt(i)){
                case 'I': nums[i] = 1;break;
                case 'V': nums[i] = 5; break;
                case 'X': nums[i] = 10; break;
                case 'L': nums[i] = 50; break;
                case 'C': nums[i] = 100; break;
                case 'D': nums[i] = 500; break;
                case 'M': nums[i] = 1000; break;
            }
        }
        sum = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i - 1]){
                sum = sum + nums[i] - 2*sum;
            }else{
                sum += nums[i];
            }
        }
        return sum;
    }
}
