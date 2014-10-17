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

  String[] navn = {"Bernt","Lars","Anders","Bodil","Kari","Per","Berit"};

  for (String s : navn) liste.leggInn(s);

  liste.fjernHvis(s -> s.charAt(0) == 'B'); // fjerner ord på B
  System.out.println(liste);
    }


}
