/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bysykkel;

import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author madsmkarlstad
 */
public class Stativ{
    private Sykkel[] stativ;

   public Stativ(int antallSykler)
   {
     stativ = new Sykkel[antallSykler];
     fyllStativet();
   }
   
   public void fyllStativet(){
       int antall = 10;
       Random generator = new Random();
       for(int i=0;i<antall;i++){
           Sykkel sykkel = new Sykkel();
           stativ[i] = sykkel;
           System.out.println(sykkel.getID());
       }
   }
   
   public Sykkel finnSykkel(int id){
       for(int i=0;i<stativ.length;i++){
           Sykkel sjekk = stativ[i];
           if(sjekk.getID() == id){
               return sjekk;
           }
       }
       return null;
   }
   
   public String leiUt(Person s){
       String print ="";
       if(s.merknad!=null){
           print += "Sykkel kan ikke leies da du har en merknad";
           return print;
       }
       else if(stativ.length<0){
           print += "Sykkel kan ikke leies da det ikke er sykler i stativet";
           return print;
           
       }
       else if(s.sykkel==null){
           for(int i=0;i<stativ.length;i++){
               if(stativ[i]!=null){
                   int plass = i+1;
                   Sykkel sykkel = stativ[i];
                   int sykkelid = sykkel.getID();
                   print += "Ta sykkel(id: "+sykkelid + ") på plass " + plass;
                   s.leiSykkel(sykkel);
                   stativ[i] = null;
                   System.out.println(sykkel);
                   return print;
               }
           }
       }
       else if(s.sykkel!=null){
           print += "Du har allerede en sykkel registrert";
           return print;
       }
           
       System.out.println(print);
       return print;
   }
   
   public String leverInn(Person s){
       String print = "";
       for(int i=0;i<stativ.length;i++){
           if(stativ[i]==null){
               int plass = i+1;
               print+="Sett sykkelen på plass " + plass;
               Sykkel sykkel = s.getSykkel();
               s.leverInn();
               stativ[i] = sykkel;
               return print;
           }
       }     
       return print;
   }
   public String toString(){
       String print = "";
       for(int i=0;i<stativ.length;i++){
           int plass = i+1;
           Sykkel sykkel = stativ[i];
           
           print+="Plass: " + plass ;
           if(sykkel==null){
               print+="- Ledig\n";
           }
           else if(sykkel!=null){
               print+="- Sykkel-ID: "+sykkel.getID()+"\n";
           }
       }
       return print;
   }
}
