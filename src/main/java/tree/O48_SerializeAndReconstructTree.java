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
        String res = root.val + "_";;
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
}
