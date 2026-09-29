class Solution {
    public ListNode middleNode(ListNode head) {
          int  length= 0 ;
          ListNode temp = head;
          while(temp != null){
            length ++;
            temp = temp.next;
          }
           temp = head;
  for( int i = 0; i<length /2 ; i++){
    temp = temp.next;
  }
  return temp;
              }
}