class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int n = 0;
        ListNode temp = head;

        while (temp != null) {
            n++;
            temp = temp.next;
        }

        k = k % n;

        for (int i = 0; i < k; i++) {
            ListNode prev = head;

            while (prev.next.next != null) {
                prev = prev.next;
            }

            ListNode last = prev.next;
            prev.next = null;

            last.next = head;
            head = last;
        }

        return head;
    }
}