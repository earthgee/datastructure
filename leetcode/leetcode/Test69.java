//二分搜索 上界可以优化为x/2+1
public class Test69 {

	public int mySqrt(int x) {
        long left=0;
        long right=x/2+1;
        while(left<=right){
        	long mid=(left+right)/2;
        	long mid2=mid*mid;
        	if(mid2==x) return (int) mid;
        	else if(mid2<x) left=mid+1;
        	else right=mid-1;
        }
        
        return (int) right;
    }
	
}
