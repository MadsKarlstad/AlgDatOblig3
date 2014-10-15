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
    liste.leggInn(1);
    Iterator<Integer> i = liste.iterator();
      i.next();  // kaller next() i en tom liste

    }


}
