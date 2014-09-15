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
    // zwei Person anlegen und probieren, wie auf die Personen zugegriffen werden kann
  	// Person ist die Klasse und p und q sind Instanzen dieser Klasse (also Objekte)
  	// auf "public" Eigenschaften kann man von außen (also hier) zugreifen
    Person p = new Person(1);
    Person q = new Person(2);
    p.nächste = p;
    p.vorherige = p;
    p.nächste = q;
    p.vorherige = q;
    q.nächste = p;
    q.vorherige = p;
        
    System.out.println("p hat Nr:" + p.nummer + " Nachfolger ist Nr: " + p.nächste.nummer + " Das Schwert hat Nr: " + p.nächste.nächste.nummer + " tod ist Nr: " + p.nächste.nächste.nächste.nummer);
    System.out.println("q hat Nr:" + q.nummer);
  }
}
