package leetcodeSolution;

import java.util.ArrayList;
import java.util.List;

/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

time: O(n)
space: O(n)
 */
public class PathSumII {
    public class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;
        TreeNode(int x){val = x;}
    }


    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> com = new ArrayList<>();
        helper(root, sum, com, res);
        return res;
    }

    public void helper(TreeNode root, int sum, List<Integer> com, List<List<Integer>> res){
        if(root == null) return;
        com.add(root.val);
        if(root.left == null && root.right == null){
            if(root.val == sum){
                res.add(new ArrayList<>(com));
            }
            return;
        }

        if(root.left != null){
            helper(root.left, sum - root.val, com, res);
            com.remove(com.size() - 1);
        }
        if(root.right != null){
            helper(root.right, sum - root.val, com, res);
            com.remove(com.size() - 1);
        }

    }
}
