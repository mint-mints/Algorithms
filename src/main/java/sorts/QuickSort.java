package sorts;

import java.util.Arrays;
import java.util.Collections;

public class QuickSort {
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    // arr[L..R]排好序
    public static void quickSort(int[] arr, int L, int R) {
        if (L < R) {
            swap(arr, (int)(Math.random() * (R - L + 1)) + L, R);
            int[] p = partition(arr, L, R);       // 返回的都是长度为2的数组。
            quickSort(arr, L, p[0] - 1);
            quickSort(arr, p[1] + 1, R);
        }
    }

    // 这是一个处理[L..R]的函数
    // 默认以arr[R]做划分，划分为小于arr[R]，等于arr[R]，大于arr[R]三个部分。
    // 返回等于arr[R]区域的[左边界，右边界]，所以返回一个长度为2的数组res。
    public static int[] partition(int[] arr, int L, int R){
        int less = L - 1;     // 小于区右边界
        int more = R;         // 大于区左边界
        while (L < more) {           // L表示当前数位置
            if (arr[L] < arr[R]) {
                swap(arr, ++less, L++);
            } else if (arr[L] > arr[R]) {
                swap(arr, --more, L);    // 此处L不增加，因为L位置刚交换过来的元素还没有比较过。
            } else {
                L++;
            }
        }
        swap(arr, more, R);
        return new int[]{less + 1, more};
    }

    public static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }


    public static void quickSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort1(arr, 0, arr.length - 1);
    }
    public static void quickSort1(int[] arr, int L, int R) {
        if (L < R) {
            swap(arr, R, (int)(Math.random() * (R - L + 1)) + L);
            int[] p = partition1(arr, L, R);
            quickSort1(arr, L, p[0] - 1);
            quickSort1(arr, p[1] + 1, R);
        }
    }

    public static int[] partition1(int[] arr, int L, int R) {
        int small = L - 1;
        int big = R;
        while (L < big) {
            if (arr[L] < arr[R]) {
                swap(arr, L++, ++small);
            } else if (arr[L] == arr[R]) {
                L++;
            }else {
                swap(arr, L, --big);
            }
        }
        swap(arr, big, R);
        return new int[]{small + 1, big};
    }
}
