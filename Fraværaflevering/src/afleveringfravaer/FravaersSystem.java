package afleveringfravaer;

public class FravaersSystem {
	/**
	 * Fraværstallene udskrives på skærmen
	 *
	 * @param fravaer
	 */
	public void udskrivFravaer(int[][] fravaer) {
		// TODO opgave 1
		for(int row = 0; row < fravaer.length; row++){
			for(int col = 0; col < fravaer[row].length; col++){
				System.out.println(fravaer[row][col] + " ");
			}
			System.out.println();
		}
	}

	/**
	 * Returnerer det samlede antal fravaerdage over 12 måneder for eleven med
	 * elevnr.
	 *
	 * @param fravaer
	 * @param elevNr
	 * @return
	 */
	public int samletFravaer(int[][] fravaer, int elevNr) {
		int samlet = 0;
		for(int i = 0; i < fravaer.length; i++){
			samlet += fravaer[i][elevNr];
		}
		// TODO opgave 2
		return samlet;
	}

	/**
	 * Returnerer det gennemsnitlige antal fraværsdage pr måned for eleven med
	 * elevNr.
	 *
	 * @param fravaer
	 * @param elevNr
	 * @return
	 */
	public double gennemsnit(int[][] fravaer, int elevNr) {
		int snit = 0;
		for (int i = 0; i < fravaer.length; i++){
			if(fravaer[i].length > 0 ){
		//		snit += fravaer[i] % fravaer[i][elevNr];
			}
		}
		// TODO opgave 3
		return -1;
	}

	/**
	 * Returnerer antallet af elever der ikke har haft fravær i de 12 måneder.
	 *
	 * @param fravaer
	 * @return
	 */
	public int antalUdenFravaer(int[][] fravaer) {
		// TODO opgave 4
		return -1;
	}

	/**
	 * Returnerer elevNr for den elev der har haft mest fravær igennem de 12
	 * måneder. Hvis flere elever har haft højst fravær, returneres elevnummer
	 * for en af disse.
	 *
	 * @param fravaer
	 * @return
	 */
	public int mestFravaer(int[][] fravaer) {
		// TODO opgave 5
		return -1;
	}

	/**
	 * Registrerer at elenven med elevNr ikke har haft fravær i nogen af de 12
	 * måneder.
	 *
	 * @param fravaer
	 * @param elevNr
	 */
	public void nulstil(int[][] fravaer, int elevNr) {
		for(int i = 0; i < fravaer.length; i++){
			if (fravaer[elevNr].length > 0){

			}
		}
		// TODO opgave 6
	}
}
