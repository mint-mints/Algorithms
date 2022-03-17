package greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q502_IPO {

    /**
     * @param k 可以做的最多项目数
     * @param w 初始资金
     * @param profits 每个项目的利润
     * @param capital 每个项目所需的资金
     * @return 最终可获得的最多资本
     */

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        if (k == 0 || profits == null || capital == null || profits.length == 0 || capital.length == 0) {
            return 0;
        }
        PriorityQueue<Program> minCapitalQ = new PriorityQueue<>(new MinCapitalComparator());
        for (int i = 0; i < profits.length; i++) {
            minCapitalQ.add(new Program(profits[i], capital[i]));
        }
        int num = 0;
        PriorityQueue<Program> maxProfitQ = new PriorityQueue<>(new MaxProfitComparator());
        while (num < k) {     // 不能加等号
            while (!minCapitalQ.isEmpty() && minCapitalQ.peek().capital <= w) {
                maxProfitQ.add(minCapitalQ.poll());
            }
            if (maxProfitQ.isEmpty()) {
                return w;
            }
            w += maxProfitQ.poll().profit;
            num++;
        }
        return w;
    }

    public static class Program {
        public int profit;
        public int capital;
        public Program(int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
        }
    }

    public static class MaxProfitComparator implements Comparator<Program> {
        @Override
        public int compare(Program o1, Program o2) {
            return o2.profit - o1.profit;
        }
    }
    public static class MinCapitalComparator implements Comparator<Program> {
        @Override
        public int compare(Program o1, Program o2) {
            return o1.capital - o2.capital;
        }
    }

}
