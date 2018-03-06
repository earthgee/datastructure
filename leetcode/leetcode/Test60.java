import java.util.ArrayList;
import java.util.List;

//找规律 类似gcd
public class Test60 {

	public static String getPermutation(int n, int k) {
        List<Character> nums=new ArrayList<>();
        for(int i=1;i<=9;i++){
        	nums.add((char) ('0'+i));
        }
        StringBuilder sb=new StringBuilder();
        int nj=1;
        for(int i=1;i<n;i++){
        	nj*=i;
        }
        k--;
        for(int i=n-1;i>=0;i--){
        	int index=k/nj;
        	sb.append(nums.remove(index));
        	k=k%nj;
        	if(i!=0){
        		nj=nj/i;
        	}
        }
        return sb.toString();
    }
	
	public static void main(String[] args) {
		System.out.println(getPermutation(4, 17));
	}
	
}
