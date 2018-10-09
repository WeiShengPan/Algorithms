package doublepointer;

/**
 * 验证回文字符串 Ⅱ
 * <p>
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * 注意:
 * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 *
 * @author panws
 * @since 2018-09-29
 */
public class ValidPalindrome {

	public static void main(String[] args) {
		System.out.println(validPalindrome("abcba"));
		System.out.println(validPalindrome("abcbda"));
		System.out.println(validPalindrome("abcbdda"));
	}

	private static boolean validPalindrome(String s) {

		int low = -1;
		int high = s.length();

		while (++low < --high) {
			if (s.charAt(low) != s.charAt(high)) {
				return isPalindrome(s, low, high - 1) || isPalindrome(s, low + 1, high);
			}
		}
		return true;
	}

	private static boolean isPalindrome(String s, int low, int high) {
		while (low < high) {
			if (s.charAt(low++) != s.charAt(high--)) {
				return false;
			}
		}
		return true;
	}
}
