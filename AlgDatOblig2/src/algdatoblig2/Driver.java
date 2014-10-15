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
  Liste<String> liste = new DobbeltLenketListe<>();

  String[] navn = {"Lars","Anders","Bodil","Kari","Per","Berit"};
  for (String s : navn) liste.leggInn(s);

  liste.forEach(s -> System.out.print(s + " "));

    }


}
