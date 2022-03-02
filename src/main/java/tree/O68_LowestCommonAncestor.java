package tree;

import java.util.HashMap;
import java.util.HashSet;

public class O68_LowestCommonAncestor {

    /**
     * 递归方法
     */
    public static TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor1(root.left, p, q);
        TreeNode right = lowestCommonAncestor1(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }

    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
        parentMap.put(root, root);
        getParents(root, parentMap);
        HashSet<TreeNode> parentSet = new HashSet<>();
        TreeNode curr = p;
        while (curr != parentMap.get(curr)) {
            parentSet.add(curr);
            curr = parentMap.get(curr);
        }
        parentSet.add(root);
        curr = q;
        while (!parentSet.contains(curr)) {
            curr = parentMap.get(curr);
        }
        return curr;
    }
    public static void getParents(TreeNode node, HashMap<TreeNode, TreeNode> parentMap) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            parentMap.put(node.left, node);
        }
        if (node.right != null) {
            parentMap.put(node.right, node);
        }
        getParents(node.left, parentMap);
        getParents(node.right, parentMap);
    }
}
