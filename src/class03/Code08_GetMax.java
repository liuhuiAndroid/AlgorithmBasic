package class03;

/**
 * 了解递归
 * Master公式：用于分析递归函数的复杂度
 * 形如 T(N) = a * T(N/b) + O(N^d)的递归函数，可以直接通过Master公式来确定时间复杂度
 * 其中的a、b、d都是常数
 * 如果log(b,a) < d，时间复杂度为：O(N^d)
 * 如果log(b,a) > d，时间复杂度为：O(N^log(b,a))
 * 如果log(b,a) == d，时间复杂度为：O(N^d * logN)
 * 例如GetMax：T(N) = 2 * T(N/2) + O(1): a=2 b=2 d=0，时间复杂度 O(N)
 * 说明此递归行为和for循环的时间复杂度一致
 */
public class Code08_GetMax {

	// 求arr中的最大值
	public static int getMax(int[] arr) {
		return process(arr, 0, arr.length - 1);
	}

	// arr[L..R]范围上求最大值  L ... R   N
	public static int process(int[] arr, int L, int R) {
		// arr[L..R]范围上只有一个数，直接返回，base case
		if (L == R) { 
			return arr[L];
		}
		// L...R 不只一个数
		// mid = (L + R) / 2
		int mid = L + ((R - L) >> 1); // 中点   	1
		int leftMax = process(arr, L, mid);
		int rightMax = process(arr, mid + 1, R);
		return Math.max(leftMax, rightMax);
	}

}
