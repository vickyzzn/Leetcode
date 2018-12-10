package leetcodeSolution;

import java.util.LinkedList;
import java.util.Queue;

/*
Given two binary trees, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

Example 1:

Input:     1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

Output: true
 */
public class sameTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)  return true;
        if(p == null || q == null)  return false;
        if(p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.offer(p);
        q2.offer(q);
        while(!q1.isEmpty() && !q2.isEmpty()){
            TreeNode p1 = q1.poll();
            TreeNode p2 = q2.poll();
            if(p1.val != p2.val)  return false;
            if(p1.left != null && p2.left != null){
                q1.offer(p1.left);
                q2.offer(p2.left);
            }else if(p1.left == null && p2.left == null){

            }else {
                return false;
            }
            if(p1.right != null && p2.right != null){
                q1.offer(p1.right);
                q2.offer(p2.right);
            }else if(p1.right == null && p2.right == null){
                continue;
            }else{
                return false;
            }
        }
        if(!q1.isEmpty() || !q2.isEmpty()){
            return false;
        }
        return true;
    }

    }
