//矩阵某个元素为0，全行全列都变成0，用每一行和每一列来记录 就可以不使用额外空间
public class Test73 {

	public void setZeroes(int[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;
        
        boolean rowFlag=false;
        boolean colFlag=false;
        
        for(int i=0;i<col;i++){
        	if(matrix[0][i]==0){
        		rowFlag=true;
        	}
        }
        
        for(int i=0;i<row;i++){
        	if(matrix[i][0]==0){
        		colFlag=true;
        	}
        }
        
        for(int i=1;i<row;i++){
        	for(int j=1;j<col;j++){
        		if(matrix[i][j]==0){
        			matrix[i][0]=0;
        			matrix[0][j]=0;
        		}
        	}
        }
        
        for(int i=1;i<row;i++){
        	for(int j=1;j<col;j++){
        		if(matrix[i][0]==0||matrix[0][j]==0){
        			matrix[i][j]=0;
        		}
        	}
        }
        
        if(rowFlag){
        	for(int i=0;i<col;i++){
            	matrix[0][i]=0;
            }
        }
        
        if(colFlag){
        	for(int i=0;i<row;i++){
            	matrix[i][0]=0;
            }
        }
        
    }
	
}
