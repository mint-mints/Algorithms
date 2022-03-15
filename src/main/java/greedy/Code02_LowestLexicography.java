package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class Code02_LowestLexicography {

    /**
     * 字符串数组，拼接为一个字符串，使得其字典序最小
     */

    public static class StringComparator implements Comparator<String> {
        // 字符串比较字典序：compareTo()
        @Override
        public int compare(String o1, String o2) {
            return (o1 + o2).compareTo(o2 + o1);
        }
    }

    public static String lowestLexicography(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        Arrays.sort(strs, new StringComparator());
        StringBuilder res = new StringBuilder();
        for (String str : strs) {
            res.append(str);
        }
        return res.toString();
    }
}
