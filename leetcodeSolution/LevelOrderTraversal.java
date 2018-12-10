package leetcodeSolution;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*

Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]

time: O(n)
space: O(n)
 */
public class LevelOrderTraversal {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            List<Integer> com = new ArrayList<>();
            int size = q.size();
            while(size -- > 0){
                TreeNode node = q.poll();
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
                com.add(node.val);
            }
            res.add(com);
        }
        return res;
    }

    }
