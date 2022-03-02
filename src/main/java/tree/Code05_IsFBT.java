package tree;

public class Code05_IsFBT {

    public static boolean isFullBinaryTree(TreeNode head) {
        if (head == null) {
            return true;
        }
        ReturnType res = process(head);
        return res.nodeNum == (1 << res.height - 1);
    }
    private static class ReturnType {
        int height;
        int nodeNum;
        ReturnType(int height, int nodeNum) {
            this.height = height;
            this.nodeNum = nodeNum;
        }
    }
    private static ReturnType process(TreeNode node) {
        if (node == null) {
            return new ReturnType(0, 0);
        }
        ReturnType leftData = process(node.left);
        ReturnType rightData = process(node.right);
        int height = Math.max(leftData.height, rightData.height) + 1;
        int nodeNum = leftData.nodeNum + rightData.nodeNum + 1;
        return new ReturnType(height, nodeNum);
    }
}
