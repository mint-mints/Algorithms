package tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class O48_SerializeAndReconstructTree {

    /**
     * use preoder traversal
     */
    public static String serialize(TreeNode root) {
        if (root == null) {
            return "#_";
        }
        String res = root.val + "_";
        res += serialize(root.left);
        res += serialize(root.right);
        return res;
    }

    public static TreeNode deserialize(String data) {
        if (data.equals("#_")) {
            return null;
        }
        String[] values = data.split("_");
        Queue<String> queue = new LinkedList<>(Arrays.asList(values));
        return reconTree(queue);
    }

    public static TreeNode reconTree(Queue<String> queue) {
        String val = queue.poll();
        if (val == null || val.equals("#")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = reconTree(queue);
        node.right = reconTree(queue);
        return node;
    }

    /**
     * use level traversal
     */
    public static String serialize1(TreeNode root) {
        if (root == null) {
            return "#_";
        }
        StringBuilder res = new StringBuilder();
        res.append(root.val).append("_");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode curr = null;
        // 在循环中，添加node的孩子的值，而不是node的值，否则叶节点的null无法添加到字符串中
        while (!queue.isEmpty()) {
            curr = queue.poll();
            if (curr.left != null) {
                res.append(curr.left.val).append("_");
                queue.add(curr.left);
            } else {
                res.append("#_");
            }
            if (curr.right != null) {
                res.append(curr.right.val).append("_");
                queue.add(curr.right);
            } else {
                res.append("#_");
            }
        }
        return res.toString();
    }

    public static TreeNode deserialize1(String data) {
        String[] values = data.split("_");
        int index = 0;
        Queue<TreeNode> nodes = new LinkedList<>();
        TreeNode root = generateNodeByString(values[index++]);
        if (root != null) {
            nodes.add(root);
        }
        TreeNode node = null;
        while (!nodes.isEmpty()) {
            node = nodes.poll();
            node.left = generateNodeByString(values[index++]);
            node.right = generateNodeByString(values[index++]);
            if (node.left != null) {
                nodes.add(node.left);
            }
            if (node.right != null) {
                nodes.add(node.right);
            }
        }
        return root;
    }
    public static TreeNode generateNodeByString(String val) {
        if (val.equals("#")) {
            return null;
        }
        return new TreeNode(Integer.parseInt(val));
    }

}
