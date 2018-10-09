package doublepointer;

/**
 * 平方数之和
 * <p>
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a^2 + b^2 = c。
 *
 * @author panws
 * @since 2018-09-21
 */
public class SumOfSquareNumbers {

	public static void main(String[] args) {

		System.out.println(judgeSquareSum(5));
		System.out.println(judgeSquareSum(10));
		System.out.println(judgeSquareSum(13));

	}

	/**
	 * 使用双指针，一个指向0，一个指向c的被开方数
	 *
	 * @param c
	 * @return
	 */
	private static boolean judgeSquareSum(int c) {
		int low = 0;
		int high = (int) Math.sqrt(c);

		while (low <= high) {
			int powSum = low * low + high * high;

			if (powSum == c) {
				return true;
			}

			if (powSum < c) {
				low++;
			} else {
				high--;
			}
		}

		return false;
	}
}
