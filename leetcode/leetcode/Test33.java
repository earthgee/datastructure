
//搜索一个target范围
public class Test33 {

	//使用二分查找找到后向左 向右扫
	public static int[] searchRange(int[] nums, int target) {
		int left=0;int right=nums.length-1;
		int index=-1;
		while(left<=right){
			int mid=(left+right)/2;
			if(nums[mid]==target){
				index=mid;
				break;
			}else if(nums[mid]>target){
				right=mid-1;
			}else{
				left=mid+1;
			}
		}
		int[] res={-1,-1};
		if(index==-1) return res;
		left=index;
		while(left>0&&nums[left-1]==target){
			left--;
		}
		right=index;
		while(right<nums.length-1&&nums[right+1]==target){
			right++;
		}
		res[0]=left;res[1]=right;
		return res;
	}
	
	//用两次二分 分别找到左右边界
	public static int[] searchRange2(int[] nums, int target){
		int[] res={-1,-1};
		int leftIndex=extremeIndex(nums,target,true);
		
		if(leftIndex==nums.length||nums[leftIndex]!=target) return res;
		res[0]=leftIndex;
		res[1]=extremeIndex(nums, target, false)-1;
		
		return res;
	}
	
	private static int extremeIndex(int[] nums,int target,boolean left){
		int lo=0;
		int hi=nums.length;
		
		while(lo<hi){
			int mid=(lo+hi)/2;
			if(nums[mid]>target||(left&&target==nums[mid])){
				hi=mid;
			}else{
				lo=mid+1;
			}
		}
		
		return lo;
	}
	
	public static void main(String[] args) {
		
	}
	
}
