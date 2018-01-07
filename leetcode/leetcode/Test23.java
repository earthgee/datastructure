import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

//将n个有序列表合并成一个
public class Test23 {

	public static class ListNode {
		     int val;
		     ListNode next;
		     ListNode(int x) { val = x; }
	}
	
	//多指针遍历
	public static ListNode mergeKLists(ListNode[] lists) {
		if(lists==null||lists.length==0){
			return null;
		}
		
		ListNode dummy=new ListNode(-1);
		ListNode[] prevs=new ListNode[lists.length];
		for(int index=0;index<lists.length;index++){
			prevs[index]=lists[index];
		}
		ListNode curr=dummy;
		
		for(;;){
			int nextMin=findMin(prevs);
			if(nextMin==-1){
				break;
			}else{
				curr.next=prevs[nextMin];
				prevs[nextMin]=prevs[nextMin].next;
				curr=curr.next;
			}
		}
		
		return dummy.next;
    }
	
	//从n个里选一个最小的 
	private static int findMin(ListNode[] nodes){
		int min=Integer.MAX_VALUE;
		int minIndex=-1;
		
		for(int index=0;index<nodes.length;index++){
			ListNode node=nodes[index];
			if(node==null){
				continue;
			}
			
			if(node.val<min){
				min=node.val;
				minIndex=index;
			}
		}
		
		if(minIndex==-1){
			return -1;
		}else{
			return minIndex;
		}
	}
	
	//上面第一种方法超时，需要降低时间复杂度,可以将每次对n个元素比较用一个优先队列维护起来，时间复杂度降低为logn
	public ListNode mergeKLists1(ListNode[] lists){
		if(lists==null||lists.length==0){
			return null;
		}
		
		PriorityQueue<ListNode> priorityQueue=new PriorityQueue<ListNode>(new Comparator<ListNode>() {

			@Override
			public int compare(ListNode o1, ListNode o2) {
				return o1.val-o2.val;
			}
			
		});
		
		ListNode dummy=new ListNode(-1);
		for(int index=0;index<lists.length;index++){
			if(lists[index]!=null){
				priorityQueue.offer(lists[index]);
			}
		}
		ListNode curr=dummy;
		
		for(;;){
			ListNode nextMin=findMin2(priorityQueue);
			if(nextMin==null){
				break;
			}else{
				curr.next=nextMin;
				if(nextMin.next!=null){
					priorityQueue.offer(nextMin.next);
				}
				curr=curr.next;
			}
		}
		
		return dummy.next;
	}
	
	private ListNode findMin2(PriorityQueue<ListNode> queue){
		if(queue.isEmpty()){
			return null;
		}else{
			return queue.poll();
		}
	}
	
	//也可以分治，也可以将复杂度降低为logn
	
	
	public static void main(String[] args) {
		ListNode node=new ListNode(1);
		ListNode[] nodes=new ListNode[1];
		nodes[0]=node;
		mergeKLists(nodes);
	}
	
}
