import java.util.ArrayList;
import java.util.List;

//递归回溯
public class Test77 {

	public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        combineInner(result,list,1,k,n);
        
        return result;
    }
	
	private void combineInner(List<List<Integer>> result,List<Integer> list,
			int current,int rest,int all){
		if(rest==0){
			List<Integer> tmp=new ArrayList<>(list);
			result.add(tmp);
			return;
		}
		if(current>all) return;
		for(int i=current;i<=all;i++){
			list.add(i);
			combineInner(result, list, i+1, rest-1, all);
			list.remove((Object)i);
		}
	}
	
}
