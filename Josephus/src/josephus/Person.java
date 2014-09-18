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
  
  public void einfügen(Integer nr) {
    Person r = new Person(nr);
    r.nächste = this;
    r.vorherige = vorherige;
    vorherige.nächste = r;
    vorherige = r;
  }
}
