package sort;

import java.util.Arrays;

/**
 * 思想：贪心思想
 * 保证每次操作都是局部最优，并且最后得到的结果是全局最优
 * <p>
 * <p>
 * 分配饼干
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。对每个孩子 i ，都有一个胃口值 gi ，
 * 这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j ，都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个饼干 j 分配给
 * 孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 * <p>
 * 注意：
 * 你可以假设胃口值为正。
 * 一个小朋友最多只能拥有一块饼干。
 * <p>
 * 输入: [1,2], [1,2,3]
 * 输出: 2
 * 解释:
 * 你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
 * 你拥有的饼干数量和尺寸都足以让所有孩子满足。
 * 所以你应该输出2.
 *
 * @author panws
 * @since 2018-10-12
 */
public class AssignCookies {

	public static void main(String[] args) {

		int[] g = { 1, 2, 3 };
		int[] s = { 1, 2 };

		System.out.println(findContentChildren(g, s));

	}

	/**
	 * 给一个孩子的饼干应当尽量小又能满足该孩子，这样大饼干就能拿来给满足度比较大的孩子。因为最小的孩子最容易得到满足，所以先满
	 * 足最小的孩子。
	 * <p>
	 * 证明：假设在某次选择中，贪心策略选择给当前满足度最小的孩子分配第 m 个饼干，第 m 个饼干为可以满足该孩子的最小饼干。假设存
	 * 在一种最优策略，给该孩子分配第 n 个饼干，并且 m < n。我们可以发现，经过这一轮分配，贪心策略分配后剩下的饼干一定有一个比
	 * 最优策略来得大。因此在后续的分配中，贪心策略一定能满足更多的孩子。也就是说不存在比贪心策略更优的策略，即贪心策略就是最优
	 * 策略。
	 *
	 * @param g
	 * @param s
	 * @return
	 */
	private static int findContentChildren(int[] g, int[] s) {

		Arrays.sort(g);
		Arrays.sort(s);

		int gi = 0;
		int si = 0;

		while (gi < g.length && si < s.length) {
			if (g[gi] <= s[si]) {
				gi++;
			}
			si++;
		}

		return gi;
	}
}
