
//atoi 边界条件 注意溢出
public class Test8 {

	public static int myAtoi(String str) {
        if(str==null||str.length()==0){
        	return 0;
        }
        
        str=str.trim();
        
        boolean positive=true;
        int i=0;
        if(str.charAt(0)=='+'){
        	i++;
        }else if(str.charAt(0)=='-'){
        	i++;
        	positive=false;
        }
        
        int base=0;
        int length=str.length();
        while(i<length){
        	int tmp=str.charAt(i)-'0';
        	if(tmp<0||tmp>9) break;
        	
        	if(base>Integer.MAX_VALUE/10||(base==Integer.MAX_VALUE/10&&tmp>7)){
        		if(positive) return Integer.MAX_VALUE;
        		else         return Integer.MIN_VALUE;
        	}
        	
        	base=base*10+tmp;
        	i++;
        }
        
        if(positive){
        	return base;
        }else{
        	return -1*base;
        }
    }
	
	public static void main(String[] args) {
		System.out.println(myAtoi("1"));
	}
	
}
