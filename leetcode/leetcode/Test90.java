import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//递归 回溯
public class Test90 {

	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
        Set<List<Integer>> res=new HashSet<>();
        int length=nums.length;
        List<Integer> tmp=new ArrayList<>();
        calculate(res,tmp,0,nums,length);
        return new ArrayList<>(res);
    }
	
	private static void calculate(Set<List<Integer>> res,
			List<Integer> tmp,int index,int[] nums,int length){
		List<Integer> copy=new ArrayList<>(tmp);
		res.add(copy);
		
		for(int i=index;i<length;i++){
			tmp.add(nums[i]);
			calculate(res, tmp, i+1, nums, length);
			tmp.remove(tmp.size()-1);
		}
	}
	
	public static void main(String[] args) {
		int[] nums={1,2,2};
		List<List<Integer>> ans=subsetsWithDup(nums);
		for(List<Integer> list:ans){
			System.out.print("[");
			for(Integer i:list){
				System.out.print(i+",");
			}
			System.out.println();
		}
	}
	
}







