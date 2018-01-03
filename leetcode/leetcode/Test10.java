//主要是dp,还有一种方法是递归
public class Test10 {

	public boolean isMatch(String s, String p) {
        if(p.isEmpty()) return s.isEmpty();
        boolean firstMatch=(!s.isEmpty() && (p.charAt(0)==s.charAt(0)||p.charAt(0)=='.'));
        
        if(p.length()>=2&&p.charAt(1)=='*'){
        	return (isMatch(s, p.substring(2))||(firstMatch&&isMatch(s.substring(1), p)));
        }else{
        	return firstMatch&&isMatch(s.substring(1), p.substring(1));
        }
    }
	
	public static boolean isMatch2(String s,String p){
		boolean[][] dp=new boolean[s.length()+1][p.length()+1];
		dp[s.length()][p.length()]=true;
		
		for(int i=s.length();i>=0;i--){
			for(int j=p.length()-1;j>=0;j--){
				boolean firstMatch=(i<s.length())&&(p.charAt(j)==s.charAt(i)||p.charAt(j)=='.');
				if(j!=p.length()-1&&p.charAt(j+1)=='*'){
					dp[i][j]=dp[i][j+2]||firstMatch&&dp[i+1][j];
				}else{
					dp[i][j]=firstMatch&&dp[i+1][j+1];
				}
			}
		}
		
		return dp[0][0];
	}
	
	public static void main(String[] args) {
		System.out.println(isMatch2("aa", "a*"));
	}
	
}
