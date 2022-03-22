package dp;

import java.util.ArrayList;
import java.util.List;

public class Code01_Hanoi {
    /**
     * 汉诺塔问题
     */
    public static void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        if (A == null || A.size() < 1) {
            return;
        }
        func(A.size(), A, B, C);

    }
    public static void func(int rest, List<Integer> A, List<Integer> B, List<Integer> C) {
        if (rest == 1) {
            // 注意不能写成A.remove(0)，因为A并不是一定只有一个元素了。
            C.add(A.remove(A.size() - 1));
        } else {
            func(rest - 1, A, C, B);
            C.add(A.remove(A.size() - 1));
            func(rest - 1, B, A, C);
        }

    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();
        List<Integer> C = new ArrayList<>();
        A.add(1);
        A.add(0);
        hanota(A, B, C);

    }
}
