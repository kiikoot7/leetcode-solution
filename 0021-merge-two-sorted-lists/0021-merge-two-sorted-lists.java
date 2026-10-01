class Solution {
    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
         while(a!= null && b!= null){
            if(a.val<b.val){
                cur.next=a;
                a=a.next;
            }
            else{
                cur.next= b;
                b=b.next;
            }
            cur=cur.next;
         }
        cur.next = (a != null) ? a : b ;

        return dummy.next;        
    }
}