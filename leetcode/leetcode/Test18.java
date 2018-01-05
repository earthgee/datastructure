import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//4sum-->2sum
public class Test18 {

	public List<List<Integer>> fourSum(int[] nums, int target) {
		Set<List<Integer>> res=new HashSet();
		int length=nums.length;
		Arrays.sort(nums);
		for(int i=0;i<nums.length-3;i++){
			for(int j=i+1;j<nums.length-2;j++){
				int sum=target-nums[i]-nums[j];
				int l=j+1;
				int r=length-1;
				while(l<r){
					if(nums[l]+nums[r]==sum){
						List<Integer> list=new ArrayList<>();
						list.add(nums[i]);
						list.add(nums[j]);
						list.add(nums[l]);
						list.add(nums[r]);
						res.add(list);
						l++;r--;
					}else if(nums[l]+nums[r]<sum){
						l++;
					}else{
						r--;
					}
				}
			}
		}
		return new ArrayList<>(res);
    }
	
}






