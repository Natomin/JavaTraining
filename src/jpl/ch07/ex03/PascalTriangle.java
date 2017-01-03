package jpl.ch07.ex03;

//深さが12のパスカルの三角形を計算するプログラムを作成する。
//三角形の各行を適切な長さの配列とし、各行の配列を長さ12のint配列の配列に格納する。
//表示メソッドを変更することなく、12を他の定数に変更できるようにする。
public class PascalTriangle {
	private int MAX;
	private int[][] pascalTriangle;

	public PascalTriangle(int depth) {
		MAX = depth;
		pascalTriangle = new int[MAX][];
		for (int i = 0; i < MAX; i++) {
			int[] row = new int[i + 1];
			pascalTriangle[i] = row;
			for (int j = 0; j <= i; j++) {
				if (j == 0) {
					row[j] = 1;
				} else if (j == i) {
					row[j] = 1;
				} else {
					row[j] = pascalTriangle[i - 1][j] + pascalTriangle[i - 1][j - 1];
				}
			}
		}
		print();
	}

	private void print() {
		for (int i = 0; i < MAX; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(pascalTriangle[i][j]);
			}
			System.out.println("");
		}
	}
}
