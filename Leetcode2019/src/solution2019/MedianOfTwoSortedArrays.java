package solution2019;
/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. 
 * The overall run time complexity should be O(log (m+n)).
 * You may assume nums1 and nums2 cannot be both empty.
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * The median is 2.0
 * @author vicky
 *
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	int m = nums1.length;
    	int n = nums2.length;
    	int k = (m + n + 1) / 2;
    	if (m > n) return findMedianSortedArrays(nums2, nums1);
     	int l = 0;
    	int r = m;
    	while (l < r) {
    		int m1 = l + (r - l) / 2;
    		int n1 = k - m1;
    		if (nums1[m1] < nums2[n1 - 1]) {
    			l = m1 + 1;
    		} else {
    			r = m1;
    		}
    	}
    	int m1 = l;
    	int n1 = k - l;
    	int c = Math.max(m1 <= 0? Integer.MIN_VALUE : nums1[m1 - 1], n1 <= 0? Integer.MIN_VALUE : nums2[n1 - 1]);
		if ((m + n) % 2 == 1) return c;
		int c2 = Math.min(m1 >= m ? Integer.MAX_VALUE:nums1[m1], n1 >= n? Integer.MAX_VALUE:nums2[n1]);
		return ((double)(c + c2))/2;
    }
}
