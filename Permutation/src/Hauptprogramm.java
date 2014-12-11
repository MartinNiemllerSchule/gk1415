import java.util.Arrays;

/**
 * Created by frank on 01.12.14.
 */
public class Hauptprogramm {
	public static void main(String args[]) {
		Permutation p = new Permutation(10);
		String s = Arrays.toString(p.gibEine());
		System.out.println("Eine davon: " + s);
	}
}