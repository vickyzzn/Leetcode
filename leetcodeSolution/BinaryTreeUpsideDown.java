package leetcodeSolution;
/*
Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.

Example:

Input: [1,2,3,4,5]

    1
   / \
  2   3
 / \
4   5

Output: return the root of the binary tree [4,5,2,#,#,3,1]

   4
  / \
 5   2
    / \
   3   1

 time: O(n)
 space: O(1) iterative

 */
public class BinaryTreeUpsideDown {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null || root.left == null) return root;
        TreeNode cur = root;
        TreeNode prev = null;
        TreeNode next = null;
        TreeNode tmp = null;
        while(cur != null){
            next = cur.left;
            cur.left = tmp;
            tmp = cur.right;
            cur.right = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    }
