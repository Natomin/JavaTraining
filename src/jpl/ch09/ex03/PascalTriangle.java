package jpl.ch09.ex03;
//本章で学んだ演算子を使用して、練習問題7.3の解答をより明瞭、あるいはより簡潔に書くことができるか検討する
public class PascalTriangle {
	private int MAX;
	private int[][] pascalTriangle;
	
	public PascalTriangle(int depth){
		MAX = depth;
		pascalTriangle = new int[MAX][];
		for(int i = 0; i < MAX; i++){
			int[] row = new int[i+1];
			pascalTriangle[i] = row;
			for (int j = 0; j <= i ; j++) {
				if(j == 0 || j == i){//論理演算子（条件和）を使用
					row[j] = 1;
				}else{
					row[j] = pascalTriangle[i-1][j] + pascalTriangle[i-1][j-1];
				}	
			}
		}
		print();
	}
	private void print(){
		for(int i = 0; i < MAX; i++){
			for (int j = 0; j <= i ; j++) {
				System.out.print(pascalTriangle[i][j]);
			}
			System.out.println("");
		}
	}

}
