package leetcodeSolution;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
 */
public class InorderTraversal {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List<Integer> res){
        if(root == null) return;
        if(root.left != null){
            helper(root.left, res);
        }
        res.add(root.val);
        if(root.right != null) {
            helper(root.right, res);
        }
    }
    // 1 null 2 3
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> st = new Stack<>();
        TreeNode node = root;
        while(!st.isEmpty() || node != null)
        {
            while(node != null){
                st.push(node);
                node = node.left;
            }
            node = st.pop();
            res.add(node.val);
            node = node.right;
        }

        return res;
    }


    }

