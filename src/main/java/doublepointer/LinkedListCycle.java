package doublepointer;

/**
 * 环形链表
 * 给定一个链表，判断链表中是否有环。
 *
 * @author panws
 * @since 2018-10-09
 */
public class LinkedListCycle {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		l1.next = l2;
		l2.next = l3;
		l3.next = l1;
		System.out.println(hasCycle(l1));
	}

	/**
	 * 使用双指针，一个指针每次移动一个节点，一个指针每次移动两个节点，如果存在环，那么这两个指针一定会相遇。
	 *
	 * @param head
	 * @return
	 */
	private static boolean hasCycle(ListNode head) {
		if (head == null) {
			return false;
		}

		ListNode l1 = head;
		ListNode l2 = head.next;

		while (l1 != null && l2 != null && l2.next != null) {
			if (l1 == l2) {
				return true;
			}
			l1 = l1.next;
			l2 = l2.next.next;
		}
		return false;
	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}
