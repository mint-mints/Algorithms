package list;

import com.sun.nio.sctp.PeerAddressChangeNotification;

import java.util.HashMap;

public class O35_CopyRandomList {

    /**
     * use HashMap
     */
    public static RandomNode copyRandomList1(RandomNode head) {
        if (head == null) {
            return null;
        }
        HashMap<RandomNode, RandomNode> map = new HashMap<>();
        RandomNode curr = head;
        while (curr != null) {
            map.put(curr, new RandomNode(curr.val));
            curr = curr.next;
        }
        curr = head;
        while (curr != null) {
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }
        return map.get(head);
    }

    /**
     * extra space: O(1)
     */
    public static RandomNode copyRandomList2(RandomNode head) {
        if (head == null) {
            return null;
        }
        RandomNode curr = head;
        RandomNode next = null;     // save the next node
        // add the new node after the old node
        while (curr != null) {
            next = curr.next;
            curr.next = new RandomNode(curr.val);
            curr.next.next = next;
            curr = next;
        }
        curr = head;
        RandomNode currCopy = null;
        // ser copy node random
        while (curr != null) {
            next = curr.next.next;
            currCopy = curr.next;
            currCopy.random = curr.random != null ? curr.random.next : null;
            curr = next;
        }
        RandomNode res = head.next;
        curr = head;
        // split two lists
        while (curr != null) {
            next = curr.next.next;
            currCopy = curr.next;
            curr.next = next;
            currCopy.next = next != null ? next.next : null;
            curr = next;
        }
        return res;
    }

    public static void printRandLinkedList(RandomNode head) {
        RandomNode cur = head;
        System.out.print("order: ");
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
        cur = head;
        System.out.print("rand:  ");
        while (cur != null) {
            System.out.print(cur.random == null ? "- " : cur.random.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        RandomNode head = null;
        RandomNode res1 = null;
        RandomNode res2 = null;

        head = new RandomNode(7);
        head.next = new RandomNode(13);
        head.next.next = new RandomNode(11);
        head.next.next.next = new RandomNode(10);
        head.next.next.next.next = new RandomNode(1);

        head.random = null; // 1 -> null
        head.next.random = head; // 2 -> 1
        head.next.next.random = head.next.next.next.next; // 3 -> 5
        head.next.next.next.random = head.next.next; // 4 -> 3
        head.next.next.next.next.random = head; // 5 -> 1

        System.out.println("============head=============");
        printRandLinkedList(head);
//        res1 = copyRandomList1(head);
//        System.out.println("============head=============");
//        printRandLinkedList(head);
//        System.out.println("============res1=============");
//        printRandLinkedList(res1);
        res2 = copyRandomList2(head);
        System.out.println("============head=============");
        printRandLinkedList(head);
        System.out.println("============res2=============");
        printRandLinkedList(res2);

    }
}

class RandomNode {
    int val;
    RandomNode next;
    RandomNode random;
    RandomNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
