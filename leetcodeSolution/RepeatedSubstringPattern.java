package leetcode;
/*
 * Input: "aba" Output: True
 */

public class RepeatedSubstringPattern {
	boolean repeated(String str) {
		if (str == null || str.length() == 0) return false;
		int l = str.length();
		for (int i = l/2; i >= 1; i--) {
			if (l % i == 0) {
				int m = l/i;
				String sub = str.substring(0, i);
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < m; j++) {
					sb.append(sub);
				}
				if (sb.toString().equals(str)) return true;
			}
		}
		
		return false;
	}
	
	public static void main (String[] args) {
		RepeatedSubstringPattern r = new RepeatedSubstringPattern();
		String s = "abcabcabcabc";
		System.out.println(r.repeated(s));
	}
}
