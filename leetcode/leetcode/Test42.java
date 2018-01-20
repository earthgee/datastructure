import java.util.Stack;

import javax.print.attribute.Size2DSyntax;

//蓄水问题
//暴力解法对每一个索引找出左右最大的边界
//将对于每一个索引左右最大边界缓存起来 优化1
//相对于优化1使用数组缓存 还可以使用栈 栈中存储索引 通过栈找出被圈住的点 优化2 
public class Test42 {

	//优化1
	public int trap(int[] height) {
		if(height==null) return 0;
		
		int ans=0;
		int length=height.length;
		int[] leftMax=new int[length];
		int[] rightMax=new int[length];
		leftMax[0]=height[0];
		for(int i=1;i<length;i++){
			leftMax[i]=Math.max(height[i], leftMax[i-1]);
		}
		rightMax[length-1]=height[length-1];
		for(int i=length-2;i>=0;i--){
			rightMax[i]=Math.max(height[i], rightMax[i+1]);
		}
		
		for(int i=1;i<length-1;i++){
			ans+=Math.min(leftMax[i], rightMax[i])-height[i];
		}
		
		return ans;
	}
	
	//优化2 
	public static int trap2(int[] height){
		int ans=0,current=0;
		Stack<Integer> stack=new Stack<>();
		while(current<height.length){
			while(!stack.isEmpty()&&height[current]>height[stack.peek()]){
				int top=stack.pop();
				if(stack.empty()) break;
				int distance=current-stack.peek()-1;
				int boundHeight=Math.min(height[current], height[stack.peek()])-height[top];
				ans+=distance*boundHeight;
			}
			stack.push(current++);
		}
		return ans;
	}
	
	public static void main(String[] args) {
		int[] nums={4,2,3};
		System.out.println(trap2(nums));
	}
	
}




























