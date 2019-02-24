package solution2019;

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) return "";
		String res = "";
		for (int i = 0; i < strs[0].length(); i++) {
			char c = strs[0].charAt(i);
			for (int j = 1; j < strs.length; j++) {
				if (i >= strs[j].length() || strs[j].charAt(i) != c) return res;
			}
			res += String.valueOf(c);
		}
		
		return res;
	}
}
