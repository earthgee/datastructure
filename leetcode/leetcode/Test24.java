
//链表两两交换 同倒置链表类似
public class Test24 {

	public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
	
	public ListNode swapPairs(ListNode head) {
		if(head==null) return null;
		
		ListNode dummy=new ListNode(-1);
		ListNode curr=head;
		ListNode index=dummy;
		ListNode prev=curr;
		
		int num=0;
		while(true){
			if(curr==null) break;
			
			prev=curr;
			curr=curr.next;
			prev.next=index.next;
			index.next=prev;
			
			num++;
			if(num==2){
				index=index.next.next;
				num=0;
			}
		}
		
		return dummy.next;
    }
	
}
