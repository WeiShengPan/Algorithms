package sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 前k个高频元素
 * <p>
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * <p>
 * 说明：
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 *
 * @author panws
 * @since 2018-10-10
 */
public class TopKFrequentElements {

	public static void main(String[] args) {
		int[] nums = { 2, 2, 3, 1, 1, 1 };
		int k = 2;
		System.out.println(topKFrequent(nums, k));
	}

	/**
	 * 桶排序
	 * <p>
	 * 设置若干个桶，每个桶存储出现频率相同的数，并且桶的下标代表桶中数出现的频率，即第 i 个桶中存储的数出现的频率为 i。
	 * 把数都放到桶之后，从后向前遍历桶，最先得到的 k 个数就是出现频率最多的的 k 个数。
	 *
	 * @param nums
	 * @param k
	 * @return
	 */
	private static List<Integer> topKFrequent(int[] nums, int k) {

		Map<Integer, Integer> frequencyForNum = new HashMap<>();

		for (int num : nums) {
			frequencyForNum.put(num, frequencyForNum.getOrDefault(num, 0) + 1);
		}

		List<Integer>[] buckets = new ArrayList[nums.length + 1];

		for (Map.Entry<Integer, Integer> entry : frequencyForNum.entrySet()) {
			int frequency = entry.getValue();
			if (buckets[frequency] == null) {
				buckets[frequency] = new ArrayList<>();
			}
			buckets[frequency].add(entry.getKey());
		}

		List<Integer> topK = new ArrayList<>();
		for (int i = buckets.length - 1; i >= 0 && topK.size() < k; i--) {
			if (buckets[i] != null) {
				topK.addAll(buckets[i]);
			}
		}
		return topK;
	}

}
