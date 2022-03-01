package tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TreeMaxWidth {

    /**
     * 宽度遍历
     */
    public static void widthTraversal(TreeNode head) {
        if (head == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            System.out.print(curr.val + " ");
            if (curr.left != null) {
                queue.add(curr.left);
            }
            if (curr.right != null) {
                queue.add(curr.right);
            }
        }
        System.out.println();
    }

    /**
     * return the max width of the binary tree
     */
    public static int getMaxWidth1(TreeNode head) {
        if (head == null) {
            return 0;
        }
        int maxWidth = 0;
        int currLevel = 0;
        int currWidth = 0;
        HashMap<TreeNode, Integer> levelMap = new HashMap<>();
        levelMap.put(head, 1);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            int nodeLevel = levelMap.get(curr);
            if (nodeLevel == currLevel) {
                currWidth++;
            } else {
                currLevel++;
                currWidth = 1;
            }
            maxWidth = Math.max(maxWidth, currWidth);
            if (curr.left != null) {
                queue.add(curr.left);
                levelMap.put(curr.left, nodeLevel + 1);
            }
            if (curr.right != null) {
                queue.add(curr.right);
                levelMap.put(curr.right, nodeLevel + 1);
            }
        }
        return maxWidth;
    }

    /**
     * don't need the stack
     */
    public static int getMaxWidth2(TreeNode head) {
        if (head == null) {
            return 0;
        }
        TreeNode currEnd = null;
        TreeNode nextEnd = null;
        int currWidth = 0;
        int maxWidth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        currEnd = head;
        TreeNode curr = null;
        while (!queue.isEmpty()) {
            curr = queue.poll();
            currWidth++;
            if (curr.left != null) {
                queue.add(curr.left);
                nextEnd = curr.left;
            }
            if (curr.right != null) {
                queue.add(curr.right);
                nextEnd = curr.right;
            }
            if (curr == currEnd) {
                maxWidth = Math.max(maxWidth, currWidth);
                currEnd = nextEnd;
                currWidth = 0;
            }
        }
        return maxWidth;
    }

    /**
     * 用队列的长度记下每层的节点数
     */
    public static int getMaxWidth3(TreeNode head) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        int maxWidth = 0;
        int currWidth = 0;
        int size = 0;
        TreeNode curr = null;
        while (!queue.isEmpty()) {
            size = queue.size();
            currWidth = 0;
            for (; size > 0; size--) {
                curr = queue.poll();
                currWidth++;
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            maxWidth = Math.max(maxWidth, currWidth);
        }
        return maxWidth;
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

        System.out.println("==============widthTraversal==============");
        widthTraversal(head);

        System.out.println("==============1==============");
        System.out.println(getMaxWidth1(head));
        System.out.println("==============2==============");
        System.out.println(getMaxWidth2(head));
        System.out.println("==============3==============");
        System.out.println(getMaxWidth3(head));

    }

}
