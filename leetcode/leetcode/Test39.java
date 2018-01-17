import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//查找一个数组任意组合 和是target的情况 数组没有重复元素 递归加回溯
public class Test39 {

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> queue=new ArrayList<>();
        Arrays.sort(candidates);
        combine(candidates,res,queue,target,0);
        return res;
    }
	
	private static void combine(int[] candidates,List<List<Integer>> res,
			List<Integer> queue,int target,int current){
		if(target<0) return;
		if(target==0){
			List<Integer> tmp=new ArrayList<>(queue);
			res.add(tmp);
			return;
		}
		
		for(int i=current;i<candidates.length;i++){
			queue.add(candidates[i]);
			combine(candidates, res, queue, target-candidates[i], i);
			queue.remove(queue.size()-1);
		}
	}
	
	public static void main(String[] args) {
		int[] nums={2,3,6,7};
		combinationSum(nums, 7);
	}
	
}
