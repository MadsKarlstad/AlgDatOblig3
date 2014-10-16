/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algdatoblig2;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author madsmkarlstad
 */
public class Driver{
    public static void main(String[] args){
    DobbeltLenketListe<Integer> liste = new DobbeltLenketListe<>();

    for (int k = 1; k <= 13; k++)
    {
      liste.leggInn(k);
    }

    for (Iterator<Integer> i = liste.iterator(); i.hasNext();)
    {
      int verdi = i.next();
      if (verdi % 2 == 1)
      {
        i.remove(); // fjerner oddetallene
      }
    }

    int antall = liste.antall();
    String print = liste.omvendtString();
    String print1 = liste.toString();
    System.out.println("Omvendt: " +print + "\nVanlig: " + print1 + "\nAntall: " + liste.antall());
    }


}
