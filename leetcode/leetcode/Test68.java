import java.util.ArrayList;
import java.util.List;

//字符串左右对齐
public class Test68 {

	public static List<String> fullJustify(String[] words, int maxWidth) {
        int length=words.length;
        List<String> wordList=new ArrayList<>();
		for(int startIndex=0;startIndex<length;){
			int endIndex=startIndex;
			//此长度为单词长度累加，不包括空格长度
			int allLength=0;
			for(;endIndex<length;endIndex++){
				int currentLength=words[endIndex].length();
				allLength+=currentLength;
				if(allLength+endIndex-startIndex>maxWidth){
					allLength-=currentLength;
					endIndex--;
					break;
				}else if(allLength+endIndex-startIndex==maxWidth){
					break;
				}
			}
			if(endIndex==length){
				endIndex--;
			}
			
			StringBuilder sb=new StringBuilder();
			if(endIndex>startIndex){
				//多于一个单词
				if(endIndex==length-1){
					//最后一行,靠左
					while(startIndex<=endIndex){
						sb.append(words[startIndex]);
						if(startIndex!=endIndex){
							sb.append(' ');
						}
						
						startIndex++;
					}
					for(int index=sb.length();index<maxWidth;index++){
						sb.append(' ');
					}
				}else{
					int blockLength=endIndex-startIndex;
					int shang=(maxWidth-allLength)/blockLength;
					int yushu=(maxWidth-allLength)%blockLength;
					while(startIndex<=endIndex){
						sb.append(words[startIndex]);
						if(startIndex!=endIndex){
							for(int i=0;i<shang;i++){
								sb.append(' ');
							}
							if(yushu>0){
								sb.append(' ');
								yushu--;
							}
						}
						
						startIndex++;
					}
				}
			}else{
				//只有一个单词
				sb.append(words[startIndex]);
				for(int index=words[startIndex].length();index<maxWidth;index++){
					sb.append(' ');
				}
			}
			wordList.add(sb.toString());
			
			startIndex=endIndex+1;
		}
		
		return wordList;
    }
	
	public static void main(String[] args) {
		String[] test={"What","must","be","shall","be."};
		List<String> list=fullJustify(test, 12);
		for(String str:list){
			System.out.println(str);
		}
	}
	
}
