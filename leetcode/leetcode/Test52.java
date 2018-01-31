import java.util.Arrays;

//递归+回溯
public class Test52 {
	static int count=0;
	
	public static int totalNQueens(int n) {
		char[][] board=new char[n][n];
        for(int index=0;index<n;index++){
        	Arrays.fill(board[index], '.');
        }
        solve(board, 0, n);
        return count;
    }
	
	private static void solve(char[][] board,int row,int length){
		if(row==length){
			count++;
			return;
		}
		
		for(int col=0;col<length;col++){
			board[row][col]='Q';
			if(isValid(board,row,col,length)){
				solve(board, row+1, length);
			}
			
			board[row][col]='.';
		}
	}
	
	private static boolean isValid(char[][] board,int row,int col,int length){
		//行判断
		for(int j=0;j<length;j++){
			if(j!=col&&board[row][j]=='Q'){
				return false;
			}
		}
		
		//列判断
		for(int i=0;i<length;i++){
			if(i!=row&&board[i][col]=='Q'){
				return false;
			}
		}
		
		//左斜线判断
		for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
			if(board[i][j]=='Q'){
				return false;
			}
		}
		for(int i=row+1,j=col+1;i<length&&j<length;i++,j++){
			if(board[i][j]=='Q'){
				return false;
			}
		}
		
		//右斜线判断
		for(int i=row+1,j=col-1;i<length&&j>=0;i++,j--){
			if(board[i][j]=='Q'){
				return false;
			}
		}
		for(int i=row-1,j=col+1;i>=0&&j<length;i--,j++){
			if(board[i][j]=='Q'){
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(totalNQueens(1));
	}
	
}
