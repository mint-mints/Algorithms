package dp;

import java.util.ArrayList;

public class Code03_PrintAllPermutations {
    /**
     * 找到一个字符串的全部排列。无重复
     */

    public static ArrayList<String> permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return res;
        }
        char[] chs = str.toCharArray();
        process(chs, 0, res);
        return res;
    }

    // str[i..]范围上，所有的字符都可以在i位置上，后续去尝试
    // str[0..i-1]范围上，是之前做的选择
    // 把所有的字符串形成的全排列，加到res里面去
    public static void process(char[] str, int i, ArrayList<String> res) {
        if (i == str.length) {
            res.add(String.valueOf(str));
        }
        // 26个字母的访问记录
        boolean[] visit = new boolean[26];
        for (int j = i; j < str.length; j++) {
            if (!visit[str[j] - 'a']) {
                visit[str[j] - 'a'] = true;
                swap(str, i, j);
                process(str, i + 1, res);
                // 需要再换回来
                swap(str, i, j);
            }
        }
    }

    public static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
