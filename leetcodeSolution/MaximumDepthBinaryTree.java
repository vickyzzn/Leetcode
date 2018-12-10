package leetcodeSolution;

import java.util.LinkedList;
import java.util.Queue;

/*
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

   Time: O(n)
   Space: O(n)
 */
public class MaximumDepthBinaryTree {
    public int maxDepth(InorderTraversal.TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public int maxDepth2(InorderTraversal.TreeNode root) {
        if(root == null) return 0;
        Queue<InorderTraversal.TreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth = 0;
        while(!q.isEmpty()){
            int size = q.size();
            depth++;
            while(size-- > 0) {
                InorderTraversal.TreeNode node = q.poll();
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
        }
        return depth;
    }
    }
