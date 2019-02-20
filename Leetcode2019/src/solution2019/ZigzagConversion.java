package solution2019;

import java.util.List;
import java.util.ArrayList;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows 
 * like this: (you may want to display this pattern in a fixed font for better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * @author vicky
 *
 */
public class ZigzagConversion {
	public String convert(String s, int numRows) {
		if (numRows == 1) return s;
		List<StringBuilder> l = new ArrayList<>();
		for (int i = 0; i < Math.min(numRows, s.length()); i++) {
			l.add(new StringBuilder());
		}
		int curRow = 0;
		boolean down = false;
		for (int i = 0; i < s.length(); i++) {
			l.get(curRow).append(s.charAt(i));
			if (curRow == 0 || curRow == numRows - 1) down = !down;
			curRow += down? 1 : -1;
		}
		StringBuilder res = new StringBuilder();
		for (StringBuilder ss : l) res.append(ss);
		return res.toString();
        
    }
}
