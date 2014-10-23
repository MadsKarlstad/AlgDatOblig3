/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bysykkel;

/**
 *
 * @author madsmkarlstad
 */
public class SykkelByen{
       private Utleiested[] steder;
   private PersonRegister register;

   public SykkelByen(int antall, PersonRegister r)
   {
     register = r;
     steder = new Utleiested[antall];
     opprettSykkelSteder();
   }


   public void opprettSykkelSteder()
   {
     steder[0] = new Utleiested("Holbergs plass", 20, register);
     steder[1] = new Utleiested("Majorstua", 20, register);
     steder[2] = new Utleiested("Nasjonalteateret", 20, register);
     steder[3] = new Utleiested("Egertorvet", 20, register);
   }

   public static void main(String[] args)
   {
     PersonRegister register = new PersonRegister(10);

     new SykkelByen(10, register);
   }

}
