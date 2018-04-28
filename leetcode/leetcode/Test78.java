import java.util.ArrayList;
import java.util.List;

//递归，回溯
public class Test78 {

	public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        subsetInner(result,list,0,nums,nums.length);
        return result;
    }
	
	private static void subsetInner(List<List<Integer>> result,List<Integer> list,int index,int[] nums,int length){
		List<Integer> tmp=new ArrayList<>(list);
		result.add(tmp);
		
		if(index==length){
			return;
		}
		
		for(int i=index;i<length;i++){
			list.add(nums[i]);
			subsetInner(result, list, i+1, nums, length);
			list.remove((Object)nums[i]);
		}
		
	}
	
	public static void main(String[] args) {
		int[] nums={1,2,3};
		subsets(nums);
	}
	
}
