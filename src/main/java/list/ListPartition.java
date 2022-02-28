package list;

import org.w3c.dom.NodeList;
import sorts.HeapSort;

public class ListPartition {

    /**
     * 使用数组，进行partition
     */
    public static ListNode listPartition1(ListNode head, int pivot) {
        if (head == null) {
            return head;
        }
        ListNode curr = head;
        int i = 0;
        while (curr != null) {
            i++;
            curr = curr.next;
        }
        ListNode[] nodeArr = new ListNode[i];
        curr = head;
        for(i = 0; i < nodeArr.length; i++) {
            nodeArr[i] = curr;
            curr = curr.next;
        }
        partition(nodeArr, pivot);
        for (i = 1; i < nodeArr.length; i++) {
            nodeArr[i - 1].next = nodeArr[i];
        }
        return nodeArr[0];
    }
    public static void partition(ListNode[] nodeArr, int pivot) {
        if (nodeArr == null || nodeArr.length < 2) {
            return;
        }
        int small = - 1;
        int big = nodeArr.length;
        int index = 0;
        while (index < big) {
            if (nodeArr[index].val < pivot) {
                swap(nodeArr, ++small, index++);
            } else if (nodeArr[index].val > pivot) {
                swap(nodeArr, --big, index);
            } else {
                index++;
            }
        }
    }

    public static void swap(ListNode[] arr, int i, int j) {
        ListNode temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static ListNode ListPartition2(ListNode head, int pivot) {
        ListNode smallHead = null;
        ListNode smallTail = null;
        ListNode equalHead = null;
        ListNode equalTail = null;
        ListNode bigHead = null;
        ListNode bigTail = null;
        // every node distributed to three lists
        ListNode curr = head;
        ListNode next = null;   // save next node
        while (curr != null){
            // set the next of the current node to null
            next = curr.next;
            curr.next = null;
            if (curr.val < pivot) {
                if (smallHead == null) {
                    smallHead = curr;
                    smallTail = curr;
                } else {
                    smallTail.next = curr;
                    smallTail = curr;
                }
            } else if (curr.val == pivot) {
                if (equalHead == null) {
                    equalHead = curr;
                    equalTail = curr;
                } else {
                    equalTail.next = curr;
                    equalTail = curr;
                }
            } else {
                if (bigHead == null) {
                    bigHead = curr;
                    bigTail = curr;
                } else {
                    bigTail.next = curr;
                    bigTail = curr;
                }
            }
            curr = next;
        }
       // small and equal reconnect
        if (smallTail != null) {
            smallTail.next = equalHead;
            equalTail = equalTail == null ? smallTail : equalTail;
        }
        // all reconnect
        if (equalTail != null) {
            equalTail.next = bigHead;
        }
        return smallHead != null ? smallHead : equalHead != null ? equalHead : bigHead;
    }
}
