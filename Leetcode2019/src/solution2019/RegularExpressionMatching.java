package solution2019;
/**
 * Given an input string (s) and a pattern (p), 
 * implement regular expression matching with support for '.' and '*'.
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * Note:
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like . or *.
 * Example 1:
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * @author vicky
 *
 */
public class RegularExpressionMatching {
	public boolean isMatch(String s, String p) {
		if (p.isEmpty()) return s.isEmpty();
		boolean firstMatch = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
		if (p.length() >= 2 && p.charAt(1) == '*') {
			return (firstMatch && isMatch(s.substring(1), p)) || isMatch(s, p.substring(2));
		} else {
			return firstMatch && isMatch(s.substring(1), p.substring(1));
		}
		
    }
	
	public static void main (String[] args) {
		String s = "a";
		String p = ".*..a*";
		RegularExpressionMatching r = new RegularExpressionMatching();
		System.out.println(r.isMatch(s, p));
	}
}
