/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package josephus;

/**
 *
 * @author frank.baethge
 */
public class Josephus {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    // Personen anlegen
    Person p = new Person(1);
    for (int i = 2; i <= 41; i++) {
      p.einfügen(i);
    }
    
    while (p != p.nächste) {
      p.entferne(); // töte den Nächsten
      p.ausgeben(); // gib alle Nummern der Personen im Ring aus
      p = p.nächste.nächste; // übergib das Schwert an den nun Übernächsten
    }
  }
}
