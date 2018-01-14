//找排列的下一个顺序
//eg:
//127653(next)-->137652-->132567
public class Test31 {

	public void nextPermutation(int[] nums) {
        int i=nums.length-2;
        while(i>=0&&nums[i]>=nums[i+1]){
        	i--;
        }
        if(i>=0){
        	int j=nums.length-1;
        	while(j>=0&&nums[j]<=nums[i]){
        		j--;
        	}
        	int swap=nums[i];
        	nums[i]=nums[j];
        	nums[j]=swap;
        }
        
        //reverse
        int j=nums.length-1;
        i++;
        while(i<j){
        	int swap=nums[i];
        	nums[i]=nums[j];
        	nums[j]=swap;
        	i++;
        	j--;
        }
    }
	
}
