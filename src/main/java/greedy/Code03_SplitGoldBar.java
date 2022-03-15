package greedy;

import java.nio.channels.Pipe;
import java.util.PriorityQueue;

public class Code03_SplitGoldBar {

    /**
     * 用最少的钱切分金条，满足数组中的所有长度。每次切分需要消耗当前金条长度数值的钱数。返回最少的花费。
     * 哈夫曼编码问题。
     * 使用小根堆。
     */

    public static int LessMoney(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            priorityQueue.add(arr[i]);
        }
        int res = 0;
        while (priorityQueue.size() > 1) {
            int cur = priorityQueue.poll() + priorityQueue.poll();
            priorityQueue.add(cur);
            res += cur;
        }
        return res;
    }
}
