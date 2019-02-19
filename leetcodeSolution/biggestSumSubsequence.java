package leetcode;
/*
 * [1,2,-2, 0, 100,10]
 */
public class biggestSumSubsequence {
	public int sumSubsequence(int[] num) {
		int[] dp = new int[num.length];
		int res = 0;
		dp[0] = num[0];
		dp[1] = num[1];
		for (int i = 2; i < num.length; i++) {
			dp[i] = Math.max(dp[i - 2], dp[i - 2] + num[i]);
			res = Math.max(res, dp[i]);
		}
		return res;
	}
	public static void main (String[] args) {
		biggestSumSubsequence b = new biggestSumSubsequence();
		int[] num = {1,2,-10,-11};
		System.out.println(b.sumSubsequence(num));
	}
	
}
