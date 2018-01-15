//二分查找 找到mid后 总有一边是有序的 通过边界决定target在哪一边
public class Test34 {

	public static int search(int[] nums, int target) {
		if(nums.length==0) return -1;
		int length=nums.length;
		int left=0,right=length-1;
		while(left<=right){
			int mid=(left+right)/2;
			if(nums[mid]==target) return mid;
			else if(nums[mid]<nums[right]){
				if(nums[mid]<target&&nums[right]>=target) left=mid+1;
				else right=mid-1;
			}else{
				if(nums[left]<=target&&target<nums[mid]) right=mid-1;
				else left=mid+1;
			}
		}
		return -1;
    }
	
	public static void main(String[] args) {
		int[] nums={3,5,1};
		System.out.println(search(nums, 3));
	}
	
}
