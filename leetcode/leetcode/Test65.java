//判断是否是数字
public class Test65 {

	public boolean isNumber(String s) {
       //数字是否出现
		boolean num=false;
		//小数点是否出现
		boolean dot=false;
		//e是否出现
		boolean exp=false;
		//符号是否出现
		boolean sign=false;
		boolean numAfterE=false;
		int n=s.length();
       for(int i=0;i<n;i++){
    	   char c=s.charAt(i);
    	   if(c==' '){
    		   if(i<n-1&&s.charAt(i+1)!=' '&&
    				   (num||dot||exp||sign)){
    			   return false;
    		   }
    	   }else if(c=='+'||c=='-'){
    		   if(i>0&&s.charAt(i-1)!='e'&&
    				   s.charAt(i-1)!=' '){
    			   return false;
    		   }
    		   sign=true;
    	   }else if(c>='0'&&c<='9'){
    		   num=true;
    		   numAfterE=true;
    	   }else if(c=='.'){
    		   if(dot||exp) return false;
    		   dot=true;
    	   }else if(c=='e'){
    		   if(exp||!num) return false;
    		   exp=true;
    		   numAfterE=false;
    	   }else{
    		   return false;
    	   }
       }
       
       return num&&numAfterE;
    }
	
}






