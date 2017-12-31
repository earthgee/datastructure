
public class Test2 {

	public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	}
	
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	ListNode head=new ListNode(-1);
    	ListNode index=head;
    	int carry=0;
    	while(l1!=null||l2!=null){
    		int sum=0;
    		if(l1!=null) { sum+=l1.val;l1=l1.next;  }
    		if(l2!=null) { sum+=l2.val;l2=l2.next;  }
    		sum+=carry;
    		carry=sum/10;
    		sum=sum%10;
    		ListNode newNode=new ListNode(sum);
    		index.next=newNode;
    		index=index.next;
    	}
    	return head.next;
    }
	
}
