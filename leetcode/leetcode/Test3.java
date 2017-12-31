import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test3 {
	
	public int lengthOfLongestSubstring(String s) {
        int i=0;int j=0;
        int length=s.length();
        int max=0;
        Set<Character> set=new HashSet<>();
        while(j<length){
        	if(!set.contains(s.charAt(j))){
        		set.add(s.charAt(j++));
        		max=Math.max(max, j-i);
        	}else{
        		set.remove(s.charAt(i++));
        	}
        }
        return max;
    }
	
	public int lengthOfLongestSubstringtwo(String s){
		int length=s.length();
		int max=0;
		Map<Character, Integer> map=new HashMap<>();
		for(int j=0,i=0;j<length;j++){
			if(map.containsKey(s.charAt(j))){
				i=Math.max(map.get(s.charAt(j)), i);
			}
			max=Math.max(max, j-i+1);
			map.put(s.charAt(j), j+1);
		}
		return max;
	}
	
	//不使用map，将索引放在字符数组里
	public int lengthOfLongestSubstringthree(String s){
		int n=s.length(),max=0;
		int[] index=new int[128];
		for(int j=0,i=0;j<n;j++){
			i=Math.max(index[s.charAt(j)], i);
			max=Math.max(max, j-i+1);
			index[s.charAt(j)]=j+1;
		}
		return max;
	}
	
}








