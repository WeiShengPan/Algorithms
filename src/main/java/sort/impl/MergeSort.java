package sort.impl;

import java.util.Arrays;

/**
 * 归并排序
 * ② 算法描述
 * 1）把长度为 n 的输入序列分成两个长度为 n / 2 的子序列；
 * 2）对这两个子序列分别采用归并排序；
 * 3）将两个排序好的子序列合并成一个最终的排序序列。
 * <p>
 * ⑤ 时间复杂度
 * 归并排序平均时间复杂度为O(nlogn)，最好时间复杂度为O(nlogn)，最坏时间复杂度为O(nlogn)。
 * 归并排序的形式就是一棵二叉树，它需要遍历的次数就是二叉树的深度，而根据完全二叉树的可以得出它在任何情况下时间复杂度均是O(nlogn)。
 * <p>
 * ⑥ 空间复杂度
 * 归并排序空间复杂度为O(n)
 * <p>
 * ⑦ 稳定性
 * 归并排序是稳定的。
 *
 * @author panws
 * @since 2019-02-28
 */
public class MergeSort {

	public static void main(String[] args) {
		int[] rst1 = mergeSort(new int[] { 1, 4, 2, 7, 5, 1, 10, 9 });
		int[] rst2 = mergeSort(new int[] { 10, 8, 7, 9, 1, 4, 5, 5, 10 });
		ArrPrintUtil.print(rst1);
		ArrPrintUtil.print(rst2);
	}

	private static int[] mergeSort(int[] arr) {
		if (arr.length < 2) {
			return arr;
		}

		int middle=arr.length/2;
		int[] left = Arrays.copyOfRange(arr, 0, middle);
		int[] right = Arrays.copyOfRange(arr, middle, arr.length);

		return merge(mergeSort(left), mergeSort(right));
	}

	private static int[] merge(int[] left, int[] right) {
		int[] rst = new int[left.length + right.length];

		int l = 0;
		int r = 0;
		int index = 0;

		while (l < left.length || r < right.length) {
			if (l >= left.length) {
				rst[index++] = right[r++];
			} else if (r >= right.length) {
				rst[index++] = left[l++];
			} else if (left[l] > right[r]) {
				rst[index++] = right[r++];
			} else {
				rst[index++] = left[l++];
			}
		}
		return rst;
	}
}
