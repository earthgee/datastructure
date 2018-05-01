
//递归＋回溯 可以对数组中每一个点做一次深搜减少思考难度
public class Test79 {

	public static boolean exist(char[][] board, String word) {
		boolean[][] tag=new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
        	for(int j=0;j<board[0].length;j++){
        		if(search(board,tag,i,j,0,word.length(),word)){
        			return true;
        		}
        	}
        }
        return false;
    }
	
	private static boolean search(char[][] board,boolean[][] tag,
			int currentRow,int currentCol,int current,
			int length,String word){
		if(current==length){
			return true;
		}
		
		if(currentRow<0||currentCol<0||currentRow==board.length||
				currentCol==board[0].length||tag[currentRow][currentCol]||
				board[currentRow][currentCol]!=word.charAt(current)){
			return false;
		}

		tag[currentRow][currentCol]=true;
			
		boolean search=search(board, tag, currentRow, currentCol+1, current+1, length, word)||
				search(board, tag, currentRow+1, currentCol, current+1, length, word)||
				search(board, tag, currentRow, currentCol-1, current+1, length, word)||
				search(board, tag, currentRow-1, currentCol, current+1, length, word);
			
		tag[currentRow][currentCol]=false;

		return search;
	}
	
	public static void main(String[] args) {
		char[][] board={
				{'a'},{'a'}
		};
		System.out.println(exist(board, "aaa"));
	}
	
}
