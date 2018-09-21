package doublepointer;

/**
 * 两数之和
 * <p>
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * 说明:
 * 1. 返回的下标值（index1 和 index2）不是从零开始的。
 * 2. 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 *
 * @author panws
 * @since 2018-09-21
 */
public class TwoSum {

	public static void main(String[] args) {

		int[] numbers = { 2, 7, 11, 15 };
		int target = 9;

		int[] results = twoSum(numbers, target);

		for (int result : results) {
			System.out.print(result + " ");
		}
	}

	/**
	 * 使用双指针，一个指针指向值较小的元素，一个指针指向值较大的元素。指向较小元素的指针从头向尾遍历，指向较大元素的指针从尾向头遍历。
	 * <p>
	 * 如果两个指针指向元素的和 sum == target，那么得到要求的结果；
	 * 如果 sum > target，移动较大的元素，使 sum 变小一些；
	 * 如果 sum < target，移动较小的元素，使 sum 变大一些。
	 *
	 * @param numbers
	 * @param target
	 * @return
	 */
	private static int[] twoSum(int[] numbers, int target) {

		int low = 0;
		int high = numbers.length - 1;

		while (low < high) {
			int sum = numbers[low] + numbers[high];
			if (sum == target) {
				return new int[] { low + 1, high + 1 };
			}

			if (sum < target) {
				low++;
			} else {
				high--;
			}
		}

		return numbers;
	}
}
