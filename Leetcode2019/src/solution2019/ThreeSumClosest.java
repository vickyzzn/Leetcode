package solution2019;

import java.util.Arrays;

public class ThreeSumClosest {
	public int threeSumClosest(int[] nums, int target) {
		if (nums == null || nums.length == 0) return 0;
		int res = 0;
		int closest = Integer.MAX_VALUE;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) continue;
			int j = i + 1;
			int k = nums.length - 1;
			int sum = nums[i];
			while (j < k) {
				sum = nums[i] + nums[j] + nums[k];
				if (Math.abs(sum - target) < closest) {
					closest = Math.abs(sum - target);
					res = sum;
				}
				if (sum == target) {
					return target;
				}
				else if (sum < target) {
					j++;
				} else {
					k--;
				}
			}
		}
		return res;
        
    }
}
