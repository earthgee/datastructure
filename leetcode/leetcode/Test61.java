//链表顺序改变 找规律
public class Test61 {
	
	public class ListNode{
		int val;
		ListNode next;
		ListNode(int x){
			val=x;
		}
	}

	public ListNode rotateRight(ListNode head, int k) {
        if(head==null||k==0) return head;
         
        ListNode last=head;
        int length=1;
        while(last.next!=null){
        	last=last.next;
        	length++;
        }
        k=k%length;
        
        ListNode fast=head;
        ListNode slow=head;
        for(int i=0;i<k;i++){
        	fast=fast.next;
        }
        while(fast.next!=null){
        	fast=fast.next;
        	slow=slow.next;
        }
        fast.next=head;
        head=slow.next;
        slow.next=null;
        return head;
    }
	
}
