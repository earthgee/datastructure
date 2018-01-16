//二分搜索变种 搜索插入位置
public class Test35 {

	public int searchInsert(int[] nums, int target) {
        int l=0;
        int r=nums.length;
        while(l<r){
        	int mid=(l+r)/2;
        	if(nums[mid]>=target){
        		r=mid;
        	}else{
        		l=mid+1;
        	}
        }
        return l;
    }
	
}
