package sort.impl;

/**
 * 选择排序
 * ② 算法描述
 * n个记录的简单选择排序可经过(n-1)趟简单选择排序得到有序结果。具体算法描述如下：
 * 1）初始状态：无序区为R[1..n]，有序区为空；
 * 2）第i趟排序(i=1,2,3…n-1)开始时，当前有序区和无序区分别为R[1..i-1]和R[i..n]。该趟排序从当前无序区中选出关键字最小的记录 R[k]，将它与无序区的第1个记录R交换，使R[1..i]和R[i+1..n]分别变为记录个数增加1个的新有序区和记录个数减少1个的新无序区；
 * 3）(n-1)趟结束，数组有序化了。
 * <p>
 * ⑤ 时间复杂度
 * 简单选择排序平均时间复杂度为O(n2)，最好时间复杂度为O(n2)，最坏时间复杂度为O(n2)。
 * 最好情况：如果待排序元素本来是正序的，则移动元素次数为 0，但需要进行 n * (n - 1) / 2 次比较。
 * 最坏情况：如果待排序元素中第一个元素最大，其余元素从小到大排列，则仍然需要进行 n * (n - 1) / 2 次比较，且每趟排序都需要移动 3 次元素，即移动元素的次数为3 * (n - 1)次。
 * 需要注意的是，简单选择排序过程中需要进行的比较次数与初始状态下待排序元素的排列情况无关。
 * <p>
 * ⑥ 空间复杂度
 * 简单选择排序使用了常数空间，空间复杂度为O(1)
 * <p>
 * ⑦ 稳定性
 * 简单选择排序不稳定，比如序列 2、4、2、1，我们知道第一趟排序第 1 个元素 2 会和 1 交换，那么原序列中 2 个 2 的相对前后顺序就被破坏了，所以简单选择排序不是一个稳定的排序算法。
 *
 * @author panws
 * @since 2019-02-28
 */
public class SelectionSort {

	public static void main(String[] args) {
		int[] rst1 = selectionSort(new int[] { 1, 4, 2, 7, 5, 1, 10, 9 });
		int[] rst2 = selectionSort(new int[] { 10, 8, 7, 9, 1, 4, 5, 5, 10 });
		ArrPrintUtil.print(rst1);
		ArrPrintUtil.print(rst2);
	}

	private static int[] selectionSort(int[] arr) {
		if (arr.length == 0) {
			return arr;
		}

		for (int i = 0; i < arr.length; i++) {
			int index = i;
			for (int j = i; j < arr.length; j++) {
				if (arr[j] < arr[index]) {
					index = j;
				}
			}
			int tmp = arr[index];
			arr[index] = arr[i];
			arr[i] = tmp;
		}
		return arr;
	}
}
