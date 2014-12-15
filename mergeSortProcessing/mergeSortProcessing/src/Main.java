package info.baethge;
import processing.core.*;
import java.util.Random;

public class Main extends PApplet{

	protected final Integer länge = 50; // Anzahl der Feldelemente
	protected final Integer größe = 9; // Kantenlänge eines Quadrates
	protected  Integer zeile = 0;   // Zeile, in der die jeweilige Feldbelegung angezeigt wird;

	public int[] feld = new int[länge];

	public static void main(String[] args) {
		PApplet.main(new String[]{"--present", "info.baethge.Main" });
	}

	public void setup() {
		size(länge*größe, länge*größe);
		background(128);
		fülleFeldMitZufallszahlen(255);
		ausgeben2Str(feld, 0);
		mergeSort(feld, 0);
		save("mergeSort09.png");
	}

	public void draw() {
		stop();
	}

	private void ausgeben2Str(int[] liste, int offset) {
		int i;
		for(i = 0; i < liste.length; i++) {
			feld[i + offset] = liste[i];
		}
		System.out.print("offset: "+offset);
		for (i = 0; i < feld.length; i++) {
			System.out.print(" " + feld[i]);
			fill(feld[i]);
			rect(i*größe,zeile*größe,größe,größe);
		}
		System.out.println();
		zeile++;
	}

	private void fülleFeldMitZufallszahlen(Integer zahlenBis) {
		int i,j, merke;
		// fülle mit Grauwerten
		for (i = 0; i < feld.length; i++) {
			feld[i] = i*5 + (255 - länge * 5);
		}
		// permutiere zufällig
		Random rand = new Random();
		for (i = 0; i < feld.length; i++) {
			j = rand.nextInt(länge - i) + i;
			merke = feld[i];
			feld[i] = feld[j];
			feld[j] = merke;
		}
	}

	public int[] mergeSort(int [] liste, int offset) {
		if (liste.length <= 1) {
			return liste;
		}

		// Teile die Liste in zwei TeilListen (erste und zweite sind wieder Listen)
		int[] erste = new int[liste.length / 2];
		int[] zweite = new int[liste.length - erste.length];
		System.arraycopy(liste, 0, erste, 0, erste.length);
		System.arraycopy(liste, erste.length, zweite, 0, zweite.length);

		// Sortiere jede Teilliste
		mergeSort(erste, offset);
		mergeSort(zweite, offset + erste.length);

		// Mische die Teillisten, überschreibe dabei das Feld mit den sortierten Werten
		merge(erste, zweite, liste, offset);
		return liste;
	}

	private void merge(int[] erste, int[] zweite, int[] ergebnis, int offset) {
		// Mische die beiden Listen der Größe nach
		// e durchläuft die erste Liste
		int e = 0;
		// z durchläuft die zweite Liste
		int z = 0;

		// f ist die jeweilige Position im ergebnis
		int f = 0;
		// solange weder e noch z zu groß geworden sind, nimm das kleinere Element der beiden Listen
		while (e < erste.length && z < zweite.length) {
			if (erste[e] > zweite[z]) {
				ergebnis[f] = erste[e];
				e++;
			} else {
				ergebnis[f] = zweite[z];
				z++;
			}
			f++;
		}
		// kopiere, was übrig ist (einer der beiden Befehle tut nichts, denn die Länge ist Null
		System.arraycopy(erste, e, ergebnis, f, erste.length - e);
		System.arraycopy(zweite, z, ergebnis, f, zweite.length - z);
		ausgeben2Str(ergebnis, offset);
	}

/*
*
    public static void sort(Adresse[] a) {
        start = System.nanoTime();
        quicksort(a, 0, (a.length - 1));
        ende = System.nanoTime();
    }

    public static void quicksort(Adresse[] a, int links, int rechts) {
        if ((rechts - links) <= 1) {
            return;
        }
        Adresse p = a[links];
        //System.out.println("p=" + p + " links: " + links + " rechts: " + rechts);
        int z1 = links;
        int z2 = rechts;
        do {
            if (a[z1].compareTo(p) > 0) {
                if (a[z2].compareTo(p) <= 0) {
                    Adresse zwischenwert = a[z1];
                    a[z1] = a[z2];
                    a[z2] = zwischenwert;
                } else {
                    z2--;
                }
            } else {
                z1++;
            }
        } while (z1 < z2);
        Adresse zwischenwert = a[z1 - 1];
        a[z1 - 1] = a[links];
        a[links] = zwischenwert;
        quicksort(a, links, (z1 - 1));
        quicksort(a, z2, rechts);
    }
* */
}