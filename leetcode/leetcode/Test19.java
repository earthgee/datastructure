
//删除链表倒数元素，two pointer
public class Test19 {
	
	public static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
	 }
	
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy=new ListNode(-1);
		dummy.next=head;
		ListNode first=dummy,second=dummy;
		
		while(n-->0){
			first=first.next;
		}
		
		while(first.next!=null){
			first=first.next;
			second=second.next;
		}
		
		second.next=second.next.next;
		return dummy.next;
    }
	
	public static void main(String[] args) {
		ListNode listNode=new ListNode(1);
		removeNthFromEnd(listNode, 1);
	}
	
}











