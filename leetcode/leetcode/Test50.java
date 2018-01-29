
//分治减少时间
public class Test50 {

	public double myPow(double x, int n) {
        if(n<0) return 1/pow(x,-n);
        return pow(x, n);
    }
	
	private double pow(double x,int n){
		if(n==0) return 1;
		double half=pow(x, n/2);
		if(n%2==0) return half*half;
		return half*half*x;
	}
	
}
