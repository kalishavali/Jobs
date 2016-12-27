package tests;

public class SpiralForm {
	public static void spiralMatrix(int[][] array){
		int minCol=0;
		int maxCol=array.length-1;
		int minRow=0;
		int maxRow=array.length-1;
		int value=1;
		while( value<=Math.pow(2,array.length) ){
			for(int i=minCol;i<=maxCol;i++){
				System.out.print(array[minRow][i]+" ");
				value++;
			}
			for(int i=minRow+1;i<=maxRow;i++){
				System.out.print(array[i][maxCol]+" ");
			}
			for(int i=maxCol-1;i>=minCol;i--){
				System.out.print(array[maxRow][i]+" ");
			}
			for(int i=maxRow-1;i>=minRow+1;i--){
				System.out.print(array[i][minCol]+" ");
			}
			minRow++;
			minCol++;
			maxCol--;
			maxRow--;
		}
	}
	public static void main(String[] args) {
		int[][] arr={  {1,  2,  3,  4,  5},
					   {6,  7,  8,  9,  10},
					   {11, 12, 13, 14, 15},
					   {16, 17, 18, 19, 20},
					   {21, 22, 23, 24, 25}  };
		spiralMatrix(arr);
	}
}
