package 极客时间.arrayandlinkedlist;

/**
 * leetcode-141
 * 环形链表
 */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {

        // double pointer 龟兔赛跑

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null && slow != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }

        return false;
    }
}
