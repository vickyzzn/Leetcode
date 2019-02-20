package solution2019;
/**
 * Given a string s, find the longest palindromic substring in s. 
 * You may assume that the maximum length of s is 1000.
 * Example 1:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * @author vicky
 *
 */
public class LongestPalindrome {
	public String longestPalindrome(String s) {
		if (s == null || s.length() == 0) return null;
		int cur = 0;
		String res = "";
		for (int i = 0; i < s.length(); i++) {
			if (isPalindrome(s, i - cur, i)) {
				res = s.substring(i - cur, i + 1);
				cur++;
			} else if (isPalindrome(s, i - cur - 1, i)) {
				res = s.substring(i - cur - 1, i + 1);
				cur += 2;
			}
		}
		return res;
		
        
    }
	
	private boolean isPalindrome(String s, int start, int end) {
		if (start < 0 || end > s.length() - 1) return false;
		while (start < end) {
			if (s.charAt(start) == s.charAt(end)) {
				start++;
				end--;
			} else {
				return false;
			}
		}
		return true;
	}
}
