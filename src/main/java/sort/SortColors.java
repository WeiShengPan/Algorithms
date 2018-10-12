package sort;

/**
 * 思想：荷兰国旗问题
 * 荷兰国旗包含三种颜色：红、白、蓝。
 * 有三种颜色的球，算法的目标是将这三种球按颜色顺序正确地排列。
 * 它其实是三向切分快速排序的一种变种，在三向切分快速排序中，每次切分都将数组分成三个区间：小于切分元素、等于切分元素、大于切分元素，而该算法是将数组分成三个区间：等于红色、等于白色、等于蓝色。
 * <p>
 * <p>
 * 颜色分类
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * @author panws
 * @since 2018-10-11
 */
public class SortColors {

	public static void main(String[] args) {
		int[] colors = { 2, 0, 2, 1, 1, 0 };
		sortColors(colors);
		for (int color : colors) {
			System.out.print(color + " ");
		}
	}

	private static void sortColors(int[] colors) {

		int zero = -1;
		int one = 0;
		int two = colors.length;

		while (one < two) {
			//与前面交换
			if (colors[one] == 0) {
				swap(colors, ++zero, one++);
			}
			//与后面交换
			else if (colors[one] == 2) {
				swap(colors, one, --two);
			}
			//不需要交换
			else {
				one++;
			}
		}
	}

	private static void swap(int[] colors, int i, int j) {
		int t = colors[i];
		colors[i] = colors[j];
		colors[j] = t;
	}
}
