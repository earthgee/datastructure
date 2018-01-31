import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//n皇后 递归加回溯
public class Test51 {

	public List<List<String>> solveNQueens(int n) {
        char[][] board=new char[n][n];
        for(int index=0;index<n;index++){
        	Arrays.fill(board[index], '.');
        }
        Arrays.fill(board, '.');
        List<List<String>> res=new ArrayList<>();
        solve(board, 0, res, n);
        return res;
    }
	
	private void solve(char[][] board,int row,List<List<String>> res,int length){
		if(row==length){
			List<String> tmp=new ArrayList<>();
			for(int i=0;i<length;i++){
				StringBuilder sb=new StringBuilder();
				for(int j=0;j<length;j++){
					sb.append(board[i][j]);
				}
				tmp.add(sb.toString());
			}
			res.add(tmp);
			
			return;
		}
		
		for(int col=0;col<length;col++){
			board[row][col]='Q';
			if(isValid(board,row,col,length)){
				solve(board, row+1, res, length);
			}
			
			board[row][col]='.';
		}
	}
	
	private boolean isValid(char[][] board,int row,int col,int length){
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
	
}
