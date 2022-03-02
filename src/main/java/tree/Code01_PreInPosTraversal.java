package tree;

import java.util.Stack;

public class Code01_PreInPosTraversal {
    /**
     *  recursive method of preorder traversal
     */
    public static void preOrderRecur(TreeNode head) {
        if (head == null) {
            return;
        }
        System.out.print(head.val + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }
    /**
     * recursive method of inorder traversal
     */
    public static void inOrderRecur(TreeNode head) {
        if (head == null) {
            return;
        }
        inOrderRecur(head.left);
        System.out.print(head.val + " ");
        inOrderRecur(head.right);
    }
    /**
     * recursive method of postorder traversal
     */
    public static void postOrderRecur(TreeNode head) {
        if (head == null) {
            return;
        }
        postOrderRecur(head.left);
        postOrderRecur(head.right);
        System.out.print(head.val + " ");
    }
    /**
     * non-recursive method of preorder traversal
     */
    public static void preOrderUnRecur(TreeNode head) {
        System.out.print("pre-order: ");
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode curr = head;
            stack.push(curr);
            while (!stack.isEmpty()) {
                curr = stack.pop();
                System.out.print(curr.val + " ");
                if (curr.right != null) {
                    stack.push(curr.right);
                }
                if (curr.left != null) {
                    stack.push(curr.left);
                }
            }
        }
        System.out.println();
    }
    /**
     * non-recursive method of inorder traversal
     */
    public static void inOrderUnRecur(TreeNode head) {
        System.out.print("in-order: ");
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode curr = head;
            while (!stack.isEmpty() || curr != null) {
                if (curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                } else {
                    curr = stack.pop();
                    System.out.print(curr.val + " ");
                    curr = curr.right;
                }
            }
        }
        System.out.println();
    }
    /**
     * non-recursive method of postorder traversal
     */
    public static void postOrderUnRecur(TreeNode head) {
        System.out.print("post-order: ");
        if (head != null) {
            Stack<TreeNode> s1 = new Stack<>();
            Stack<TreeNode> s2 = new Stack<>();
            TreeNode curr = head;
            s1.push(curr);
            while (!s1.isEmpty()) {
                curr = s1.pop();
                s2.push(curr);
                if (curr.left != null) {
                    s1.push(curr.left);
                }
                if (curr.right != null) {
                    s1.push(curr.right);
                }
            }
            while (!s2.isEmpty()) {
                System.out.print(s2.pop().val + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(5);
        head.left = new TreeNode(3);
        head.right = new TreeNode(8);
        head.left.left = new TreeNode(2);
        head.left.right = new TreeNode(4);
        head.left.left.left = new TreeNode(1);
        head.right.left = new TreeNode(7);
        head.right.left.left = new TreeNode(6);
        head.right.right = new TreeNode(10);
        head.right.right.left = new TreeNode(9);
        head.right.right.right = new TreeNode(11);

        // recursive
        System.out.println("==============recursive==============");
        System.out.print("pre-order: ");
        preOrderRecur(head);
        System.out.println();
        System.out.print("in-order: ");
        inOrderRecur(head);
        System.out.println();
        System.out.print("pos-order: ");
        postOrderRecur(head);
        System.out.println();

        // unrecursive
        System.out.println("============unrecursive=============");
        preOrderUnRecur(head);
        inOrderUnRecur(head);
        postOrderUnRecur(head);

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {this.val = val;}
}
