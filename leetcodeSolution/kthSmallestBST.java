package leetcodeSolution;

import java.util.LinkedList;
import java.util.Queue;

/*
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note:
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Example 1:

Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1
 */
public class kthSmallestBST {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public int kthSmallest(TreeNode root, int k) {
        int counter = helper(root.left);
        if(k <= counter){
            return kthSmallest(root.left, k);
        }else if(k > counter + 1){
            return kthSmallest(root.right, k - 1 - counter);
        }
        return root.val;
    }

    public int helper(TreeNode root){
        if(root == null) return 0;
        return helper(root.left) + helper(root.right) + 1;
    }


}
