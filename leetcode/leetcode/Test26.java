
//有序数组滤掉重复项，双指针遍历
public class Test26 {

	public int removeDuplicates(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        
        int i=0;
        for(int j=1;j<nums.length;j++){
        	if(nums[j]!=nums[i]){
        		i++;
        		nums[i]=nums[j];
        	}
        }
        
        return i+1;
    }
	
}
