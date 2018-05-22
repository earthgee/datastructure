//从后往前遍历比较
public class Test88 {

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index=m+n-1;
        int p1=m-1;
        int p2=n-1;
        while(index>=0){
        	if(p1<0) {nums1[index--]=nums2[p2--];continue;}
        	if(p2<0) {nums1[index--]=nums1[p1--];continue;}
        	if(nums1[p1]>=nums2[p2]){
        		nums1[index--]=nums1[p1--];
        	}else{
        		nums1[index--]=nums2[p2--];
        	}
        }
    }
	
	public static void main(String[] args) {
		int[] nums1={1,0};
		int[] nums2={5};
		merge(nums1, 1, nums2, 1);
		
	}
	
}
