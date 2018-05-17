
public class Test87 {

	//递归解法
	public static boolean isScramble(String s1, String s2) {
        if(s1.length()!=s2.length()){
        	return false;
        }
        if(s1.equals(s2)){
        	return true;
        }
        int[] hash=new int[26];
        for(int i=0;i<s1.length();i++){
        	char ch=s1.charAt(i);
        	hash[ch-'a']++;
        }
        for(int i=0;i<s2.length();i++){
        	char ch=s2.charAt(i);
        	hash[ch-'a']--;
        }
        for(int i=0;i<26;i++){
        	if(hash[i]!=0){
        		return false;
        	}
        }
        
        for(int i=1;i<s1.length();i++){
        	if((isScramble(s1.substring(0,i), s2.substring(0,i))&&
        			isScramble(s1.substring(i,s1.length()), s2.substring(i,s1.length())))
        			||
        		(isScramble(s1.substring(0,i), s2.substring(s1.length()-i, s1.length()))
        				&&isScramble(s1.substring(i,s1.length()), s2.substring(0, s1.length()-i)))){
        		return true;
        	}
        }
        return false;
    }
	
	//dp解法
	public boolean isScramble2(String s1, String s2) {
        if(s1==null||s2==null||s1.length()!=s2.length()){
        	return false;
        }
        if(s1.length()==0){
        	return true;
        }
        boolean[][][] res=new boolean[s1.length()][s2.length()][s1.length()+1];
        for(int i=0;i<s1.length();i++){
        	for(int j=0;j<s2.length();j++){
        		res[i][j][1]=s1.charAt(i)==s2.charAt(j);
        	}
        }
        for(int len=2;len<=s1.length();len++){
        	for(int i=0;i<s1.length()-len+1;i++){
        		for(int j=0;j<s2.length()-len+1;j++){
        			for(int k=1;k<len;k++){
        				res[i][j][len]|=res[i][j][k]&&res[i+k][j+k][len-k] || res[i][j+len-k][k]&&res[i+k][j][len-k];
        			}
        		}
        	}
        }
        return res[0][0][s1.length()];
    }
	
	public static void main(String[] args) {
		System.out.println(isScramble("abcde", "caebd"));
	}
	
}
