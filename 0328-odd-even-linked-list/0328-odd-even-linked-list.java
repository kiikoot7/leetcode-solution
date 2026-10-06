class Solution {
    public ListNode oddEvenList(ListNode head) {
     if(head==null || head.next==null)
     return head;
     ArrayList <ListNode> odd=new ArrayList<>();
       ArrayList <ListNode> even=new ArrayList<>();
       ListNode temp = head;
       int pos =1 ;
       while(temp != null){
        if(pos%2==1)
          odd.add(temp);
          else 
          even.add(temp);
          temp = temp.next;
          pos++;
       }
       ArrayList <ListNode> list=new ArrayList <>();
       list.addAll(odd);
    list.addAll(even);
    for(int i = 0;i<list.size()-1;i++)
    list.get(i).next=list.get(i+1);
    list.get(list.size()-1).next=null;
    return list.get(0);
    }
}