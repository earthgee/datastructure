
//二分搜索 如果nums[m]<nums[r]则右边有序 否则左边有序
public class Test81 {

	public static boolean search(int[] nums, int target) {
        int l=0;
        int r=nums.length-1;
        while(l<=r){
        	int m=(l+r)/2;
        	if(nums[m]==target){
        		return true;
        	}
        	if(nums[m]<nums[r]){
        		if(target>nums[m]&&target<=nums[r]){
        			l=m+1;
        		}else{
        			r=m-1;
        		}
        	}else if(nums[m]>nums[r]){
        		if(target>=nums[l]&&target<nums[m]){
        			r=m-1;
        		}else{
        			l=m+1;
        		}
        	}else{
        		r--;
        	}
        }
        return false;
    }
	
	public static void main(String[] args) {
		int[] nums={3,1};
		System.out.println(search(nums, 1));
	}
	
}
