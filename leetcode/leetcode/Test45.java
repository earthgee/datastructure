//贪心 每前进一步 搜索范围为前一个范围可到达的最大范围
public class Test45 {

	//超时
	public int jump(int[] nums) {
		int[] step=new int[nums.length];
		
		step[0]=0;
		for(int i=1;i<nums.length;i++){
			for(int j=0;j<i;j++){
				if(j+nums[j]>=i){
					step[i]=step[j]+1;
					break;
				}
			}
		}
		
		return step[nums.length-1];
    }
	
	//贪心
	public int jump2(int[] nums){
		int start=0,end=0,step=0;
		int length=nums.length;
		int farthest;
		while(end<length-1){
			farthest=end;
			for(int i=start;i<=end;i++){
				if(i+nums[i]>farthest){
					farthest=i+nums[i];
				}
			}
			start=end+1;
			end=farthest;
			step++;
		}
		
		return step;
	}
	
}







