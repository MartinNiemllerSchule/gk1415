package josephus;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author frank.baethge
 */
public class Person {
  public Integer nummer;
  public Person nächste;
  public Person vorherige;
  
  public Person(Integer nr){
    nummer = nr;
    nächste = this;
    vorherige = this;
  }
  
  /**
  * erstellt eine neue Person mit Nummer nr
  * und fügt sie vor der aktuellen Person ein 
  * somit kommt die neue Person an das Ende des Rings (falls es ein Ende im Ring gibt)
  */
  public void einfügen(Integer nr) {
    Person r = new Person(nr);
    r.nächste = this;
    r.vorherige = vorherige;
    vorherige.nächste = r;
    vorherige = r;
  }
  
  /**
  * tötet den Nächsten im Ring
  */
  public void entferne() {
    nächste.nächste.vorherige = this;
    nächste = nächste.nächste;
  }

  /*
  * gibt alle Nummern der Personen im Ring aus
  */
  public void ausgeben() {
    Person aktuell = this;
    System.out.print(" " + aktuell.nummer);
    while (aktuell != vorherige) {
      // solange die Person nicht die letzte Person im Ring erreicht wurde
      aktuell = aktuell.nächste;
      System.out.print(" "+aktuell.nummer);
    }
    System.out.println();
  }

}
