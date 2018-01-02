
public class Test5 {

	public String longestPalindrome(String s) {
		if(s.length()==0||s.length()==1) return s;
        boolean[][] dp=new boolean[s.length()][s.length()];
        
        //initialize
        for(int i=0;i<s.length();i++){
        	for(int j=0;j<s.length();j++){
        		if(i>=j){
        			dp[i][j]=true;
        		}else{
        			dp[i][j]=false;
        		}
        	}
        }
        
        int rf=0,rt=0;
        int maxLen=0;
        for(int k=1;k<s.length();k++){
        	for(int i=0;i+k<s.length();i++){
        		int j=i+k;
        		if(s.charAt(i)!=s.charAt(j)){
        			dp[i][j]=false;
        		}else{
        			dp[i][j]=dp[i+1][j-1];
        			if(dp[i][j]){
        				if(k+1>maxLen){
        					maxLen=k+1;
        					rf=i;
        					rt=j;
        				}
        			}
        		}
        	}
        }
        return s.substring(rf,rt+1);
    }
	
}
