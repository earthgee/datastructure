import java.util.HashMap;
import java.util.Map;

public class Test1 {

	public int[] twoSum(int[] nums,int target){
		Map<Integer, Integer> map=new HashMap<>();
		for(int i=0;i<nums.length;i++){
			int lookfor=target-nums[i];
			if(map.containsKey(lookfor)){
				return new int[]{map.get(lookfor),i};
			}
			map.put(nums[i], i);
		}
		return null;
	}
	
}
