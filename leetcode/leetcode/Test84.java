import java.util.Stack;

public class Test84 {

	//on^2解法
	public static int largestRectangleArea(int[] heights) {
		if(heights.length==0){
			return 0;
		}
        int length=heights.length;
        int largets=Integer.MIN_VALUE;
        for(int i=0;i<length;i++){
        	int minLength=Integer.MAX_VALUE;
        	int j=i;
        	for(;j<length;j++){
        		if(heights[j]<minLength){
        			minLength=heights[j];
        		}
        		int currentMax=(j-i+1)*minLength;
            	if(currentMax>largets){
            		largets=currentMax;
            	}
        	}
        }
        return largets;
    }
	
	//维护递增栈 on解法
	public int largestRectangleArea2(int[] heights){
		Stack<Integer> stack=new Stack<>();
		int res=Integer.MIN_VALUE;
		for(int i=0;i<=heights.length;i++){
			int current;
			if(i==heights.length){
				current=0;
			}else{
				current=heights[i];
			}
			
			if(stack.isEmpty()||heights[stack.peek()]<current){
				stack.push(i);
			}else{
				int index=stack.pop();
				res=Math.max(res, heights[index]*(stack.isEmpty()?i:(i-stack.peek()-1)));
				--i;
			}
		}
		return res;
	}
	
	//从中间向两边扩展 on解法
	public int largestRectangleArea3(int[] heights){
		int length=heights.length;
		Stack<Integer> stack=new Stack<>();
		int[] left=new int[length];
		int[] right=new int[length];
		
		for(int i=0;i<length;i++){
			while(!stack.isEmpty()&&heights[stack.peek()]>=heights[i]){
				stack.pop();
			}
			left[i]=stack.isEmpty()?0:stack.peek()+1;
			stack.push(i);
		}
		
		stack.clear();
		for(int i=length-1;i>=0;i++){
			while(!stack.isEmpty()&&heights[stack.peek()]>=heights[i]){
				stack.pop();
			}
			right[i]=stack.isEmpty()?length:stack.peek();
			stack.push(i);
		}
		
		int max=0;
		for(int i=0;i<length;i++){
			int tmp=(right[i]-left[i])*heights[i];
			if(tmp>max){
				max=tmp;
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] test={1};
		System.out.println(largestRectangleArea(test));
	}
	
}






