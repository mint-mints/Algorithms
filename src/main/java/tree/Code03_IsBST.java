package tree;


import java.util.Stack;

public class Code03_IsBST {

    /**
     * 使用中序遍历，判断是否升序
     */
    public static boolean isBST(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode curr = head;
            int pre = Integer.MIN_VALUE;
            boolean firstNode = true;
            while (!stack.isEmpty() || curr != null) {
                if (curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                } else {
                    curr = stack.pop();
                    if (curr.val <= pre) {
                        // 第一个节点如果是MIN_VALUE
                        if (firstNode) {
                            firstNode = false;
                            pre = curr.val;
                        } else {
                            return false;
                        }
                    } else {
                        pre = curr.val;
                    }
                    curr = curr.right;
                }
            }
        }
        return true;
    }

    /**
     * 使用递归方法
     */
    public static boolean isBSTRecur(TreeNode head) {
        if (head == null) {
            return true;
        }
        return process(head).isBST;
    }
    private static class ReturnType {
        boolean isBST;
        int min;
        int max;
        ReturnType(boolean isBST, int min, int max) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
        }
    }

    private static ReturnType process(TreeNode node) {
        if (node == null) {
            return null;
        }
        ReturnType leftData = process(node.left);
        ReturnType rightData = process(node.right);
        boolean isBST = true;
        if (leftData != null && (!leftData.isBST || leftData.max >= node.val)) {
            isBST = false;
        }
        if(rightData != null && (!rightData.isBST || rightData.min <= node.val)) {
            isBST = false;
        }
        int min = node.val;
        int max = node.val;
        if (leftData != null) {
            min = Math.min(min, leftData.min);
            max = Math.max(max, leftData.max);
        }
        if (rightData != null) {
            min = Math.min(min, rightData.min);
            max = Math.max(max, rightData.max);
        }
        return new ReturnType(isBST, min, max);
    }

}
