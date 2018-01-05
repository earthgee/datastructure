import java.util.ArrayList;
import java.util.List;

//递归（dfs）
public class Test17 {
	
	public static List<String> letterCombinations(String digits) {
        List<String> result=new ArrayList<>();
        String[] strings={"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        combine(result,0,"",digits,strings);
        
        return result;
    }
	
	private static void combine(List<String> result,int level,String curr,String digits,String[] strings){
		if(level==digits.length()){
			result.add(curr);
			return;
		}
		
		int index=digits.charAt(level)-'2';
		String indexStr=strings[index];
		
		for(int i=0;i<indexStr.length();i++){
			combine(result, level+1, curr+indexStr.charAt(i), digits, strings);
		}
	}
	
	public static void main(String[] args) {
		List<String> reStrings=letterCombinations("23");
		for(String str:reStrings){
			System.out.println(str);
		}
	}
	
}
