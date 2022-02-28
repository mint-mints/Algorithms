import java.util.Arrays;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
import sorts.MergeSort;

import javax.swing.*;

public class SortTest {
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];      // 长度随机
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) ((maxValue + 1) * Math.random());
        }
        return arr;
    }

    // for test
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    public  static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        float f = 1 / 10;
        System.out.println(f);
        int testTime = 50000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = new int[]{7, 5, 6, 4};
//            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            MergeSort.mergeSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                System.out.println("arr1: " + Arrays.toString(arr1));
                System.out.println("arr2: " + Arrays.toString(arr2));
                succeed = false;
                break;
            }

            // 测试逆序对
            int[] arr3 = new int[]{7, 5, 6, 4};
            int res = MergeSort.reversePairs(arr3);
            System.out.println(res);
            System.out.println("arr3: " + Arrays.toString(arr3));
        }
    }
}
