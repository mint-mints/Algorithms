package list;

import java.util.List;
import java.util.Stack;

public class Q234_IsPalindrome {

    /**
     * need N extra space
     */
    public static boolean isPalindrome1(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode curr = head;
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }
        while (head != null) {
            if (head.val != stack.pop().val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * need 2/N extra space
     */
    public static boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode fast = head;
        ListNode low = head.next;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            low = low.next;
        }
        Stack<ListNode> stack = new Stack<ListNode>();
        while (low != null) {
            stack.push(low);
            low = low.next;
        }
        while (!stack.isEmpty()) {
            if (head.val != stack.pop().val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * need O(1) extra space
     */
    public static boolean isPalindrome3(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode n1 = head;
        ListNode n2 = head;
        // find mid node
        while (n2.next != null && n2.next.next != null) {
            n1 = n1.next;     // n1 -> mid
            n2 = n2.next.next;       // n2 -> end
        }
        // reverse right part
        n2 = null;
        ListNode n3 = null;
        while (n1 != null) {
            n3 = n1.next;
            n1.next = n2;
            n2 = n1;
            n1 = n3;
        }
        n3 = n2;    // n3 -> save the last node
        n1 = head;     // n1 -> left last node
        // check palindrome
        boolean res = true;
        while (n1 != null && n2 != null) {
            if (n1.val != n2.val) {
                res = false;
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        // recover list
        n1 = null;
         while (n3 != null) {
             n2 = n3.next;
             n3.next = n1;
             n1 = n3;
             n3 = n2;
         }
         return res;
    }
}
