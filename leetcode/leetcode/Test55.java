
public class Test55 {
	
	enum INDEX{
		GOOD,BAD,UNKNOWN
	}
	
	INDEX[] memo;
	
	//从前到后，缓存结果，防止回溯重复  error:stack overflow
	public boolean canJump(int[] nums) {
        memo=new INDEX[nums.length];
        for(int i=0;i<memo.length;i++){
        	memo[i]=INDEX.UNKNOWN;
        }
        memo[memo.length-1]=INDEX.GOOD;
        return canJumpFromPosition(0,nums);
    }
	
	private boolean canJumpFromPosition(int position,int[] nums){
		if(memo[position]!=INDEX.UNKNOWN){
			return memo[position]==INDEX.GOOD?true:false;
		}
		
		int furthestJump=Math.min(position+nums[position], nums.length-1);
		for(int nextPosition=position+1;nextPosition<=furthestJump;nextPosition++){
			if(canJumpFromPosition(nextPosition, nums)){
				memo[position]=INDEX.GOOD;
				return true;
			}
		}
		
		memo[position]=INDEX.BAD;
		return false;
	}
	
	//从后到前 缓存结果 消除递归 超时
	public boolean canJump2(int[] nums){
		INDEX[] memo=new INDEX[nums.length];
		for(int i=0;i<memo.length;i++){
			memo[i]=INDEX.UNKNOWN;
		}
		memo[memo.length-1]=INDEX.GOOD;
		
		for(int i=nums.length-2;i>=0;i--){
			int furthestJump=Math.min(i+nums[i], nums.length-1);
			for(int j=i+1;j<=furthestJump;j++){
				if(memo[j]==INDEX.GOOD){
					memo[i]=INDEX.GOOD;
					break;
				}
			}
		}
		
		return memo[0]==INDEX.GOOD;
	}
	
	//贪心
	public boolean canJump3(int[] nums){
		int length=nums.length;
		int left=0,right=0;
		int furthest=0;
		while(true){
			for(int i=left;i<=right;i++){
				if(i+nums[i]>=furthest){
					furthest=i+nums[i];
					if(furthest>=length-1){
						return true;
					}
				}
			}
			if(furthest<=right){
				return false;
			}
			left=right+1;
			right=furthest;
		}
	}
	
}








