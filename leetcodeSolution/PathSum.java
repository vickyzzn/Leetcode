package leetcodeSolution;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.


 */
public class PathSum {
    public boolean hasPathSum(InorderTraversal.TreeNode root, int sum) {
        if(root == null) return false;
        if(root.left == null && root.right == null) {
            return root.val == sum;
        }else{
            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        }
    }
    public boolean hasPathSum2(InorderTraversal.TreeNode root, int sum) {
        if(root == null) return false;
        Stack<InorderTraversal.TreeNode> q = new Stack<>();
        q.push(root);
        while(!q.isEmpty()){
            InorderTraversal.TreeNode node = q.pop();
            if(node.left == null && node.right == null){
                if(root.val == sum) return true;
            }else{
                if(node.right != null) {
                    node.right.val += node.val;
                    q.push(node.right);
                }
                if(node.left != null) {
                    node.left.val += node.val;
                    q.push(node.left);
                }

            }
        }
        return false;
    }


    }
