import java.util.Stack;

public class Test85 {
	
	private int maxOfRow(int[] height,int length){
		Stack<Integer> stack=new Stack<>();
		int max=0;
		for(int i=0;i<=length;i++){
			int current;
			if(i==length){
				current=0;
			}else{
				current=height[i];
			}
			
			if(stack.isEmpty()||height[stack.peek()]<current){
				stack.push(i);
			}else{
				int index=stack.pop();
				max=Math.max(max, height[index]*(stack.isEmpty()?i:i-stack.peek()-1));
				i--;
			}
		}
		return max;
	}

	//解法1，将每一行看做一个直方图 用84递增栈方法解决
	public int maximalRectangle(char[][] matrix) {
        int length=matrix[0].length;
		int[] height=new int[length];
		int res=0;
        for(int i=0;i<matrix.length;i++){
        	for(int j=0;j<length;j++){
        		height[j]=matrix[i][j]=='1'?height[j]+1:0;
        	}
        	res=Math.max(res, maxOfRow(height, length));
        }
        return res;
	}
	
	//解法2，每一行计算当前围成的最大面积
	public int maximalRectangle2(char[][] matrix) {
		if(matrix==null||matrix.length==0){
			return 0;
		}
		
		int row=matrix.length;
		int col=matrix[0].length;
		int[] left=new int[col];
		int[] right=new int[col];
		int[] height=new int[col];
		for(int i=0;i<col;i++){
			right[i]=col;
		}
		
		int max=0;
		for(int i=0;i<row;i++){
			int leftBound=0;
			int rightBound=col;
			for(int j=0;j<col;j++){
				if(matrix[i][j]=='1'){
					height[j]++;
				}else{
					height[j]=0;
				}
			}
			
			for(int j=0;j<col;j++){
				if(matrix[i][j]=='1'){
					left[j]=Math.max(left[j], leftBound);
				}else{
					left[j]=0;
					leftBound=j+1;
				}
			}
			
			for(int j=col-1;j>=0;j--){
				if(matrix[i][j]=='1'){
					right[j]=Math.min(right[j], rightBound);
				}else{
					right[j]=col;
					rightBound=j;
				}
			}
			
			for(int j=0;j<col;j++){
				max=Math.max((right[j]-left[j])*height[j], max);
			}
		}
		
		return max;
	}
	
}
