import java.util.ArrayList;
import java.util.List;

//递归回溯
public class Test22 {
	
	public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        generateValid(res,"",0,0,n);
        return res;
	}
	
	private void generateValid(List<String> res,String cur,
			int left,int right,int max){
		if(left+right==2*max){
			res.add(cur);
		}
		
		if(left<max){
			generateValid(res, cur+"(", left+1, right, max);
		}
		if(right<left){
			generateValid(res, cur+")", left, right+1, max);
		}
	}

}
