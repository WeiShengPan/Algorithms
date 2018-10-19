package sort;

/**
 * 判断子序列
 * <p>
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），
 * 而 s 是个短字符串（长度 <=100）。字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新
 * 字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * @author panws
 * @since 2018-10-15
 */
public class IsSubsequence {

	public static void main(String[] args) {
		System.out.println(isSubsequence("abc","ahbgc"));
		System.out.println(isSubsequence("agb","ahbgc"));
	}

	private static boolean isSubsequence(String s, String t) {
		int index = -1;
		for (char c : s.toCharArray()) {
			//从数组指定位置起开始查找，找不到返回-1，说明不是子序列
			index = t.indexOf(c, index + 1);
			if (index == -1) {
				return false;
			}
		}
		return true;
	}
}
