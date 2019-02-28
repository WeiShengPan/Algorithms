package sort.impl;

/**
 * 冒泡排序
 * ② 算法描述
 * 1）比较相邻的元素。如果前一个比后一个大，就交换它们两个；
 * 2）对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
 * 3）针对所有的元素重复以上的步骤，除了最后一个；
 * 4）重复步骤1~3，直到排序完成。为了优化算法，可以设立一个布尔标识，每趟排序开始前设为false，如果该趟排序发生了交换就置为true，如果一趟排序结束标识仍为false表示该趟排序没有发生交换，即数组已经有序，可以提前结束排序。
 * <p>
 * ⑤ 时间复杂度
 * 冒泡排序平均时间复杂度为O(n2)，最好时间复杂度为O(n)，最坏时间复杂度为O(n2)。
 * 最好情况：如果待排序元素本来是正序的，那么一趟冒泡排序就可以完成排序工作，比较和移动元素的次数分别是 (n - 1) 和 0，因此最好情况的时间复杂度为O(n)。
 * 最坏情况：如果待排序元素本来是逆序的，需要进行 (n - 1) 趟排序，所需比较和移动次数分别为 n * (n - 1) / 2和 3 * n * (n-1) / 2。因此最坏情况下的时间复杂度为O(n2)。
 * <p>
 * ⑥ 空间复杂度
 * 冒泡排序使用了常数空间，空间复杂度为O(1)
 * <p>
 * ⑦ 稳定性
 * 当 array[j] == array[j+1] 的时候，我们不交换 array[i] 和 array[j]，所以冒泡排序是稳定的。
 *
 * @author panws
 * @since 2019-02-28
 */
public class BubbleSort {

	public static void main(String[] args) {
		int[] rst1 = bubbleSort(new int[] { 1, 4, 2, 7, 5, 1, 10, 9 });
		int[] rst2 = bubbleSort(new int[] { 10, 8, 7, 9, 1, 4, 5, 5, 10 });
		ArrPrintUtil.print(rst1);
		ArrPrintUtil.print(rst2);
	}

	private static int[] bubbleSort(int[] arr) {
		if (arr.length == 0) {
			return arr;
		}
		for (int i = 0; i < arr.length; i++) {
			// 如果未发生交换，说明数组已经有序
			boolean swap = false;
			for (int j = 0; j < arr.length - 1 - i; j++) {

				if (arr[j + 1] < arr[j]) {
					int tmp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = tmp;
					swap = true;
				}
			}
			if (!swap) {
				break;
			}
		}
		return arr;
	}
}
