//计算最小路径和 和前两道题一样
public class Test64 {

	public static int minPathSum(int[][] grid) {
		int row=grid.length;
        int col=grid[0].length;
		int[][] dp=new int[row][col];
		
		dp[0][0]=grid[0][0];
		for(int i=1;i<row;i++){
			dp[i][0]=grid[i][0]+dp[i-1][0];
		}
		
		for(int i=1;i<col;i++){
			dp[0][i]=grid[0][i]+dp[0][i-1];
		}
		
		for(int i=1;i<row;i++){
			for(int j=1;j<col;j++){
				dp[i][j]=grid[i][j]+(dp[i-1][j]>dp[i][j-1]?dp[i][j-1]:dp[i-1][j]);
			}
		}
		
		return dp[row-1][col-1];
    }
	
	public static void main(String[] args) {
		int[][] nums={{1,3,1},{1,5,1},{4,2,1}};
		minPathSum(nums);
	}
	
}
