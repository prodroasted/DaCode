import java.util.Arrays;

public class Opgave1 {

	// Opdater arrayet 'tabel', så alle elementer indeholder værdien 11,
	public static void alle11(int[][] tabel) {
		//TODO
		for (int i = 0; i < tabel.length; i++){
			for (int j = 0; j < tabel[i].length; j++){
				tabel[i][j] = 11;
			}
		}
	}

	// Opdaterer arrayet 'tabel', så elementerne indeholder værdierne 1..antal rækker*antal søjler.
	// Med 5 rækker og 8 søjler: 1..8 i første række, 9..16 i anden række, osv.
	public static void alleTal(int[][] tabel) {
		//TODO
		int count = 1;
		for (int i = 0; i < tabel.length; i++){
			for ( int j = 0; j < tabel[i].length; j++){
				tabel[i][j] = count++;
			}
		}
	}

	// Opdater arrayet 'tabel', så alle elementerne i rækken 'row' har værdien 'value'.
	public static void opdaterRække(int[][] tabel, int row, int value) {
		//TODO
		for (int i = 0; i < tabel.length; i++){
			for (int j = 0; j < tabel[i].length; j++){
				if(i == row) {
					tabel[i][j] = value;
				}
			}
		}
	}

	// Opdater arrayet 'tabel', så alle elementerne i søjlen 'col' har værdien 'value'.
	public static void opdaterColumn(int[][] tabel, int col, int value) {
		//TODO

		for(int i = 0; i < tabel.length; i++){
			for (int j = 0; j < tabel[i].length; j++){
				if (j == col){
					tabel[i][j] = value;
				}
			}
		}
	}
	
	// Opdater arrayet 'tabel', så alle elementerne i kanterne har værdien 'value'
	public static void opdaterKant(int[][] tabel, int value) {
		//TODO
		for (int i = 0; i < tabel.length; i++){
			for (int j = 0; j < tabel[i].length; j++){
				if (i == 0 || j == 0 || i == tabel.length -1 || j == tabel[i].length -1){
					tabel[i][j] = value;
				}
			}
		}
	}

	// Udskriv arrayet 'array2'.
	public static void udskrivArray2(int[][] array2) {
		for (int i = 0; i < array2.length; i++) {
			for (int j = 0; j < array2[i].length; j++) {
				System.out.printf("%4d", array2[i][j]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int ROW = 5;
		int COL = 8;
		int[][] values = new int[ROW][COL];
		udskrivArray2(values);
		System.out.println();

		alle11(values);
		System.out.println("2-dim array med 11 på alle pladser:");
		udskrivArray2(values);
		System.out.println();

		alleTal(values);
		System.out.println("2-dim array med værdierne 1..40 (ROW*COL):");
		udskrivArray2(values);
		System.out.println();

		opdaterRække(values, 2, 7);
		System.out.println("2-dim array med værdien 7 i række 2:");
		udskrivArray2(values);
		System.out.println();

		values = new int[ROW][COL];
		opdaterColumn(values, 3, 7);
		System.out.println("2-dim array med værdien 7 i søjle 3:");
		udskrivArray2(values);
		System.out.println();

		values = new int[ROW][COL];
		opdaterKant(values, 7);
		System.out.println("2-dim array med værdien 7 i alle kanter:");
		udskrivArray2(values);
		System.out.println();
	}
}
