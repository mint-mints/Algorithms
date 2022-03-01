package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q199_RightSideView {
    /**
     * get the right nodes of every level
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode curr = root;
        queue.add(curr);
        int size = 0;
        while (!queue.isEmpty()) {
            size = queue.size();
            for (; size > 0; size--) {
                curr = queue.poll();
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
                if (size == 1) {
                    res.add(curr.val);
                }
            }
        }
        return res;
    }
}
