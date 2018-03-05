//esay
public class Test58 {

	public static int lengthOfLastWord(String s) {
        int lengthOfLastWord=0;
        for(int length=s.length()-1;length>=0;length--){
        	if(s.charAt(length)==' '){
        		if(lengthOfLastWord==0){
        			continue;
        		}else{
        			break;
        		}	
        	}
        	lengthOfLastWord++;
        }
        
        return lengthOfLastWord;
    }
	
	public static void main(String[] args) {
		System.out.println(lengthOfLastWord("Hello World"));
	}
	
}
