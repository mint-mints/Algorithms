package array;

import javax.swing.*;
import java.util.Arrays;

public class Q27_RemoveElement {

    public int removeElement(int[] nums, int val) {
        int left = 0, right = nums.length;
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right --;
            } else {
                left ++;
            }
        }
        return left;
    }

    public int removeElement2(int[] nums, int val) {
        if (nums == null || nums.length ==0) {
            return 0;
        }
        int p = nums.length;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == val &&  p == nums.length) {
                p = i;
            }
            else if (nums[i] != val && p != nums.length) {
                nums[p] = nums[i];
                p++;
            }

        }
        return p;
    }

    public static void main(String[] args){
        int[] nums = new int[]{2};
        Q27_RemoveElement q27 = new Q27_RemoveElement();
        q27.removeElement(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}
