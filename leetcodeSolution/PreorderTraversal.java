package leetcodeSolution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if(root == null) return res;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode node = st.pop();
            res.add(node.val);
            if(node.right != null) st.push(node.right);
            if(node.left != null) st.push(node.left);
        }

        return res;

    }
}
