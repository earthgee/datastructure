
//分治或二分搜索
public class Test14 {

	public String longestCommonPrefix(String[] strs) {
       if(strs==null||strs.length==0) return "";
       
       for(int i=0;i<strs[0].length();i++){
    	   char tmp=strs[0].charAt(i);
    	   for(int j=1;j<strs.length;j++){
    		   if(i==strs[j].length()||strs[j].charAt(i)!=tmp){
    			   return strs[0].substring(0, i);
    		   }
    	   }
       }
       return strs[0];
    }
	
	public String longestCommonPrefix2(String[] strs){
		if(strs==null||strs.length==0) return "";
		return longestCommonPrefix(strs,0,strs.length-1);
	}
	
	private String longestCommonPrefix(String[] strs,int l,int r){
		if(l==r){
			return strs[l];
		}
		else{
			int mid=(l+r)/2;
			String lcpLeft=longestCommonPrefix(strs, l, mid);
			String lcpRight=longestCommonPrefix(strs, mid+1, r);
			return commonPrefix(lcpLeft,lcpRight);
		}
	}
	
	private String commonPrefix(String left,String right){
		int min=Math.min(left.length(), right.length());
		for(int i=0;i<min;i++){
			if(left.charAt(i)!=right.charAt(i)){
				return left.substring(0,i);
			}
		}
		return left.substring(0,min);
	}
	
	
	
}







