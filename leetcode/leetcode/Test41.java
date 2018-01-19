
public class Test41 {

	public static int firstMissingPositive(int[] nums) {
        int length=nums.length;
        for(int i=0;i<length;i++){
        	while(nums[i]!=i+1){
        		if(nums[i]<1||nums[i]>length||nums[i]==nums[nums[i]-1]){
        			break;
        		}
        		
        		int tmp=nums[i];
        		nums[i]=nums[tmp-1];
        		nums[tmp-1]=tmp;
        	}
        }
        
        for(int i=0;i<length;i++){
        	if(nums[i]!=i+1){
        		return i+1;
        	}
        }
        return nums.length+1;
    }
	
	public static void main(String[] args) {
		int[] nums={3,4,-1,1};
		System.out.println(firstMissingPositive(nums));
	}
	
}
