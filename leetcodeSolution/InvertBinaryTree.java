package leetcodeSolution;

import java.util.LinkedList;
import java.util.Queue;

/*
Invert a binary tree.

Example:

Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9
Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1

 time: O(n)
 space: O(n)
 */
public class InvertBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }

    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return root;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;
            if (node.left != null) q.offer(node.left);
            if (node.right != null) q.offer(node.right);
        }
        return root;
    }
}