package other;

public class Code01_KMP {

    /**
     * 字符串str1和str2，str1是否包含str2，如果包含请返回str2在str1中开始的位置。
     */

    // Java的getIndexOf并不是KMP算法
    public static int getIndexOf(String s, String m) {
        if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
            return -1;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = m.toCharArray();
        int[] next = getNextArray(str2);
        int i = 0;
        int j = 0;
        while (i < str1.length && j < str2.length) {
            if (str1[i] == str2[j]) {
                i++;
                j++;
            } else if (j == 0) {
                i++;
            } else {
                j = next[j];
            }
        }
        return j == str2.length ? i - j : -1;
    }

    /**
     * next数组，记录每个字符前面的前缀和后缀的最长匹配长度
     */
    public static int[] getNextArray(char[] arr) {
        if (arr.length == 1) {
            return new int[]{-1};
        }
        int[] nextArr = new int[arr.length];
        nextArr[0] = -1;
        nextArr[1] = 0;
        int i = 2;
        int compare = 0;
        while (i < nextArr.length) {
            if (arr[i - 1] == arr[compare]) {
                // i和compare都要++
                nextArr[i++] = ++compare;
            } else if (compare > 0) {
                compare = nextArr[i - 1];
            } else {
                // 赋值时要记得给i++
                nextArr[i++] = 0;
            }
        }
        return nextArr;
    }

    public static void main(String[] args) {
        String str = "abcabcababaccc";
        String match = "ababa";
        System.out.println(getIndexOf(str, match));

    }
}
