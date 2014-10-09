/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package primzahl2;

/**
 *
 * @author frank.baethge
 */
public class PrimzahlListe {
  public int pz; // speichert die jeweilige Primzahl ab
  public PrimzahlListe nächste; // zeigt auf das nächste Listenelement
  
  // Konstruktor
  public PrimzahlListe() {
    pz = 0;
    nächste = null;
  }
  // Konstruktor
  public PrimzahlListe(int primzahl) {
    pz = primzahl;
    nächste = null;
  }
  
  public void anhängen(PrimzahlListe p) {
    // Achtung, das kann nur für das letzte Element der Liste richtig sein
    nächste = p;
  }
  
  public void ausgeben() {
    PrimzahlListe p = this;
    while (p != null) {
      System.out.print(" " + p.pz);
      p = p.nächste;
    }
    System.out.println();
  }
  
  public boolean istPrim(Integer zahl) {
    PrimzahlListe p = this; // istPrim wird immer mit erste aufgerufen
    while (p != null) {
      if (zahl % p.pz == 0) {
        return false;
      } else {
        p = p.nächste;
      }
    }
    return true;
  }
}
