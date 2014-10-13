/*
 * Sieb des Eratosthenes
 *  ermittelt alle Primzahlen bis ...
 */
package eratosthenes;

/**
 *
 * @author frank.baethge
 */
public class Eratosthenes {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    // Sieb des Eratosthenes (ohne die Verwendung von Objekten)
    int[] feld = new int[5001];
    feld[0] = 1;
    feld[1] = 1;
    
    int aktuellePrimzahl = 1;
    while (aktuellePrimzahl < feld.length-1) {
      // suche die nächste noch nicht gestrichene Zahl im feld
      do {
        aktuellePrimzahl++;
      } while ((aktuellePrimzahl < feld.length-1) && (feld[aktuellePrimzahl] != 0));
      
      // Streiche alle Vielfachen
      for (int vielfache = 2 * aktuellePrimzahl; vielfache <= feld.length-1; vielfache += aktuellePrimzahl) {
        feld[vielfache]++;
      }
    }
    
    // ausgeben
    for (int i=2; i<=feld.length-1; i++){
      if (feld[i] == 0) {
        System.out.print(" "+i);
      }
    }
  }
}
