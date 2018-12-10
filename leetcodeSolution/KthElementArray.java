package leetcodeSolution;

import java.util.PriorityQueue;
import java.util.Queue;

/*
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:

Input: [3,2,1,5,6,4] and k = 2
Output: 5

time: O(nlogk)
space: O(k)
 */
public class KthElementArray {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        Queue<Integer> q = new PriorityQueue<>();
        for(int num : nums){
            q.offer(num);
            if(q.size() > k){
                q.poll();
            }
        }
        return q.peek();
    }

    }
