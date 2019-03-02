package 极客时间.arrayandlinkedlist;

/**
 * leetcode-24
 * 两两交换链表中的节点
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = new ListNode(0);
        ListNode a = head;
        ListNode next;

        head = a.next;

        while (a != null && a.next != null) {
            prev.next = a.next;
            next = a.next.next;
            a.next.next = a;
            a.next = next;

            prev = a;
            a = next;

        }
        return head;
    }
}
