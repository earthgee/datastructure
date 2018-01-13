import java.awt.image.RescaleOp;

//两int数相除，不能使用* / mod 转而使用位运算 int扩展为long防止溢出（有无更好方法？）
public class Test29 {

	public static int divide(int dividend, int divisor) {
		if(divisor==0) return Integer.MAX_VALUE;
		if(divisor==1) return dividend;
		if(dividend==Integer.MIN_VALUE&&divisor==-1){
			return Integer.MAX_VALUE;
		}
		
		long absDividend=Math.abs((long)dividend);
		long absDivisor=Math.abs((long)divisor);
		int result=0;
		
		while(absDividend>=absDivisor){
			int shiftNum=0;
			while(absDividend>=absDivisor<<shiftNum){
				shiftNum++;
			}
			
			result+=1<<(shiftNum-1);
			absDividend-=absDivisor<<(shiftNum-1);
		}
		
		if((dividend>0&&divisor>0)||(dividend<0&&divisor<0)){
			return result;
		}else{
			return -result;
		}
    }
	
	public static void main(String[] args) {
		System.out.println(divide(1, -1));
	}
	
}
