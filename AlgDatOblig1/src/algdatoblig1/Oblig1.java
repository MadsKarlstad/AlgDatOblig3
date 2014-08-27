package algdatoblig1;

/*
* Skrevet av:
* Mads Myrbakken Karlstad, studentnr: 193949
* Erlend Westbye, studentnr: 193377
* William Benjamin Wold, studentnr: 183670
* Christoffer Baier Jønsberg, studentnr: 193674
* Vegar Nygård, studentnr: 193362
*/
import java.util.*;
import javax.swing.*;

public class Oblig1{
    
    //Oppgave 1
    public static int maks(int[] a){

        for(int i = 0; i < a.length-1; i++){
            
            if(a[i] > a[i+1]){

                int større = a[i];
                int mindre = a[i+1];

                a[i+1] = større;
                a[i] = mindre;

            }
        }
        return a[a.length-1];
    }
    public static boolean erSortert(int[] a){
        for(int i=0;i<a.length-1;i++){
            if(a[i]>a[i+1]){
                return false;
            }          
        }
        return true;
    }
    
    //Oppgave 2
    public static void sortering(int[] a){

        boolean sortert = false;
        int sistepost = 1;

        while (!sortert) {

            for (int i = 0; i < a.length - sistepost; i++) {

                if (a[i] > a[i + 1]) {

                    int større = a[i];
                    int mindre = a[i + 1];

                    a[i + 1] = større;
                    a[i] = mindre;

                    System.out.println(Arrays.toString(a));
                }
            }

            sistepost++;

            if(sistepost == 10){

                sortert = true;
            }
        }
    }
    
    //Oppgave 3
    public static int antallUlikeSortert(int[] a){ 
        
        int[] array = a;
        
        erSortert(array);
        
        boolean sortert = erSortert(array);
        int forekomster=0;

        if(!sortert)
            throw new IllegalStateException("Tabellen er ikke sortert");
        if(sortert){
            if(a.length == 0){
                forekomster = 0;
            }
            if(a.length > 0){
                forekomster=1;
                for(int i = 0;i<a.length-1;i++){
                    if(a[i]!=a[i+1]){
                        forekomster++;
                    }
                }
            }
        }
        System.out.println(forekomster);        
        return forekomster;
    }
    
    //Oppgave 4
    public static int antallUlikeUsortert(int[] a){
        int forekomster=0;
        
        if(a.length==0){
            forekomster=0;
        }
        if(a.length>0){
            forekomster=1;
            for(int i=0;i<a.length-1;i++){
                int sjekk = a[i];
                if(sjekk!=a[i++]){
                    forekomster++;
                }
            }
        }
        System.out.println(forekomster);
        return forekomster;
    }
}