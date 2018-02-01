
public class Test53 {

	//对于每一个元素有两种选择:1.自己新起一个subarray，2.加入前一个subarray中
	public int maxSubArray(int[] nums) {
        int max=nums[0];
        int partMax=nums[0];
        int length=nums.length;
        for(int i=1;i<length;i++){
        	partMax=Math.max(nums[i], nums[i]+partMax);
        	max=Math.max(partMax, max);
        }
        return max;
    }
	
	//leetcode 说可以用分治
	public int maxSubArray2(int[] nums){
		if(nums.length==0) return 0;
		return helper(nums,0,nums.length-1);
	}
	
	private int helper(int[] nums,int left,int right){
		if(left>=right) return nums[left];
		int mid=left+(right-left)/2;
		int lmax=helper(nums, left, mid-1);
		int rmax=helper(nums, mid+1, right);
		int mmax=nums[mid],t=mmax;
		for(int i=mid-1;i>=left;i--){
			t+=nums[i];
			mmax=Math.max(mmax, t);
		}
		t=mmax;
		for(int i=mid+1;i<=right;i++){
			t+=nums[i];
			mmax=Math.max(mmax, t);
		}
		return Math.max(mmax, Math.max(lmax, rmax));
	}
	
}









