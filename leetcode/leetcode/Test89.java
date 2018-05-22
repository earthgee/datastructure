import java.util.ArrayList;
import java.util.List;


public class Test89 {

	public static List<Integer> grayCode(int n) {
        List<Integer> res=new ArrayList<>();
        int[] bits=new int[n];
        int length=(int)Math.pow(2, n);
        search(res,bits,length);
        return res;
	}
	
	private static boolean search(List<Integer> res,int[] bits,int length){
		if(res.size()==length){
			return true;
		}
		
		int ans=0;
		int add=1;
		for(int i=0;i<bits.length;i++){
			ans+=bits[i]*add;
			add*=2;
		}
		
		if(res.contains(ans)){
			return false;
		}else{
			res.add(ans);
			for(int i=0;i<bits.length;i++){
				if(bits[i]==0){
					bits[i]=1;
				}else{
					bits[i]=0;
				}
				
				if(search(res, bits, length)){
					return true;
				}
				
				if(bits[i]==0){
					bits[i]=1;
				}else{
					bits[i]=0;
				}
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		List<Integer> res=grayCode(2);
		for(Integer a:res){
			System.out.println(a);
		}
	}
	
}
