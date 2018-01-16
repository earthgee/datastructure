//dfs 递归加回溯
public class Test37 {

	public static void solveSudoku(char[][] board) {
		solve(board);
    }
	
	private static boolean solve(char[][] board){
		for(int i=0;i<9;i++){
        	for(int j=0;j<9;j++){
        		if(board[i][j]=='.'){
        			for(int k=1;k<=9;k++){
        				board[i][j]=(char) (k+48);
        				if(isValid(board,i,j)&&solve(board)){
        					return true;
        				}
        				board[i][j]='.';
        			}
        			return false;
        		}
        	}
        }
		return true;
	}
	
	private static boolean isValid(char[][] board,int x,int y){
		int i,j;
		for(i=0;i<9;i++){
			if(i!=x&&board[x][y]==board[i][y]){
				return false;
			}
		}
		for(j=0;j<9;j++){
			if(y!=j&&board[x][y]==board[x][j]){
				return false;
			}
		}
		for(i=x/3*3;i<(x/3+1)*3;i++){
			for(j=y/3*3;j<(y/3+1)*3;j++){
				if(i!=x&&y!=j&&board[x][y]==board[i][j]){
					return false;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		
	}
	
}






