package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class Code01_BestArrange {

    /**
     * 给出一列项目，计算出一个会议室能容纳的最多项目数
     */

    public static class Program {
        public int start;    // start time
        public int end;      // end time
        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static class ProgramComparator implements Comparator<Program> {
        // 按照结束时间的早晚来排序，结束早的次序在前面
        @Override
        public int compare(Program o1, Program o2) {
            return o1.end - o2.end;
        }
    }

    public static int bestArrange(Program[] programs, int start) {
        Arrays.sort(programs, new ProgramComparator());
        int res = 0;
        for (int i = 0; i < programs.length; i++) {
            if (start <= programs[i].start) {
                res++;
                start = programs[i].end;
            }
        }
        return res;
    }

}
