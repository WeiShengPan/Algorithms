package sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 用最少数量的箭引爆气球
 * <p>
 * 在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。由于它是水平的，所以y坐标并不重
 * 要，因此只要知道开始和结束的x坐标就足够了。开始坐标总是小于结束坐标。平面内最多存在104个气球。
 * <p>
 * 一支弓箭可以沿着x轴从不同点完全垂直地射出。在坐标x处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足
 * xstart ≤ x ≤ xend，则该气球会被引爆。可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。我们想找到使得所有气
 * 球全部被引爆，所需的弓箭的最小数量。
 *
 * @author panws
 * @since 2018-10-12
 */
public class MinimumNumberOfArrowsToBurstBalloons {

	public static void main(String[] args) {

		int[][] points = { { 10, 16 }, { 2, 8 }, { 1, 6 }, { 7, 12 } };

		System.out.println(findMinArrowShots(points));

	}

	/**
	 * 思想与{@link NonOverlappingIntervals} 类似，计算不重叠的个数即可
	 *
	 * @param points
	 * @return
	 */
	private static int findMinArrowShots(int[][] points) {

		if (points.length == 0) {
			return 0;
		}

		Arrays.sort(points, Comparator.comparing(o -> o[1]));

		int cnt = 1;
		int end = points[0][1];
		for (int i = 1; i < points.length; i++) {
			if (points[i][0] <= end) {
				continue;
			}
			cnt++;
			end = points[i][1];
		}

		return cnt;
	}

}