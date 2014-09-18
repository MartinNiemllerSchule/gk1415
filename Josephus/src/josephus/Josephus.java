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
    
    System.out.println("p hat Nr:" + p.nummer + " Nachfolger ist Nr: " + p.nächste.nummer + " Das Schwert hat Nr: " + p.nächste.nächste.nummer + " tod ist Nr: " + p.nächste.nächste.nächste.nummer);
  }
}
