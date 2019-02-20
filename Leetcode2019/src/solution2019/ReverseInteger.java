package solution2019;


/**
 * Given a 32-bit signed integer, 
 * reverse digits of an integer.
 * Example 1:
 * Input: 123
 * Output: 321
 * @author vicky
 *
 */
public class ReverseInteger {
	public int reverse(int x) {
		int rev = 0;
        while (x != 0) {
            int temp = x % 10;
            x = x / 10;
            int newrev = rev * 10 + temp;
            if ((newrev - temp) / 10 != rev) return 0;
            rev = newrev;
        }
        return rev;
        
    }
}
