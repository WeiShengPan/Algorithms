package doublepointer;

import java.util.ArrayList;
import java.util.List;

/**
 * 通过删除字母匹配到字典里最长单词
 * <p>
 * 给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。如果答案不止一个，
 * 返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。
 * <p>
 * 输入:
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 * 输出:
 * "apple"
 * <p>
 * 说明:
 * 所有输入的字符串只包含小写字母。
 * 字典的大小不会超过 1000。
 * 所有输入的字符串长度不会超过 1000。
 *
 * @author panws
 * @since 2018-10-09
 */
public class LongestWordInDictionaryThroughDeleting {

	public static void main(String[] args) {

		String s = "abpcplea";

		List<String> d = new ArrayList<>();
		d.add("ale");
		d.add("apple");
		d.add("monkey");
		d.add("plea");

		System.out.println(findLongestWord(s, d));
	}

	private static String findLongestWord(String s, List<String> d) {

		String longest = "";

		for (String target : d) {
			int l1 = longest.length();
			int l2 = target.length();
			if (l1 > l2 || (l1 == l2 && longest.compareTo(target) < 0)) {
				continue;
			}
			if (isValid(s, target)) {
				longest = target;
			}
		}

		return longest;
	}

	private static boolean isValid(String s, String target) {
		int i = 0;
		int j = 0;
		while (i < s.length() && j < target.length()) {
			if (s.charAt(i) == target.charAt(j)) {
				j++;
			}
			i++;
		}
		return j == target.length();
	}
}
