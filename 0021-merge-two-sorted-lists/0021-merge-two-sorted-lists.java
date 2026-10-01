class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ArrayList <Integer> a = new ArrayList <> ();
        while(list1 != null){
            a.add (list1.val);
            list1=list1.next;
       }
       while(list2 != null){
            a.add (list2.val);
            list2=list2.next;
       }
       Collections.sort(a);
       ListNode dummy = new ListNode();
       ListNode curr = dummy;
       for(int x: a){
        curr.next=new ListNode(x);
        curr=curr.next;
       }
       return dummy.next;
    }
}