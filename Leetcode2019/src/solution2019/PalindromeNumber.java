package solution2019;
/**
 * Determine whether an integer is a palindrome. 
 * An integer is a palindrome when it reads the same backward as forward.
 * Example 1:
 * Input: 121
 * Output: true
 * @author vicky
 *
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
    	if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int y = 0;
        while (y < x) {
        	y = x % 10 + y * 10;
        	x = x / 10;
        }
		return y == x || x == y / 10;
    }
}
