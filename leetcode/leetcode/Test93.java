import java.util.ArrayList;
import java.util.List;

public class Test93 {

	public static List<String> restoreIpAddresses(String s) {
		if(s.length()>12){
			return new ArrayList<>();
		}
        List<String> res=new ArrayList<>();
        List<String> tmp=new ArrayList<>();
        search(s,res,tmp,4);
        return res;
    }
	
	private static void search(String s,List<String> res,List<String> tmp,int rest){
		if(rest==0&&s.length()==0){
			StringBuilder sb=new StringBuilder();
			for(int i=0;i<tmp.size();i++){
				sb.append(tmp.get(i));
				if(i!=tmp.size()-1){
					sb.append(".");
				}
			}
			res.add(sb.toString());
			return;
		}
		
		for(int i=1;i<=3;i++){
			if(s.length()>=i){
				String str=s.substring(0,i);
				if(isValid(str)){
					tmp.add(str);
					search(s.substring(i), res, tmp, rest-1);
					tmp.remove(tmp.size()-1);
				}
			}
		}
	}
	
	private static boolean isValid(String str){
		if(str.length()!=1){
			if(str.charAt(0)=='0'){
				return false;
			}
		}
		int num=Integer.parseInt(str);
		if(num>=0&&num<=255){
			return true;
		}else{
			return false;
		}
	}
	
	public static void main(String[] args) {
		List<String> res=restoreIpAddresses("0000");
		for(String str:res){
			System.out.println(str);
		}
	}
	
}
