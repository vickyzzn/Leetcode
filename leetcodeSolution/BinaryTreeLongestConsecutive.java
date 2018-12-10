package leetcodeSolution;
/*
Given a binary tree, find the length of the longest consecutive sequence path.

The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).

Example 1:

Input:

   1
    \
     3
    / \
   2   4
        \
         5

Output: 3

Explanation: Longest consecutive sequence path is 3-4-5, so return 3.

time: O(n)
space: O(n)
 */
public class BinaryTreeLongestConsecutive {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public int longestConsecutive(TreeNode root) {
        if(root == null) return 0;
        int res = 0;
        res = dfs(root, 0, 0, res);
        return res;
    }
    public int dfs(TreeNode root, int target, int length, int res){
        if(root == null) return res;
        if(root.val == target){
            length++;
        }else{
            length = 1;
        }
        res = Math.min(res, length);
        return Math.max(dfs(root.left, root.val + 1, length, res), dfs(root.right, root.val + 1, length, res));
    }
    }
