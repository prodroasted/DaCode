import java.util.Arrays;

public class Opgave2 {

	public static int højesteAntalBenbrud(int[][] values) {
		// TODO
		int maxValue = 0;
		for (int i = 0; i < values.length; i++) {
			for (int j = 0; j < values[i].length; j++) {
				if (maxValue < values[i][j]){
					maxValue = values[i][j];
				}
			}
		}
		return maxValue;
	}

	public static int[] samledeAntalBenbrudPrÅr(int[][] values) {
		// TODO
		int[] samlet = new int[4];
		int count = 0;
		for (int i = 0; i < values.length; i++) {
			for (int j = 0; j < values[i].length; j++) {
				for (int k = 0; k < samlet.length; k++) {
					values[i].length += samlet[k];
				}
			}
		}
		return samlet;
	}

	public static int[] samledeAntalBenbrudPrMåned(int[][] values) {
		// TODO
		return null;
	}

	public static int månedMedHøjstAntalBenbrud(int[][] values) {
		// TODO
		return -1;
	}

	public static void udskrivArray(int[][] values) {
		for (int i = 0; i < values.length; i++) {
			System.out.print("År " + (2015 + i) + ": ");
			for (int j = 0; j < values[i].length; j++) {
				System.out.printf("%5d", values[i][j]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] benbrud = {
				{ 98, 117, 120, 80, 98, 56, 66, 45, 78, 86, 89, 99 },
				{ 101, 99, 75, 67, 79, 56, 50, 57, 88, 77, 75, 96 },
				{ 112, 95, 110, 97, 89, 65, 44, 56, 88, 67, 45, 80 },
				{ 89, 92, 89, 89, 89, 89, 89, 89, 89, 89, 89, 89 }
		};
		udskrivArray(benbrud);
		System.out.println();

		System.out.print("Max antal benbrud i en måned: " );
		System.out.println(højesteAntalBenbrud(benbrud));

		System.out.print("Samlede antal benbrud pr. år: " );
		System.out.println(Arrays.toString(samledeAntalBenbrudPrÅr(benbrud)));

		System.out.print("Samlede antal benbrud pr. måned: " );
		System.out.println(Arrays.toString(samledeAntalBenbrudPrMåned(benbrud)));

		System.out.print("Indeks for måneden med max antal benbrud pr. måned: " );
		System.out.println(månedMedHøjstAntalBenbrud(benbrud));
	}
}
