/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package primzahl2;

/**
 *
 * @author frank.baethge
 */
public class Primzahl2 {

  private static PrimzahlListe erste = new PrimzahlListe(2);
  
  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    // Füllen der PrimzahlListe
    PrimzahlListe letzte = erste;  
    // erstmal mit der Primzahl 3
    PrimzahlListe p = new PrimzahlListe(3);
    letzte.anhängen(p);
    letzte = p;

    // Füllen mit allen Primzahlen bis 5000
    for (Integer i = 5; i < 5001; i += 2) {
      if (erste.istPrim(i)) {
        p = new PrimzahlListe(i);
        letzte.anhängen(p);
        letzte = p;
      }        
    }
    // und Ausgeben der gefundenen Primzahlen
    erste.ausgeben();
  }
}