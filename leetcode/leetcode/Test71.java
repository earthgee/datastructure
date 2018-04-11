import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//简化linux路径 .可以不管 ..需pop上一个push的 用栈管理即可
public class Test71 {

	public static String simplifyPath(String path) {
        LinkedList<String> stack=new LinkedList<>();
        String[] p=path.split("/");
        for(String t:p){
        	if(!stack.isEmpty()&&t.equals("..")){
        		stack.pop();
        	}else if(!t.equals(".")&&!t.equals("")&&!t.equals("..")){
        		stack.push(t);
        	}
        }
        if(stack.size()==0) return "/";
        StringBuilder sb=new StringBuilder();
        for(int i=stack.size()-1;i>=0;i--){
        	sb.append("/"+stack.get(i));
        }
        return sb.toString();
    }
	
	public static void main(String[] args) {
		System.out.println(simplifyPath("/abc/..."));
	}
	
}
