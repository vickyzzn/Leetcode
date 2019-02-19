package solution2019;
/**
 * Given a string, 
 * find the length of the longest substring without repeating characters.
 * Example 1:
 * Input: "abcabcbb"
 * Output: 3 
 * Explanation: The answer is "abc", with the length of 3. 
 * @author vicky
 *
 */
public class LongestSubstring {
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) return 0;
		int[] dict = new int[128];
		int c = 0;
		int l = 0;
		int j = 0;
		while (j < s.length()) {
			if (dict[s.charAt(j)] == 0) {
				dict[s.charAt(j)]++;
				j++;
			} else {
				c = Math.max(c,  j - l);
				while (dict[s.charAt(j)] > 0) {
					dict[s.charAt(l)]--;
					l++;
				}
			}
		}
		return Math.max(c, j - l);
        
    }
}
