package classics;

public class Code02_Manacher {

    /**
     * 字符串str中，最长回文子串的长度
     */

    public static int maxPalLength(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] str = manacherString(s);
        int[] radixArr = new int[str.length];   // 回文半径数组
        int max = 0;
        int R = -1;   // 回文右边界的再往右一个值，最右的有效区是R-1
        int C = -1;   // 中心
        for (int i = 0; i < str.length; i++) {
            // i至少的回文半径值
            radixArr[i] = R > i ? Math.min(R - i, radixArr[2 * C - i]) : 1;
            while (i + radixArr[i] < str.length && i - radixArr[i] > -1) {
                if (str[i + radixArr[i]] == str[i - radixArr[i]]) {
                    radixArr[i]++;
                } else {
                    break;
                }
            }
            if (i + radixArr[i] > R) {
                R = i + radixArr[i];
                C = i;
            }
            max = Math.max(max, radixArr[i]);
        }
        // 处理串的半径 - 1 = 就是原串回文串的长度
        return max - 1;
    }

    // 转化为带特殊字符的字符串
    public static char[] manacherString(String str) {
        char[] s = str.toCharArray();
        char[] res = new char[s.length * 2 + 1];
        int index = 0;
        for (int i = 0; i < res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : s[index++];
        }
        return res;
    }

    public static void main(String[] args) {
        String str1 = "abc1234321ab";
        System.out.println(maxPalLength(str1));
    }
}
