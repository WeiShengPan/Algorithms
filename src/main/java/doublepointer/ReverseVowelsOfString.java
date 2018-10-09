package doublepointer;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 反转字符串中的元音字母
 * <p>
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 *
 * @author panws
 * @since 2018-09-21
 */
public class ReverseVowelsOfString {

	private static final HashSet<Character> VOWELS = new HashSet<>(
			Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

	public static void main(String[] args) {

		System.out.println(reverseVowels("leetcode"));

	}

	private static String reverseVowels(String s) {
		int low = 0;
		int high = s.length() - 1;

		char[] result = new char[s.length()];

		while (low <= high) {
			char cLow = s.charAt(low);
			char cHigh = s.charAt(high);

			if (!VOWELS.contains(cLow)) {
				result[low++] = cLow;
			} else if (!VOWELS.contains(cHigh)) {
				result[high--] = cHigh;
			} else {
				// reverse
				result[low++] = cHigh;
				result[high--] = cLow;
			}
		}

		return String.valueOf(result);
	}

}
