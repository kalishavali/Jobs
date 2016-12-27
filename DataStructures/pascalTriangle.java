package ArraysPckg;

import java.util.Arrays;

public class pascalTriangle {
	public static void main(String[] args) {
		int[][] arr=new int[11][];
		for(int i=0;i<arr.length;i++){
			arr[i]=new int[i+1];
			arr[i][0]=1;
			arr[i][i]=1;
			for(int j=1;j<i;j++){
				arr[i][j]=arr[i-1][j-1]+arr[i-1][j];
			}
		}
		System.out.println(Arrays.deepToString(arr));
	}
}
