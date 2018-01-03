
//判断回文数 o(1)空间复杂度
public class Test9 {

	public static boolean isPalindrome(int x) {
        if(x<0||(x!=0&&x%10==0)){
        	return false;
        }
        
        int res=0;
        while(x>res){
        	res=res*10+x%10;
        	x=x/10;
        }
        
        if(x==res||res/10==x){
        	return true;
        }else{
        	return false;
        }
    }
	
	public static void main(String[] args) {
		System.out.println(isPalindrome(1001));
	}
	
}
