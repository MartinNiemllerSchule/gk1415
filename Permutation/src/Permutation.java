import java.util.Random;

/**
 * Created by frank on 01.12.14.
 */
public class Permutation {
	private int[] feld;
	public Permutation(int anzahl) {
		feld = new int[anzahl];
		for(int i = 0; i < feld.length; i++) {
			feld[i] = i;
		}
	}
	public int[] gibEine() {
		Random r = new Random();
		int j;
		for(int i=0; i<feld.length - 1; i++) {
			j = r.nextInt(feld.length - i) + i;
			if (j > i) {
				tausche(i, j);
			}
		}
		return feld;
	}
	private void tausche(int a, int b) {
		int t = feld[a];
		feld[a] = feld[b];
		feld[b] = t;
	}
}