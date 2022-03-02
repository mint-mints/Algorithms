package tree;

public class Code06_IsBalancedTree {

    public static boolean isBalancedTree(TreeNode head) {
        if (head == null) {
            return true;
        }
        return process(head).isBalanced;
    }

    private static class ReturnType {
        boolean isBalanced;
        int height;
        ReturnType(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    private static ReturnType process(TreeNode node) {
        if (node == null) {
            return new ReturnType(true, 0);
        }
        ReturnType leftData = process(node.left);
        ReturnType rightData = process(node.right);
        boolean isBalanced = leftData.isBalanced && rightData.isBalanced
                && Math.abs(leftData.height - rightData.height) < 2;
        int height = Math.max(leftData.height, rightData.height) + 1;
        return new ReturnType(isBalanced, height);
    }
}
