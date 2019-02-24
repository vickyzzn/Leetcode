package solution2019;
/**
 * Implement atoi which converts a string to an integer.
 * The function first discards as many whitespace characters as necessary 
 * until the first non-whitespace character is found. 
 * Then, starting from this character, takes an optional initial plus or minus sign 
 * followed by as many numerical digits as possible, and interprets them as a numerical value.
 * The string can contain additional characters after those that form the integral number, 
 * which are ignored and have no effect on the behavior of this function.
 * If the first sequence of non-whitespace characters in str is 
 * not a valid integral number, or if no such sequence exists because 
 * either str is empty or it contains only whitespace characters, no conversion is performed.
 * If no valid conversion could be performed, a zero value is returned.
 * @author vicky
 *
 */
public class StringtoInteger {
	public int myAtoi(String str) {
//		if (str == null || str.length() == 0) return 0;
//		int i = 0;
//		// no trailing whitespace
//		while (i < str.length()) {
//			if (str.charAt(i) != ' ') {
//				break;
//			} else {
//				i++;
//			}
//		}
//        if (i == str.length()) return 0;
//		if (!Character.isDigit(str.charAt(i)) && (str.charAt(i) != '-' && str.charAt(i) != '+')) return 0;
//		int j = i + 1;
//		char c = str.charAt(i);
//		for (j = i + 1; j < str.length(); j++) {
//			if (!Character.isDigit(str.charAt(j))) break;
//		}
//		String res = str.substring(i, j);
//        if (res.length() == 1) {
//			if (res.startsWith("-") || res.startsWith("+")) return 0;
//		}
//		try {
//            int result = Integer.parseInt(res);
//            return result;
//        } catch (NumberFormatException e) {
//            if (c == '-') return Integer.MIN_VALUE;
//            return Integer.MAX_VALUE;
//        }
		
		if (str == null || str.length() == 0) return 0;
        String s = str.trim();
        if (s.length() == 0) return 0;
        char c = s.charAt(0);
        if (!Character.isDigit(c) && (c != '-' && c != '+')) return 0;
        int sign = 1;
        if (c == '-') sign = -1;
        int res = 0;
        int i = 0;
        if (!Character.isDigit(c)) i++;
        while (i < s.length()) {
            if (!Character.isDigit(s.charAt(i))) break;
            int t = Integer.valueOf(s.charAt(i) - '0');
            if (sign == 1 && res * 10 + t >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign == -1 && res * 10 + t <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
            res = res * 10 + t;
            i++;
        }
        if (sign == 1) return res;
        return -1 * res;
        
    }
	
	public static void main (String[] args) {
		String str = "2147483648";
		StringtoInteger s = new StringtoInteger();
		System.out.println(s.myAtoi(str));
	}
}
