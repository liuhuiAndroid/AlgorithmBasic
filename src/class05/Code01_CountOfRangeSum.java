package class05;

/**
 * 归并排序补充题目（难）
 * LeetCode地址：https://leetcode-cn.com/problems/count-of-range-sum/
 * 给你一个整数数组 nums 以及两个整数 lower 和 upper 。
 * 求数组中，值位于范围 [lower, upper] （包含 lower 和 upper）之内的 区间和的个数 。
 * 区间和 S(i, j) 表示在 nums 中，位置从 i 到 j 的元素之和，包含 i 和 j (i ≤ j)。
 * <p>
 * sum[i,j] = arr[0,j] - arr[0,i-1]
 * arr[i,j] -> sum[i,j]
 * 暴力递归时间复杂度O(n3)，前缀和时间复杂度O(n2)，归并排序时间复杂度O(N*logN)
 * 必须以position=0结尾的子数组a个
 * 必须以position=1结尾的子数组b个
 * 必须以position=2结尾的子数组c个
 * 求每个位置结尾的达标数量，结果为：a+b+c
 * <p>
 * 如果sum[i,j]在[lower,upper]上
 * 那么sum[0,j]-sum[0,i-1]在[lower,upper]上
 * 如果sum[0,j]为x，目标为[lower,upper]
 * 那么sum[0,i-1]目标为[x-upper,x-lower]
 * <p>
 * 求必须以j位置结尾的子数组有多少个在[lower,upper]范围上
 * 等同于，求i之前的所有前缀和中，有多少个前缀和在[x-upper,x-lower]上
 * <p>
 * merge sort，右组每一个数，左组有多少个数落在[x-upper,x-lower]上
 */
public class Code01_CountOfRangeSum {

    public static int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        long[] sum = new long[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        return process(sum, 0, sum.length - 1, lower, upper);
    }

    // 在原始的arr[L,R]中，有多少个子数组累加和在[lower,upper]范围上
    public static int process(long[] sum, int L, int R, int lower, int upper) {
        if (L == R) {
            return sum[L] >= lower && sum[L] <= upper ? 1 : 0;
        }
        int M = L + ((R - L) >> 1);
        return process(sum, L, M, lower, upper) + process(sum, M + 1, R, lower, upper) + merge(sum, L, M, R, lower, upper);
    }

    public static int merge(long[] arr, int L, int M, int R, int lower, int upper) {
        int ans = 0;
        int windowL = L;
        int windowR = L;
        // [windowL, windowR)
        for (int i = M + 1; i <= R; i++) {
            long min = arr[i] - upper;
            long max = arr[i] - lower;
            while (windowR <= M && arr[windowR] <= max) {
                windowR++;
            }
            while (windowL <= M && arr[windowL] < min) {
                windowL++;
            }
            ans += windowR - windowL;
        }
        // 以下是经典的merge过程
        long[] help = new long[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
        return ans;
    }

}
