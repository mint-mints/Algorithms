package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code02_PrintAllSubsquences {
    /**
     * 打印一个字符串的全部子字符串
     */

    public static void printAllSubsquence1(String str) {
        char[] chs = str.toCharArray();
        process(0, chs);
    }

    // 来到i位置时，要和不要，走两条路
    // 之前做的决定保存在str中
    public static void process(int i, char[] str) {
        if (i == str.length) {
            System.out.println(String.valueOf(str));
            return;
        }
        process(i + 1, str);
        char temp = str[i];
        // 0打印出来是空的
        str[i] = 0;
        process(i + 1, str);
        str[i] = temp;
    }

    public static void printAllSubsquence2(String str) {
        char[] chs = str.toCharArray();
        process(0, chs, new ArrayList<>());
    }

    // 来到i位置时，要和不要，走两条路
    // 之前做的决定保存在res中
    public static void process(int i, char[] str, List<Character> res) {
        if (i == str.length) {
            printList(res);
            return;
        }
        List<Character> resInclude = new ArrayList<>(res);
        resInclude.add(str[i]);
        process(i + 1, str, resInclude);
        List<Character> resNoInclude = new ArrayList<>(res);
        process(i + 1, str, resNoInclude);
    }

    public static void printList(List<Character> str) {
        if (str.size() == 0) {
            System.out.print("null");
        }
        for (char c : str) {
            System.out.print(c);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String str = "abcd";
        printAllSubsquence1(str);
        printAllSubsquence2(str);
    }
}
