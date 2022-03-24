package dp;

public class Code06_ConvertToLetterString {
    /**
     * 规定1和A对应、2和B对应、3和C对应...26和Z对应
     * 给定一个数字字符串，返回有多少种转化结果。
     */

    public static int number(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] chs = str.toCharArray();
        return process(chs, 0);
    }

    public static int process(char[] str, int i) {
        if (i == str.length) {
            return 1;
        }
        // 说明组合方式错误
        if (str[i] == '0') {
            return 0;
        }
        if (str[i] == '1') {
            // i自己作为单独的部分，后续有多少种方法
            int res = process(str, i + 1);
            if (i + 1 <str.length) {
                // i和i+1一起作为一个部分，后续有多少种方法
                res += process(str, i + 2);
            }
            return res;
        }
        if (str[i] == '2') {
            int res = process(str, i + 1);
            if (i + 1 < str.length && str[i + 1] >= '0' && str[i + 1] <= '6') {
                res += process(str, i + 2);
            }
            return res;
        }
        return process(str, i + 1);
    }
}
