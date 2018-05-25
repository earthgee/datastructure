
public class Test91 {

	public static int numDecodings(String s) {
		if(s==null||s.length()==0) return 0;
        int length=s.length();
        int[][] dp=new int[length][length];
        for(int i=0;i<length;i++){
        	if(s.charAt(i)!='0'){
        		dp[i][i]=1;
        	}
        }
        for(int d=2;d<=length;d++){
        	for(int i=0;i<=length-d;i++){
        		if(s.charAt(i+d-1)!='0'){
        			dp[i][i+d-1]+=dp[i][i+d-2];
        		}
        		int first=s.charAt(i+d-2)-'0';
        		int second=s.charAt(i+d-1)-'0';
        		int tmp=first*10+second;
        		if(tmp>=1&&tmp<=26&&first!=0){
        			if(i+d-3>=i){
        				dp[i][i+d-1]+=dp[i][i+d-3];
        			}else{
        				dp[i][i+d-1]++;
        			}
        		}
        	}
        }
        return dp[0][length-1];
	}
	
	public static void main(String[] args) {
		System.out.println(numDecodings("0123"));
	}
	
}
