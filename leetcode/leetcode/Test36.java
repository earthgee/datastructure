import java.util.HashMap;
import java.util.HashSet;

//数独合法判断 hashtable应用
public class Test36 {
	
	public boolean isValidSudoku(char[][] board) {
		for(int i=0;i<9;i++){
			HashSet<Character> rowMap=new HashSet();
			HashSet<Character> colMap=new HashSet();
			HashSet<Character> boxMap=new HashSet();
			
			for(int j=0;j<9;j++){
				Character current=board[i][j];
				if(current=='.'){
					continue;
				}
				if(rowMap.contains(current)){
					return false;
				}else{
					rowMap.add(current);
				}
			}
			
			for(int j=0;j<9;j++){
				Character current=board[j][i];
				if(current=='.'){
					continue;
				}
				if(colMap.contains(current)){
					return false;
				}else{
					colMap.add(current);
				}
			}
			
			for(int j=0;j<9;j++){
				Character current=board[i/3*3+j/3][i%3*3+j%3];
				if(current=='.'){
					continue;
				}
				if(boxMap.contains(current)){
					return false;
				}else{
					boxMap.add(current);
				}
			}
		}
		
		return true;
    }
	
}
