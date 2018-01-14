import java.util.Stack;

//动态规划 
public class Test32 {
	
	public static int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int maxLen = 0;
        for(int i = s.length()-2; i >=0; i--){
            if(s.charAt(i)=='('){
                int end = i + dp[i+1] + 1;
                if(end < s.length() && s.charAt(end)==')'){
                    dp[i] = dp[i+1] + 2;
                    if(end + 1 < s.length()){
                        dp[i] += dp[end + 1];
                    }
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
	
	//用栈解决
	public int longestValidParentheses2(String s){
		int max=0;
		Stack<Integer> stack=new Stack<>();
		stack.push(-1);
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=='('){
				stack.push(i);
			}else{
				stack.pop();
				if(stack.empty()){
					stack.push(i);
				}else{
					max=Math.max(max, i-stack.peek());
				}
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		System.out.println(longestValidParentheses("()()"));
	}
	
}
