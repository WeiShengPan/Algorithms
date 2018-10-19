package sort;

import java.util.ArrayList;
import java.util.List;

/**
 * 划分字母区间
 * <p>
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
 * <p>
 * 注意:
 * S的长度在[1, 500]之间。
 * S只包含小写字母'a'到'z'。
 * <p>
 * 输入: S = "ababcbacadefegdehijhklij"
 * 输出: [9,7,8]
 * 解释:
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 *
 * @author panws
 * @since 2018-10-15
 */
public class PartitionLabels {

	public static void main(String[] args) {

		List<Integer> partitions = partitionLabels("ababcbacadefegdehijhklij");

		for (Integer partition : partitions) {
			System.out.print(partition + " ");
		}

	}

	private static List<Integer> partitionLabels(String S) {

		//计算字符串中每个字符最后出现的位置
		int[] lastIndexOfChar = new int[26];
		for (int i = 0; i < S.length(); i++) {
			lastIndexOfChar[char2Index(S.charAt(i))] = i;
		}

		List<Integer> partitions = new ArrayList<>();
		int firstIndex = 0;
		while (firstIndex < S.length()) {
			int lastIndex = firstIndex;
			for (int i = firstIndex; i < S.length() && i <= lastIndex; i++) {
				int index = lastIndexOfChar[char2Index(S.charAt(i))];
				if (index > lastIndex) {
					lastIndex = index;
				}
			}
			partitions.add(lastIndex - firstIndex + 1);
			firstIndex = lastIndex + 1;
		}

		return partitions;
	}

	private static int char2Index(char c) {
		return c - 'a';
	}

}
