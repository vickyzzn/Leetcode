package solution2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length == 0) return res;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) continue;
			int sum = nums[i];
			int j = i + 1;
			int k = nums.length - 1;
			while (j < k) {
				sum = nums[j] + nums[k] + nums[i];
				if (sum == 0) {
					res.add(Arrays.asList(nums[i], nums[j], nums[k]));
					j++;
					k--;
					while (j < k && nums[j + 1] == nums[j]) j++;
					while (j < k && nums[k - 1] == nums[k]) k--;
				} else if (sum < 0) {
					j++;
				} else {
					k--;
				}
			}
		}
		return res;
        
    }
}
