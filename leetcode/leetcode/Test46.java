import java.util.ArrayList;
import java.util.List;

//递归+回溯
public class Test46 {

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res=new ArrayList<>();
		boolean[] isValid=new boolean[nums.length];
		List<Integer> current=new ArrayList<>();
		play(res,nums,isValid,current);
		
		return res;
    }
	
	private void play(List<List<Integer>> res,int[] nums,boolean[] isValid,List<Integer> current){
		if(current.size()==nums.length){
			List<Integer> tmp=new ArrayList<>(current);
			res.add(tmp);
			return;
		}
		
		for(int i=0;i<nums.length;i++){
			if(isValid[i]==false){
				isValid[i]=true;
				current.add(nums[i]);
				play(res, nums, isValid,current);
				current.remove(current.size()-1);
				isValid[i]=false;
			}
		}
		
	}
	
}
