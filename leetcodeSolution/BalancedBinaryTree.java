package leetcodeSolution;
/*
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

time: O(n)
space: O(n)
top-down method: O(nlogn)
 */
public class BalancedBinaryTree {

    public boolean isBalanced;
    public boolean isBalanced(InorderTraversal.TreeNode root) {
        isBalanced = true;
        if(root == null) return true;
        height(root);
        return isBalanced;
    }
    public int height(InorderTraversal.TreeNode root){
        if(root == null) return 0;
        int left_height = height(root.left);
        int right_height = height(root.right);
        if(Math.abs(left_height - right_height) > 1){
            isBalanced = false;
            return -1;
        }else{
            return 1 + Math.max(height(root.right), height(root.left));
        }
    }

    }
