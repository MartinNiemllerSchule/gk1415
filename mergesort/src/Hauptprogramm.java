/**
 * Created by frank on 26.11.14.
 */
import java.util.Arrays;

public class Hauptprogramm {
    public static void main(String[] args) {
        String[] namen = {"Mehmet", "Matthias", "Miriam", "Marcel", "Kemal", "Simona", "Nino", "Anas", "Perla", "Felix", "Lara"};
        System.out.println(Arrays.toString(namen));
        String[] sortiert = mergesort(namen);
        System.out.println(Arrays.toString(sortiert));
    }

    public static String[] mergesort(String[] feld) {
        if (feld.length <= 1) {
            return feld; // Rekursion endet mit einer einelementigen Liste
        } else {
            // Unterteile das Feld in zwei Teile: linkesFeld und rechtesFeld
            int mitte = feld.length / 2;
            String[] linkesFeld = new String[mitte];
            String[] rechtesFeld = new String[feld.length - linkesFeld.length];
            // Kopiere die Daten aus dem Feld in die Teile
            System.arraycopy(feld, 0, linkesFeld, 0, linkesFeld.length);
            System.arraycopy(feld, linkesFeld.length, rechtesFeld, 0, rechtesFeld.length);
            // rekursives Aufrufen, also Sortieren der Teilfelder
            mergesort(linkesFeld);
            mergesort(rechtesFeld);
            // Verschmelzen der bereits sortierten Teilfelder
            merge(linkesFeld,rechtesFeld,feld);
            return feld;
        }
    }

    public static void merge(String[] erstes, String[] zweites, String[] ergebnis) {
        // Verschmelze die beiden Felder der Größe nach
        int e = 0;  // e durchläuft das erste Feld
        int z = 0;  // z durchläuft das zweite Feld
        int f = 0;  // f ist die jeweilige Position im ergebnis
        // solange weder e noch z zu groß geworden sind, nimm das kleinere Element der beiden Listen
        while (e < erstes.length && z < zweites.length) {
            if (erstes[e].compareTo(zweites[z]) < 0) {
                ergebnis[f] = erstes[e];
                e++;
            } else {
                ergebnis[f] = zweites[z];
                z++;
            }
            f++;
        }
        // kopiere, was übrig ist (einer der beiden Befehle tut nichts, denn die Länge ist Null
        System.arraycopy(erstes, e, ergebnis, f, erstes.length - e);
        System.arraycopy(zweites, z, ergebnis, f, zweites.length - z);
    }
}