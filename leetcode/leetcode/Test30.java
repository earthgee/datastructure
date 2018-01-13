import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//找子串 通过map缓存代替排列组合所有子串组合 但还是暴力解法，有无更好方法？（滑动窗口，怎么滑）
public class Test30 {

	public static List<Integer> findSubstring(String s, String[] words) {
		List<Integer> res=new ArrayList<>();
        Map<String, Integer> timeMap=new HashMap<>();
        int m=words.length;
        int n=words[0].length();
        int length=s.length()-m*n;
        boolean isConcat=false;
        
        if(length<0) return res;
        
        for(String word:words){
        	timeMap.put(word, timeMap.getOrDefault(word, 0)+1);
        }
        
        for(int i=0;i<=length;i++){
        	HashMap<String, Integer> copyMap=new HashMap<>(timeMap);
        	isConcat=false;
        	for(int index=0;index<m;index++){
        		String sub=s.substring(i+index*n, i+(index+1)*n);
        		if(copyMap.containsKey(sub)){
        			int time=copyMap.get(sub);
        			if(time==0){
        				break;
        			}else{
        				copyMap.put(sub, time-1);
        				if(index==m-1){
        					isConcat=true;
        				}
        			}
        		}else{
        			break;
        		}
        	}
        	if(isConcat){
        		res.add(i);
        	}
        }
        return res;
    }
	
	public static void main(String[] args) {
		String[] words={"foo","bar"};
		List<Integer> res=findSubstring("barfoothefoobarman", words);
		for(Integer index:res){
			System.out.println(index);
		}
	}
	
}
