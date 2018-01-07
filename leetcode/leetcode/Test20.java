import java.util.Stack;

//括号匹配 用栈解决
public class Test20 {

	public boolean isValid(String s) {
		if(s==null||s.length()==0){
			return true;
		}
		
		Stack<Character> stack=new Stack<>();
		for(int index=0;index<s.length();index++){
			Character c=s.charAt(index);
			if(c=='('||c=='{'||c=='['){
				stack.push(c);
			}else{
				if(stack.isEmpty()) return false;
				if(c==')'){
					if(stack.peek()=='('){
						stack.pop();
						continue;
					}else{
						return false;
					}
				}
				
				if(c=='}'){
					if(stack.peek()=='{'){
						stack.pop();
						continue;
					}else{
						return false;
					}
				}
				
				if(c==']'){
					if(stack.peek()=='['){
						stack.pop();
						continue;
					}else{
						return false;
					}
				}
			}
		}
		
		if(!stack.isEmpty()) return false;
		else                 return true;
    }
	
}
