
public class Test28 {

	//暴力
	public int strStr(String haystack, String needle) {
		int m=haystack.length();
		int n=needle.length();
		for(int i=0;i<=m-n;i++){
			int j;
			for(j=0;j<n;j++){
				if(haystack.charAt(i+j)!=needle.charAt(j)){
					break;
				}
			}
			if(j==n){
				return i;
			}
		}
		
		return -1;
    }
	
	//kmp
	public static int strStr2(String haystack, String needle){
		if(needle.length()==0){
			return 0;
		}
		int m=haystack.length();
		int n=needle.length();
		
		int[] next=new int[n+1];
		next=getNext(needle,next);
		
		int j=0;
		for(int i=1;i<=m;i++){
			while(j>0&&needle.charAt(j)!=haystack.charAt(i-1)) j=next[j];
			if(needle.charAt(j)==haystack.charAt(i-1)){
				j++;
			}
			if(j==n){
				return i-j;
			}
		}
		
		return -1;
	}
	
	public static int[] getNext(String needle,int[] next){
		int length=needle.length();
		next[1]=0;
		int j=0;
		for(int i=2;i<=length;i++){
			while(j>0&&needle.charAt(j)!=needle.charAt(i-1)) j=next[j];
			if(needle.charAt(j)==needle.charAt(i-1)){
				j++;
			}
			
			next[i]=j;
		}
		
		return next;
	}
	
	public static void main(String[] args) {
		String mString="aaaaa";
		String nString="bba";
		System.out.println(strStr2(mString, nString));
	}
	
}







