
//找规律
public class Test38 {

	public static String countAndSay(int n) {
        String init="1";
        for(int i=1;i<n;i++){
        	StringBuilder sb=new StringBuilder();
        	int preNum=0;
        	char preCh='.';
        	for(int j=0;j<init.length();j++){
        		Character ch=init.charAt(j);
        		if(ch!=preCh){
        			if(preNum>0){
        				sb.append((char)(preNum+48));
            			sb.append(preCh);
        			}
        			preCh=ch;
        			preNum=1;
        		}else{
        			preNum++;
        		}
        	}
        	if(preNum>0){
				sb.append((char)(preNum+48));
    			sb.append(preCh);
			}
        	init=sb.toString();
        }
        return init;
    }
	
	public static void main(String[] args) {
		System.out.println(countAndSay(5));
	}
	
}
