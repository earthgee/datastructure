import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//递归+回溯 注意有重复元素 注意先排序
public class Test47 {

	public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> current=new ArrayList<>();
        boolean[] visit=new boolean[nums.length];
        Arrays.sort(nums);
        compute(res,nums,visit,current);
        return res;
	}	
	
	private static void compute(List<List<Integer>> res,int[] nums,
			boolean[] visit,List<Integer> current){
		if(current.size()==nums.length){
			List<Integer> tmp=new ArrayList<>(current);
			res.add(tmp);
			return;
		}
		
		for(int i=0;i<nums.length;i++){
			if(i>0&&nums[i]==nums[i-1]&&visit[i-1]==false){
				continue;
			}
			
			if(visit[i]==false){
				visit[i]=true;
				current.add(nums[i]);
				compute(res, nums, visit, current);
				current.remove(current.size()-1);
				visit[i]=false;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] nums={1,1,2,1};
		List<List<Integer>> res=permuteUnique(nums);
		for(List<Integer> list:res){
			for(Integer integer:list){
				System.out.print(integer+" ");
			}
			System.out.println();
		}
	}
	
}
