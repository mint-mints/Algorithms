package tree;

import java.util.LinkedList;
import java.util.Queue;

public class IsCBT {

    public static boolean isCompleteBinaryTree(TreeNode head) {
        if (head == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        TreeNode curr = head;
        boolean leaf = false;
        TreeNode left = null;
        TreeNode right = null;
        while (!queue.isEmpty()) {
            curr = queue.poll();
            left = curr.left;
            right = curr.right;
            if ((leaf && (left != null || right != null)) || (left == null && right != null)) {
                return false;
            }
            if (left != null) {
                queue.add(left);
            }
            if (right != null) {
                queue.add(right);
            } else {
                leaf = true;
            }
        }
        return true;
    }
}
