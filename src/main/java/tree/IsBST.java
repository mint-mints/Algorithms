package tree;


import java.util.Stack;

public class IsBST {

    /**
     * 使用中序遍历，判断是否升序
     */
    public static boolean isBST(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode curr = head;
            int pre = Integer.MIN_VALUE;
            while (!stack.isEmpty() || curr != null) {
                if (curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                } else {
                    curr = stack.pop();
                    if (curr.val <= pre) {
                        return false;
                    } else {
                        pre = curr.val;
                    }
                    curr = curr.right;
                }
            }
        }
        return true;
    }

}
