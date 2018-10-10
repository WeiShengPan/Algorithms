package sort;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 数组中的第K个最大元素
 * <p>
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 说明:
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 *
 * @author panws
 * @since 2018-10-09
 */
public class KthLargestElementInArray {

	public static void main(String[] args) {
		int[] nums = { 5, 1, 3, 2, 9, 6, 4, 8, 7 };
		int k = 6;
		System.out.println(findByQuicksort(nums, k));
		System.out.println(findByHeapsort(nums, k));

	}

	private static int findByQuicksort(int[] nums, int k) {
		Arrays.sort(nums);
		return nums[nums.length - k];
	}

	private static int findByHeapsort(int[] nums, int k) {
		//小顶堆
		PriorityQueue<Integer> queue = new PriorityQueue<>();

		for (int num : nums) {
			queue.add(num);
			if (queue.size() > k) {
				queue.poll();
			}
		}

		return queue.peek();
	}
}
