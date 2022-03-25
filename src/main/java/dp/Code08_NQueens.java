package dp;

public class Code08_NQueens {
    /**
     * N皇后问题
     */
    public static int num1(int n) {
        if (n < 1) {
            return 0;
        }
        int[] record = new int[n];
        return process1(0, record, n);
    }
    public static int process1(int i, int[] record, int n) {
        if (i == n) {
            return 1;
        }
        int res = 0;
        for (int j = 0; j < n; j++) {
            if (isValid(i, j, record)) {
                record[i] = j;
                res += process1(i + 1, record, n);
            }
        }
        return res;
    }
    public static boolean isValid(int i, int j, int[] record) {
        for (int line = 0; line < i; line++) {
            // 出现同列情况，或者同对角线情况
            if (record[line] == j || Math.abs(record[line] - j) == (i - line)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 用位运算加速
     * 只能处理n小于等于32的情况（int只有32位）
     */
    public static int num2(int n) {
        if (n < 1) {
            return 0;
        }
        int upperLim = n== 32 ? -1 : (1 << n) - 1;
        return process2(upperLim, 0, 0, 0);
    }
    public static int process2(int upperLim, int colLim, int leftDiaLim, int rightDiaLim) {
        if (colLim == upperLim) {
            return 1;
        }
        int res = 0;
        int mostRightOne;
        int pos = upperLim & (~(colLim | leftDiaLim | rightDiaLim));
        while (pos != 0) {
            mostRightOne = pos & (~pos + 1);
            pos = pos - mostRightOne;
            res += process2(upperLim, colLim | mostRightOne,
                    (leftDiaLim | mostRightOne) << 1,
                    (rightDiaLim | mostRightOne) >> 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 14;

        long start = System.currentTimeMillis();
        System.out.println(num2(n));
        long end = System.currentTimeMillis();
        System.out.println("cost time: " + (end - start) + "ms");

        start = System.currentTimeMillis();
        System.out.println(num1(n));
        end = System.currentTimeMillis();
        System.out.println("cost time: " + (end - start) + "ms");

    }
}
