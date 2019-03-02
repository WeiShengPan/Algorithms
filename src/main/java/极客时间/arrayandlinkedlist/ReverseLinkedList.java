package 极客时间.arrayandlinkedlist;

/**
 * leetcode-206
 * 反转链表
 */
public class ReverseLinkedList {

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode next;

        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }

}
