class Solution {
    public ListNode swapPairs(ListNode head) {

        ListNode prev = null;
        ListNode cur = head;

        while (cur != null && cur.next != null) {

            ListNode next = cur.next;

            cur.next = next.next;
            next.next = cur;

            if (prev == null)
                head = next;
            else
                prev.next = next;                                
            prev = cur;
            cur = cur.next;
        }

        return head;
    }
}