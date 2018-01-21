//和10类似 二维dp求解
public class Test44 {

	//递归超时
	public static boolean isMatch(String s, String p) {
		if(s.isEmpty()&&p.isEmpty()) return true;
		if(p.isEmpty()) return false;
		
		int ch=p.charAt(0);
		
		if(s.isEmpty()){
			if(ch=='*'){
				return isMatch(s, p.substring(1));
			}else{
				return false;
			}
		}else{
			int chp=s.charAt(0);
			if(ch=='?'||ch==chp){
				return isMatch(s.substring(1), p.substring(1));
			}else if(ch=='*'){
				return isMatch(s.substring(1), p)||isMatch(s, p.substring(1));
			}else{
				return false;
			}
		}
    }
	
	//dp 二维 从后向前 注意边界条件
	public static boolean isMatch2(String s, String p) {
        boolean[][] dp=new boolean[s.length()+1][p.length()+1];
        
        dp[s.length()][p.length()]=true;
        for(int j=p.length()-1;j>=0;j--){
        	dp[s.length()][j]=p.charAt(j)=='*'&&dp[s.length()][j+1];
        }
        for(int i=s.length()-1;i>=0;i--){
        	dp[i][p.length()]=false;
        }
        
        for(int i=s.length()-1;i>=0;i--){
        	for(int j=p.length()-1;j>=0;j--){
        		int chs=s.charAt(i);
        		int chp=p.charAt(j);
        		if(chs==chp||chp=='?'){
        			dp[i][j]=dp[i+1][j+1];
        		}else if(chp=='*'){
        			dp[i][j]=dp[i+1][j]||dp[i][j+1];
        		}else {
        			dp[i][j]=false;
        		}
        	}
        }
        
        return dp[0][0];
    }
	
	public static void main(String[] args) {
		System.out.println(isMatch2("aab", "c*a*b"));
	}
	
}
