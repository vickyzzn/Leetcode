package leetcodeSolution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.


Sorting:
time: O(nlogn)
space: O(1)

HashMap:
time: O(n)
space: O(n)
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return nums[n/2];
    }
    public int majorityElement2(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            if(map.containsKey(num)){
                map.put(num, map.get(num) + 1);
            }else{
                map.put(num, 1);
            }
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() > nums.length/2){
                return entry.getKey();
            }
        }
        return 0;
    }

    }
