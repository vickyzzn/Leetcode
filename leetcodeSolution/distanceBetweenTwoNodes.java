package leetcode;

public class distanceBetweenTwoNodes {
	public int distance(TreeNode root, TreeNode p, TreeNode q) {
		TreeNode n = ancestor(root, p, q);
		int n1 = dist(n, p);
		int n2 = dist(n, q);
		return n1 + n2;
	}
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {val = x;}
	}
	
	public TreeNode ancestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || p == null || q == null) return null;
		if (root == p || root == q) return root;
		TreeNode left = ancestor(root.left, p, q);
		TreeNode right = ancestor(root.right, p, q);
		if (left != null && right != null) return root;
		return left != null ? left : right;
	}
	
	public int dist(TreeNode node, TreeNode p) {
		if (node == null) return 0;
		int dist = 0;
		if (node == p || dist(node.left, p) > 0 || dist(node.right, p) > 0) {
			return 1 + dist;
		}
		return dist;
	}
}
