package leetcodeSolution;

import java.util.Stack;

/*
Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.

You may assume each number in the sequence is unique.

Consider the following binary search tree:

     5
    / \
   2   6
  / \
 1   3
Example 1:

Input: [5,2,6,1,3]
Output: false

Example 2:

Input: [5,2,1,3,6]
Output: true

time: O(n)
space: O(1)
 */
public class VerifyPreorder {
    public boolean verifyPreorder(int[] preorder) {
        if(preorder == null || preorder.length == 0) return true;
        Stack<Integer> st = new Stack<>();
        int min = Integer.MIN_VALUE;
        for(int num : preorder){
            if(num < min) return false;
            while(!st.isEmpty() && num > st.peek()){
                min = st.pop();
            }
            st.push(num);
        }
        return true;
    }

    }
