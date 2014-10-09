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

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    // 
    PrimzahlListe erste = new PrimzahlListe(2);
    PrimzahlListe letzte = erste;
    
    PrimzahlListe p = new PrimzahlListe(3);
    letzte.anhängen(p);
    letzte = p;
    
    for (Integer i = 5; i < 5001; i += 2) {
      if (erste.istPrim(i)) {
        p = new PrimzahlListe(i);
        letzte.anhängen(p);
        letzte = p;
      }        
    }
    erste.ausgeben();
  }
}
