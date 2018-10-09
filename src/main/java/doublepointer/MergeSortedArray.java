package doublepointer;

/**
 * 合并两个有序数组
 * <p>
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 * @author panws
 * @since 2018-09-29
 */
public class MergeSortedArray {

	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 3, 4, 0, 0, 0 };
		int m = 4;
		int[] nums2 = { 2, 5, 6 };
		int n = 3;

		merge(nums1, m, nums2, n);
		for (int num : nums1) {
			System.out.print(num + ' ');
		}
	}

	private static void merge(int[] nums1, int m, int[] nums2, int n) {

		int index1 = m - 1;
		int index2 = n - 1;
		int indexMerge = m + n - 1;

		while (index1 >= 0 || index2 >= 0) {
			if (index1 < 0) {
				//nums1已合并完，合并剩余nums2元素
				nums1[indexMerge--] = nums2[index2--];
			} else if (index2 < 0) {
				//nums2已合并完，合并剩余nums1元素
				nums1[indexMerge--] = nums1[index1--];
			} else if (nums1[index1] > nums2[index2]) {
				//nums1的元素比nums2大，则nums2不移动，拷贝nums1
				nums1[indexMerge--] = nums1[index1--];
			} else {
				//nums2的元素比nums1大，则nums1不移动，拷贝nums2
				nums1[indexMerge--] = nums2[index2--];
			}
		}

	}
}
