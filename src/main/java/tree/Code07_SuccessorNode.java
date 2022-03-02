package tree;

public class Code07_SuccessorNode {
    private static class Node {
        int val;
        Node left;
        Node right;
        Node parent;
        Node(int val) {this.val = val;}
    }

    public static Node getSuccessorNode(Node node) {
        if (node == null) {
            return node;
        }
        if (node.right != null) {
            return getLeftMost(node);
        } else {
            Node parent = node.parent;
            while (parent != null && node != parent.left) {
                node = parent;
                parent = node.parent;
            }
            return node;
        }
    }

    public static Node getLeftMost(Node node) {
        if (node == null) {
            return node;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

}
