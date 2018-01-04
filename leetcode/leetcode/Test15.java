import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

//3 sum。通过固定一个数转变为2sum
public class Test15 {
	
	public static List<List<Integer>> threeSum(int[] nums) {
		Set<List<Integer>> result=new HashSet();
		Arrays.sort(nums);
		int length=nums.length;
		Map<Integer, Integer> map=new HashMap<>();
		for(int i=0;i<length-2;i++){
			if(nums[i]>0) break;
			if(i!=0&&nums[i]==nums[i-1]){
				continue;
			}
			int sum=0-nums[i];
			map.clear();
			for(int j=i+1;j<length;j++){
				int target=sum-nums[j];
				if(map.containsKey(target)){
					List<Integer> tmp=new ArrayList<>();
					tmp.add(nums[i]);
					tmp.add(nums[map.get(target)]);
					tmp.add(nums[j]);
					result.add(tmp);
				}
				map.put(nums[j], j);
			}
		}

		return new ArrayList(result);
    }
	
	public static void main(String[] args) {
		int[] nums={-1, 0, 1, 2, -1, -4};
		System.out.println(threeSum(nums).size());
	}
	
}
