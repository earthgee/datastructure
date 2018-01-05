import java.util.Arrays;

//采用另一种方式，先对数组进行排序，通过双指针逼近（首先还是3sum转2sum）
public class Test16 {

	public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
		int length=nums.length;
		int l,r;
		int min=Integer.MAX_VALUE;
		int close=0;
        for(int i=0;i<length-2;i++){
        	int sum=target-nums[i];
        	l=i+1;
        	r=length-1;
        	while(l<r){
        		int tmp=Math.abs(nums[i]+nums[l]+nums[r]-target);
        		if(tmp<min){
        			min=tmp;
        			close=nums[i]+nums[l]+nums[r];
        		}
        		
        		if(nums[l]+nums[r]==sum){
        			return target;
        		}else if(nums[l]+nums[r]<sum){
        			l++;
        		}else{
        			r--;
        		}
        	}
        }
        
        return close;
    }
	
	public static void main(String[] args) {
		int[] test={1,2,5,10,11};
		System.out.println(threeSumClosest(test, 12));
	}
	
}
