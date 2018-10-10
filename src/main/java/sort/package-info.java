/**
 * 排序
 * <p>
 * 快速选择
 * 用于求解 Kth Element 问题，使用快速排序的 partition() 进行实现。
 * 需要先打乱数组，否则最坏情况下时间复杂度为 O(N2)。
 * <p>
 * 堆排序
 * 用于求解 TopK Elements 问题，通过维护一个大小为 K 的堆，堆中的元素就是 TopK Elements。
 * <p>
 * 堆排序也可以用于求解 Kth Element 问题，堆顶元素就是 Kth Element。
 * 快速选择也可以求解 TopK Elements 问题，因为找到 Kth Element 之后，再遍历一次数组，所有小于等于 Kth Element 的元素都是 TopK Elements。
 *
 * @author panws
 * @since 2018-10-09
 */
package sort;