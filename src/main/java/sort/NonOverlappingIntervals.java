package sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 无重叠区间
 * <p>
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 * 注意:
 * 1、可以认为区间的终点总是大于它的起点。
 * 2、区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 *
 * @author panws
 * @since 2018-10-12
 */
public class NonOverlappingIntervals {

	public static void main(String[] args) {

		Interval[] intervals = { new Interval(1, 2), new Interval(2, 3), new Interval(3, 4), new Interval(1, 3) };

		System.out.println(eraseOverlapIntervals(intervals));

	}

	/**
	 * 先排序，然后将区间start与前一个end比较，小于end说明重叠需要去除
	 * <p>
	 * 在每次选择中，区间的结尾最为重要，选择的区间结尾越小，留给后面的区间的空间越大，那么后面能够选择的区间个数也就越大。
	 * <p>
	 * 按区间的结尾进行排序，每次选择结尾最小，并且和前一个区间不重叠的区间。
	 *
	 * @param intervals
	 * @return
	 */
	private static int eraseOverlapIntervals(Interval[] intervals) {

		if (intervals.length == 0) {
			return 0;
		}

		//使用lambda表达式创建Comparator会导致算法运行时间过长，如果注重运行时间，使用内部类创建Comparator
		Arrays.sort(intervals, Comparator.comparing(o -> o.end));

		int cnt = 0;
		int end = intervals[0].end;

		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i].start < end) {
				cnt++;
			} else {
				end = intervals[i].end;
			}
		}

		return cnt;
	}

	private static class Interval {
		int start;
		int end;

		private Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
}
