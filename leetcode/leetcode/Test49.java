import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//判断错位词并归类 用一个int数组存字母出现次数 并以此为key构造hashmap
public class Test49 {

	public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length==0){
        	return new ArrayList<>();
        }
        
        Map<String, List<String>> map=new HashMap<>();
        int[] arrays=new int[26];
        for(String s:strs){
        	Arrays.fill(arrays, 0);
        	for(int i=0;i<s.length();i++){
        		Character c=s.charAt(i);
        		arrays[c-'a']++;
        	}
        	
        	StringBuilder sb=new StringBuilder();
        	for(int i=0;i<26;i++){
        		sb.append("#");
        		sb.append(arrays[i]);
        	}
        	
        	String key=sb.toString();
        	if(map.containsKey(key)){
        		map.get(key).add(s);
        	}else{
        		List<String> list=new ArrayList<>();
        		list.add(s);
        		map.put(key, list);
        	}
        }
        
        List<List<String>> res=new ArrayList<>();
        for(Map.Entry<String, List<String>> entry:map.entrySet()){
        	res.add(entry.getValue());
        }
        
        return res;
    }
	
}






