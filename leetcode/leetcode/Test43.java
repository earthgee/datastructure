//大数乘法  难度会略大于大数加减法 length1*length2,结果最多length1+length2位
public class Test43 {
	
	public static String multiply(String num1, String num2) {
		int length1=num1.length();
		int length2=num2.length();
        int[] ans=new int[length1+length2];
        //加
        for(int j=length2-1;j>=0;j--){
        	int muled=num2.charAt(j)-'0';
        	for(int i=length1-1;i>=0;i--){
        		int mul=num1.charAt(i)-'0';
        		ans[i+j+1]+=mul*muled;
        	}
        }
        
        //进位
        int add=0;
        for(int i=ans.length-1;i>=0;i--){
        	int current=ans[i]+add;
        	if(current<10){
        		ans[i]=current;
        		add=0;
        	}else{
        		add=current/10;
        		ans[i]=current%10;
        	}
        }
        
        //变成字符串
        StringBuilder sb=new StringBuilder();
        int i=0;
        for(i=0;i<length1+length2;i++){
        	if(ans[i]!=0) break; 
        }
        
        for(int j=i;j<length1+length2;j++){
        	sb.append(ans[j]);
        }
        
        if(sb.length()==0){
        	return "0";
        }
        
        return sb.toString();
    }
	
	public static void main(String[] args) {
		System.out.println(multiply("98", "9"));
	}
	
}












