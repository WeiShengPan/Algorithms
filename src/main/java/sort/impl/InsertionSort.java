package sort.impl;

/**
 * 插入排序
 * ② 算法描述
 * 一般来说，直接插入排序都采用in-place（原地算法）在数组上实现。具体算法描述如下：
 * 1）从第一个元素开始，该元素可以认为已经被排序；
 * 2）取出下一个元素，在已经排序的元素序列中从后向前扫描；
 * 3）如果该元素（已排序）大于新元素，将该元素移到下一位置；
 * 4）重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
 * 5）将新元素插入到该位置后；
 * 6）重复步骤2~5。
 * ⑤ 时间复杂度
 * 直接插入排序平均时间复杂度为O(n2)，最好时间复杂度为O(n)，最坏时间复杂度为O(n2)。
 * 最好情况：如果待排序元素本来是正序的，比较和移动元素的次数分别是 (n - 1) 和 0，因此最好情况的时间复杂度为O(n)。
 * 最坏情况：如果待排序元素本来是逆序的，需要进行 (n - 1) 趟排序，所需比较和移动次数分别为 n * (n - 1) / 2和 n * (n - 1) / 2。因此最坏情况下的时间复杂度为O(n2)。
 * ⑥ 空间复杂度
 * 直接插入排序使用了常数空间，空间复杂度为O(1)
 * ⑦ 稳定性
 * 直接插入排序是稳定的。
 *
 * @author panws
 * @since 2019-02-28
 */
public class InsertionSort {

	public static void main(String[] args) {
		int[] rst1 = insertionSort(new int[] { 1, 4, 2, 7, 5, 1, 10, 9 });
		int[] rst2 = insertionSort(new int[] { 10, 8, 7, 9, 1, 4, 5, 5, 10 });
		ArrPrintUtil.print(rst1);
		ArrPrintUtil.print(rst2);
	}

	private static int[] insertionSort(int[] arr) {
		if (arr.length == 0) {
			return arr;
		}
		int current;
		for (int i = 0; i < arr.length; i++) {
			current = arr[i];
			int pre = i - 1;
			while (pre >= 0 && current < arr[pre]) {
				arr[pre + 1] = arr[pre];
				pre--;
			}
			arr[pre + 1] = current;
		}
		return arr;
	}
}
