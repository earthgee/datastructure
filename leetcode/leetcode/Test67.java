//常规题
public class Test67 {

	public static String addBinary(String a, String b) {
        int length1=a.length();
        int length2=b.length();
        int min=length1>length2?length2:length1;
        
        StringBuilder sb=new StringBuilder();
        int index1=length1-1;
        int index2=length2-1;
        int add=0;
        for(int i=0;i<min;i++){
        	int ca=a.charAt(index1)-'0';
        	int cb=b.charAt(index2)-'0';
        	
        	int shang=(ca+cb+add)%2;
        	add=(ca+cb+add)/2;
        	sb.append(shang);
        	
        	index1--;index2--;
        }
        
        if(index1>=0){
        	for(;index1>=0;index1--){
        		int c=a.charAt(index1)-'0';
        		int shang=(c+add)%2;
        		add=(c+add)/2;
        		sb.append(shang);
        	}
        }
        
        if(index2>=0){
        	for(;index2>=0;index2--){
        		int c=b.charAt(index2)-'0';
        		int shang=(c+add)%2;
        		add=(c+add)/2;
        		sb.append(shang);
        	}
        }
        
        if(add>0){
        	sb.append(add);
        }
        
        String s=sb.toString();
        StringBuilder sbreverse=new StringBuilder();
        int endLength=s.length();
        for(int i=endLength-1;i>=0;i--){
        	sbreverse.append(s.charAt(i));
        }
        
        return sbreverse.toString();
    }
	
	public static void main(String[] args) {
		System.out.println(addBinary("11", "1"));
	}
	
}
