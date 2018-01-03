
//找规律
public class Test6 {

	public static String convert(String s, int numRows) {
		StringBuilder sb=new StringBuilder();
		int length=s.length();
		int circle=numRows+numRows-2;
		if(numRows==1){
			circle=1;
		}
		for(int i=0;i<numRows;i++){
			if(i==0||i==numRows-1){
				int j=0;
				int index=j*circle+i;
				while(index<length){
					sb.append(s.charAt(index));
					j++;
					index=j*circle+i;
				}
			}else{
				int j=0;
				while(true){
					int index1=j*circle+i;
					int index2=(j+1)*circle-i;
					if(index1>=length) break; else sb.append(s.charAt(index1));
					if(index2>=length) break; else sb.append(s.charAt(index2));
					j++;
				}
			}
		}
		return sb.toString();
    }
	
	public static void main(String[] args) {
		System.out.println(convert("A", 1));
	}
	
}
