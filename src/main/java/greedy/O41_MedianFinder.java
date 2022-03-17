package greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class O41_MedianFinder {
    /**
     * 得到一个数据流中的中位数
     */
    public static class MedianFinder {
        public PriorityQueue<Integer> smallNumHeap;
        public PriorityQueue<Integer> bigNumHeap;

        public MedianFinder() {
            // 用大根堆来保存较小的数
            smallNumHeap = new PriorityQueue<>(new BiggerComparator());
            // 用小根堆老保存较大的数
            bigNumHeap = new PriorityQueue<>();

        }

        public void addNum(int num) {
            if (smallNumHeap.isEmpty() || num <= smallNumHeap.peek()) {
                smallNumHeap.add(num);
            } else {
                bigNumHeap.add(num);
            }
            modifyHeapSize();
        }

        public void modifyHeapSize() {
            // 检查两个堆的数量是否平衡
            if (bigNumHeap.size() == smallNumHeap.size() + 2) {
                smallNumHeap.add(bigNumHeap.poll());
            }
            if (smallNumHeap.size() == bigNumHeap.size() + 2){
                bigNumHeap.add(smallNumHeap.poll());
            }
        }

        public double findMedian() {
            int bigSize = bigNumHeap.size();
            int smallSize = smallNumHeap.size();
//            if (bigSize + smallSize == 0) {
//                return null;
//            }
            if (((bigSize + smallSize) & 1) == 0) {
                return (bigNumHeap.peek() + smallNumHeap.peek()) / 2.0;
            }
            return bigSize > smallSize ? bigNumHeap.peek() :smallNumHeap.peek();
        }

        public static class BiggerComparator implements Comparator<Integer> {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        }

    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }
}
