package dp;

public class Code04_CardsInLine {
    /**
     * 纸牌游戏。
     * 玩家A和玩家B依次拿走每张纸牌，规定玩家A先拿，玩家B后拿，但是每个玩家每次只能拿走最左或最右的纸牌，玩家A和玩家B都绝顶聪明。请返回最后获胜者的分数。
     */

    public static int win1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        return Math.max(first(arr, 0, arr.length - 1),
                second(arr, 0, arr.length - 1));
    }

    // 先手拿牌
    public static int first(int[] arr, int i, int j) {
        if (i == j) {
            return arr[i];
        }
        return Math.max(arr[i] + second(arr, i +1, j),
                arr[j] + second(arr, i, j - 1));
    }

    // 后手拿牌
    public static int second(int[] arr, int i, int j) {
        if (i == j) {
            return 0;
        }
        // 因为是对方决定的，所以是最小值
        return Math.min(first(arr, i + 1, j),
               first(arr, i, j - 1));
    }

}
