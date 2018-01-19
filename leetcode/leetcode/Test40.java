import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//递归 回溯 和39题类似
public class Test40 {

	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> queue=new ArrayList<>();
        Arrays.sort(candidates);
        combine(res,queue,candidates,target,0);
        return res;
    }
	
	private static void combine(List<List<Integer>> res,List<Integer> queue,
			int[] candidates,int target,int current){
		if(target<0) return;
		if(target==0){
			List<Integer> tmp=new ArrayList<>(queue);
			res.add(tmp);
			return;
		}
		
		for(int i=current;i<candidates.length;i++){
			if(i>current&&candidates[i]==candidates[i-1]) continue;
			queue.add(candidates[i]);
			combine(res, queue, candidates, target-candidates[i], i+1);
			queue.remove(queue.size()-1);
		}
	}
	
	public static void main(String[] args) {
		int[] nums={10,1,2,7,6,1,5};
		combinationSum2(nums, 8);
	}
	
}
