
public class Test72 {

	//动态规划 状态转移方程
	//dp[i][0]=i dp[0][i]=i
	//dp[i][j]=dp[i-1][j-1] if(word1[i]==word2)
	//dp[i][j]=min(dp[i-1][j-1],dp[i][j-1],dp[i-1][j])
	public int minDistance(String word1, String word2) {
		int x=word1.length();
		int y=word2.length();
		int[][] dp=new int[x+1][y+1];
		for(int i=0;i<=x;i++){
			dp[i][0]=i;
		}
		for(int i=0;i<=y;i++){
			dp[0][i]=i;
		}
		for(int i=1;i<=x;i++){
			for(int j=1;j<=y;j++){
				if(word1.charAt(i-1)==word2.charAt(j-1)){
					dp[i][j]=dp[i-1][j-1];
				}else{
					int min=Math.min(dp[i-1][j-1], dp[i][j-1]);
					min=Math.min(min, dp[i-1][j]);
					dp[i][j]=min+1;
				}
			}
		}
		return dp[x][y];
    }
	
}
