package hashmap;

public class Code02_BitMap {

    public static void main(String[] args) {
        // a: 32 bit
        int a = 0;

        // 32 bit * 10 = 320 bit
        int[] arr = new int[10];

        int i = 178;
        int numIndex = i / 32;
        int bitIndex = i % 32;
        // 拿到第178位的状态
        int s = ((arr[numIndex] >> (bitIndex)) & 1);
        // 把第178位的状态改为1
        arr[numIndex] = arr[numIndex] | (1 << bitIndex);
        // 把第178位的状态改为0
        arr[numIndex] = arr[numIndex] & (~ (1 << bitIndex));

        // bit: 0 / 1
        int bit = (arr[i / 32] >> (i % 32)) & 1;
    }

}
