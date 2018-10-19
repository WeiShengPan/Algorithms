package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 根据身高重建队列
 * <p>
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
 * <p>
 * 注意：
 * 总人数少于1100人。
 * <p>
 * 输入: [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * 输出: [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 *
 * @author panws
 * @since 2018-10-12
 */
public class QueueReconstructionByHeight {

	public static void main(String[] args) {

		int[][] people = { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } };
		int[][] reconstructedQueue = reconstructQueue(people);

		for (int[] p : reconstructedQueue) {
			System.out.printf("[%d,%d] ", p[0], p[1]);
		}

	}

	/**
	 * 为了使插入操作不影响后续的操作，身高较高的学生应该先做插入操作，否则身高较小的学生原先正确插入的第 k 个位置可能会变成第 k+1 个位置。
	 * <p>
	 * 身高降序、k 值升序，然后按排好序的顺序插入队列的第 k 个位置中。
	 *
	 * @param people
	 * @return
	 */
	private static int[][] reconstructQueue(int[][] people) {

		if (people == null || people.length == 0 || people[0].length == 0) {
			return new int[0][0];
		}

		Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

		List<int[]> queue = new ArrayList<>();
		for (int[] p : people) {
			//将指定的元素插入到列表中指定的位置(可选操作)。将当前位于该位置的元素(如果有的话)和任何后续元素向右移动
			//(向索引中添加一个元素)。
			queue.add(p[1], p);
		}

		return queue.toArray(new int[queue.size()][]);
	}
}
