package sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 根据字符出现频率排序
 * <p>
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 *
 * @author panws
 * @since 2018-10-10
 */
public class SortCharactersByFrequency {

	public static void main(String[] args) {

		System.out.println(frequencySort("tree"));
		System.out.println(frequencySort("cccaaa"));
		System.out.println(frequencySort("Aabb"));
	}

	/**
	 * 桶排序 思想同{@link TopKFrequentElements}
	 *
	 * @param s
	 * @return
	 */
	public static String frequencySort(String s) {

		Map<Character, Integer> frequencyMap = new HashMap<>();
		for (char c : s.toCharArray()) {
			frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
		}

		List<Character>[] buckets = new ArrayList[s.length() + 1];
		for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
			Integer frequency = entry.getValue();
			if (buckets[frequency] == null) {
				buckets[frequency] = new ArrayList<>();
			}
			buckets[frequency].add(entry.getKey());
		}

		StringBuilder stringBuilder = new StringBuilder();
		for (int i = buckets.length - 1; i >= 0; i--) {
			if (buckets[i] == null) {
				continue;
			}
			for (char c : buckets[i]) {
				for (int j = 0; j < i; j++) {
					stringBuilder.append(c);
				}
			}
		}
		return stringBuilder.toString();
	}
}
