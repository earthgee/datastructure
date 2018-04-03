
public class Test70 {

	public int climbStairs(int n) {
       int[] memo=new int[n];
       return climbStairs(0,n,memo);
    }
	
	//递归 缓存结果
	private int climbStairs(int current,int n,int[] memo){
		if(current>n){
			return 0;
		}
		
		if(current==n){
			return 1;
		}
		
		if(memo[current]>0){
			return memo[current];
		}
		
		memo[current]=climbStairs(current+1,n,memo)+climbStairs(current+2, n, memo);
		
		return memo[current];
	}
	
	//从前到后 dp
	public int climbStairs2(int n) {
	     if(n==1){
	    	 return 1;
	     }
	     
	     int[] dp=new int[n+1];
	     dp[1]=1;
	     dp[2]=2;
	     for(int i=3;i<=n;i++){
	    	 dp[i]=dp[i-1]+dp[i-2];
	     }
	     return dp[n];
	}
	
}
