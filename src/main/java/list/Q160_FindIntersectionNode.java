package list;

import java.util.HashSet;

public class Q160_FindIntersectionNode {

    /**
     * 找出并返回两个单链表相交的起始节点。链表可能有环，可能无环。
     * @param head1 链表1
     * @param head2 链表2
     * @return 第一个相交的节点，若不相交返回null。
     */
    public static ListNode getIntersectionNode(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null || head1.next == null || head2.next == null) {
            return null;
        }
        ListNode loop1 = getLoopNode(head1);
        ListNode loop2 = getLoopNode(head2);
        if (loop1 == null && loop2 == null) {
            return noLoop(head1, head2);
        }
        if (loop1 != null && loop2 != null) {
            return bothLoop(head1, loop1, head2, loop2);
        }
        return null;
    }

    /**
     * 判断是否有环。
     * 方法1：使用哈希表
     */
    public static ListNode getLoopNode1(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode curr = head;
        while (curr != null) {
            if (set.contains(curr)) {
                return curr;
            } else {
                set.add(curr);
            }
            curr = curr.next;
        }
        return null;
    }

    /**
     * 判断是否有环。
     * 方法2：使用快慢指针
     */
    public static ListNode getLoopNode(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        ListNode n1 = head.next;   // n1 -> slow
        ListNode n2 = head.next.next;   // n2 -> fast
        while (n1 != n2) {
            if (n2.next == null || n2.next.next == null) {
                return null;
            }
            n1 = n1.next;
            n2 = n2.next.next;
        }
        // n2 -> walk again from head
        n2 = head;
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }

    /**
     * 两个链表都无环，返回相交节点。
     */
    public static ListNode noLoop(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        int n = 0;
        // get the end node of list
        ListNode curr1 = head1;
        ListNode curr2 = head2;
        while (curr1.next!= null) {
            n++;
            curr1 = curr1.next;
        }
        while (curr2.next != null) {
            n--;
            curr2 = curr2.next;
        }
        // compare the end node
        if (curr1 != curr2) {
            return null;
        }
        // assign the longer list to the curr1
        curr1 = n >= 0 ? head1 : head2;
        curr2 = curr1 == head1 ? head2 : head1;
        n = Math.abs(n);
        while (n > 0) {
            curr1 = curr1.next;
            n--;
        }
        while (curr1 != curr2) {
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        return curr1;
    }

    /**
     * 两个链表都有环，返回相交节点
     */
    public static ListNode bothLoop(ListNode head1, ListNode loop1, ListNode head2, ListNode loop2) {
        ListNode curr1 = null;
        ListNode curr2 = null;
        if (loop1 == loop2) {
            curr1 = head1;
            curr2 = head2;
            int n = 0;
            while (curr1 != loop1) {
                n++;
                curr1 = curr1.next;
            }
            while (curr2 != loop2) {
                n--;
                curr2 = curr2.next;
            }
            curr1 = n >= 0 ? head1 : head2;
            curr2 = curr1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while (n > 0) {
                curr1 = curr1.next;
                n--;
            }
            while (curr1 != curr2) {
                curr1 = curr1.next;
                curr2 = curr2.next;
            }
            return curr1;
        } else {
            curr1 = loop1.next;
            while (curr1 != loop1) {
                if (curr1 == loop2) {
                    return loop1;
                }
                curr1 = curr1.next;
            }
            return null;
        }
    }

    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        head1.next.next.next.next.next = new ListNode(6);
        head1.next.next.next.next.next.next = new ListNode(7);

        // 0->9->8->6->7->null
        ListNode head2 = new ListNode(0);
        head2.next = new ListNode(9);
        head2.next.next = new ListNode(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectionNode(head1, head2).val);

        // 1->2->3->4->5->6->7->4...
        head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        head1.next.next.next.next.next = new ListNode(6);
        head1.next.next.next.next.next.next = new ListNode(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new ListNode(0);
        head2.next = new ListNode(9);
        head2.next.next = new ListNode(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(getIntersectionNode(head1, head2).val);

        // 0->9->8->6->7->4->5->6..
        head2 = new ListNode(0);
        head2.next = new ListNode(9);
        head2.next.next = new ListNode(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectionNode(head1, head2).val);

    }
}
