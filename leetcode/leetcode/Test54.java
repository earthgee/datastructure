import java.util.ArrayList;
import java.util.List;

//找规律
public class Test54 {
	
	//0 右 1 下 2 左 3 上
	public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans=new ArrayList<>();
        if(matrix.length==0){
        	return ans;
        }
        int arrow=0;
        int width=matrix.length; //行数
        int height=matrix[0].length; //列数
        boolean[][] mask=new boolean[width][height];
        int length=width*height;
        int i=0,j=0;
        while(ans.size()<length){
        	ans.add(matrix[i][j]);
        	mask[i][j]=true;
        	if(arrow==0){
        		if(j+1<height&&!mask[i][j+1]){
        			j++;
        		}else{
        			arrow=1;
        		}
        	}
        	
        	if(arrow==1){
        		if(i+1<width&&!mask[i+1][j]){
        			i++;
        		}else{
        			arrow=2;
        		}
        	}
        	
        	if(arrow==2){
        		if(j-1>=0&&!mask[i][j-1]){
        			j--;
        		}else{
        			arrow=3;
        		}
        	}
        	
        	if(arrow==3){
        		if(i-1>=0&&!mask[i-1][j]){
        			i--;
        		}else{
        			arrow=0;
        			if(j+1<height&&!mask[i][j+1]){
            			j++;
            		}
        		}
        	}
        }
        
        return ans;
    }
	
	public static void main(String[] args) {
		int[][] matrix={{1,2,3},{4,5,6},{7,8,9}};
		spiralOrder(matrix);
	}
	
}
