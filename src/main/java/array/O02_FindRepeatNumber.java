package array;

public class O02_FindRepeatNumber {
    /**
     * 请找出数组中任意一个重复的数字。
     * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内.
     */

    public int findRepeatNumber(int[] nums) {
        int n = nums.length;
        int[] record = new int[n];
        for (int num :nums) {
            if (record[num] == 1) {
                return num;
            } else {
                record[num] = 1;
            }
        }
        return nums[0];
    }
}
