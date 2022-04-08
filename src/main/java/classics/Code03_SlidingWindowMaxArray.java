package classics;

import java.util.LinkedList;

public class Code03_SlidingWindowMaxArray {

    public static int[] getWindowMax(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        // 双向链表
        LinkedList<Integer> maxQueue = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            // R向右移动
            while (!maxQueue.isEmpty() && arr[i] >= arr[maxQueue.peekLast()]) {
                maxQueue.pollLast();
            }
            maxQueue.add(i);
            // L向右移动
            if (maxQueue.peekFirst() == i - w) {
                maxQueue.pollFirst();
            }
            // 窗口完全移动至数组中后再开始记录
            if (i >= w - 1) {
                res[index++] = arr[maxQueue.peekFirst()];
            }
        }
        return res;

    }

    // for test
    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 4, 3, 5, 4, 3, 3, 6, 7 };
        int w = 3;
        printArray(getWindowMax(arr, w));

    }

}
