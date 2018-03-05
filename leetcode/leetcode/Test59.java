//逻辑题
public class Test59 {

	//0 右 1 下 2 左 3 上
	public static int[][] generateMatrix(int n) {
		int[][] matrix=new int[n][n];
		int n2=n*n;
		int time=1;
		int arrow=0;
		int row=0,col=0;
		while(time<=n2){
			matrix[row][col]=time;
			time++;
			
			if(arrow==0&&col+1<n&&matrix[row][col+1]==0){
				col++;
				continue;
			}else{
				arrow=1;
			}
			
			if(arrow==1&&row+1<n&&matrix[row+1][col]==0){
				row++;
				continue;
			}else{
				arrow=2;
			}
			
			if(arrow==2&&col-1>=0&&matrix[row][col-1]==0){
				col--;
				continue;
			}else{
				arrow=3;
			}
			
			if(arrow==3&&row-1>=0&&matrix[row-1][col]==0){
				row--;
				continue;
			}else{
				arrow=0;
			}
			
			if(arrow==0&&col+1<n&&matrix[row][col+1]==0){
				col++;
			}else{
				arrow=1;
			}
		}
		return matrix;
    }
	
	public static void main(String[] args) {
		generateMatrix(3);
	}
	
}
