/**
 * 
 * @author earthgee
 *
 *用两个指针
 *该数组分为4段：[0,left)-->0; [left,i)-->1; [i,right]-->乱序; (right,n-1]-->2

0  0  0  1  1  1  2  1  0  2  1  2  2  2

           ^         ^             ^

          left         i            right


 */
public class Test75 {

	public void sortColors(int[] nums) {
		int i=0;
		int j=nums.length-1;
		int index=0;
		while(index<=j){
			if(nums[index]==0){
				int tmp=nums[i];
				nums[i]=nums[index];
				nums[index]=tmp;
				i++;
				index++;
			}else if(nums[index]==1){
				index++;
			}else if(nums[index]==2){
				int tmp=nums[j];
				nums[j]=nums[index];
				nums[index]=tmp;
				j--;
			}
		}
    }
	
}
