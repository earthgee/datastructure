
public class Test48 {

	//从外圈到内圈 四个互换
	public void rotate(int[][] matrix) {
        int n=matrix.length;
        for(int i=0;i<n/2;i++){
        	for(int j=i;j<n-i-1;j++){
        		int tmp=matrix[i][j];
        		matrix[i][j]=matrix[n-j-1][i];
        		matrix[n-j-1][i]=matrix[n-i-1][n-j-1];
        		matrix[n-i-1][n-j-1]=matrix[j][n-i-1];
        		matrix[j][n-i-1]=tmp;
        	}
        }
    }
	
	//先沿副对角线翻转 后沿水平中线翻转
	public void rotate2(int[][] matrix){
		int n=matrix.length;
		
		for(int i=0;i<n-1;i++){
			for(int j=0;j<n-i-1;j++){
				int tmp=matrix[i][j];
				matrix[i][j]=matrix[n-j-1][n-i-1];
				matrix[n-j-1][n-i-1]=tmp;
			}
		}
		
		for(int i=0;i<n/2;i++){
			for(int j=0;j<n;j++){
				int tmp=matrix[i][j];
				matrix[i][j]=matrix[n-i-1][j];
				matrix[n-i-1][j]=tmp;
			}
		}
		
		
	}
	
}






