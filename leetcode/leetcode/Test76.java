import java.util.HashMap;
import java.util.Map;

//两指针做滑动窗口 先滑动右窗口 找到所有字符后更新最小长度
//再移动左窗口 直到去掉一个关键字符后 继续移动右窗口 
public class Test76 {

	public static String minWindow(String s, String t) {
        Map<Character, Integer> map=new HashMap<>();
        for(int i=0;i<t.length();i++){
        	Character ch=t.charAt(i);
        	if(map.containsKey(ch)){
        		map.put(ch, map.get(ch)+1);
        	}else{
        		map.put(ch, 1);
        	}
        }
        
        int left=0;
        int count=0;
        int minLength=Integer.MAX_VALUE;
        String result="";
        for(int right=0;right<s.length();right++){
        	Character ch=s.charAt(right);
        	if(map.containsKey(ch)){
        		int last=map.get(ch);
        		map.put(ch, last-1);
        		if(last>0){
        			count++;
        		}
        	}
        	while(count==t.length()){
        		if(right-left+1<minLength){
        			minLength=right-left+1;
        			result=s.substring(left, right+1);
        		}
        		
        		Character chLeft=s.charAt(left);
        		if(map.containsKey(chLeft)){
        			int last=map.get(chLeft);
        			map.put(chLeft, ++last);
        			if(last>0){
        				count--;
        			}
        		}
        		
        		left++;
        	}
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		minWindow("ADOBECODEBANC", "ABC");
	}
	
}
