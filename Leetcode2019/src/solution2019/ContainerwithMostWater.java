package solution2019;

public class ContainerwithMostWater {
	public int maxArea(int[] height) {
		int area = 0;
		int i = 0;
		int j = height.length;
		while (i < height.length && j > 0) {
			int h = Math.min(height[i], height[j]);
			area = Math.max(area, h * (j - i));
			if (h == height[i]) {
				i++;
			} else {
				j--;
			}
			
		}
		
		return area;
	}
}
