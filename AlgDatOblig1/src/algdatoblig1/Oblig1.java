package algdatoblig1;

/*
* Skrevet av:
* Mads Myrbakken Karlstad, studentnr: 193949, klasse: HINGDATA13H2AA
* Erlend Westbye, studentnr: 193377, klasse: HINGDATA13H2AA
* William Benjamin Wold, studentnr: 183670, klasse: HINGDATA13H2AA
* Christoffer Baier Jønsberg, studentnr: 193674, klasse: HINGDATA13H2AA
* Vegar Nygård, studentnr: 193362, klasse: HINGDATA13H2AA
*/
import java.util.*;
import javax.swing.*;

public class Oblig1{
    
    //Oppgave 1
    public static int maks(int[] a){
        
        if(a.length<=0){
            throw new NoSuchElementException("Tabellen a er tom");
        }
        
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
        return forekomster;
    }
    
    //Oppgave 4
    public static int antallUlikeUsortert(int[] a){
        int uniketall = a.length;
        if(a.length==0){
            return 0;
        }
        else{
            boolean like;
            for(int i=0;i<a.length;i++){
                like=false;
                for(int j=i+1;j<a.length;j++){
                    if(a[i]==a[j]){
                        like=true;
                    }
                }
                if(like){
                    uniketall--;
                }
            }
        }
        return uniketall;
    }
    
    //Oppgave 5
    public static void rotasjon(char[] a){

        int j = a.length-1;

        char skalflyttes = a[j];

        for(int i =0; i<a.length-1;i++){

            a[j] = a[j-1] ;
            j--;
        }
        a[0] = skalflyttes;

    }    
    //Oppgave 6
    public static void rotasjon(char[] a, int b){
        if(b>0) {

            for (int x = 0; x < b; x++) {

                int j = a.length-1;

                char skalflyttes = a[j];

                for (int i = 0; i < a.length - 1; i++) {

                    a[j] = a[j - 1];
                    j--;

                }

                a[0] = skalflyttes;

            }
        }

        for (int x = 0; x < -b; x++) {
            if (b < 0) {
                char skalflyttes = a[0];

                int j = 0;

                for (int i = 0; i < a.length - 1; i++) {
                    a[j] = a[j + 1];
                    j++;
                }

                a[10] = skalflyttes;
            }
        }
    }  
    //Oppgave 7a
    public static String flett(String s, String t){

        String flettet = "";
        boolean ferdig = false;

        char[] A = s.toCharArray();
        char[] B = t.toCharArray();

        int tellerA = 0;
        int tellerB = 1;

        int teller = 0;

        int lengde = A.length + B.length;

        while (!ferdig){

            if(tellerA < (s.length()*2)){

                flettet+=A[teller];

                tellerA += 2;

            }

            if(tellerB < ((t.length()*2))){

                flettet+= B[teller];

                tellerB += 2;
            }

            //else break;

            teller++;

            if(flettet.length() == lengde){

                ferdig = true;
            }
        }
        return flettet;
    }    
    
    //Oppgave 7b
    public static String flett(String ... s){

        int total = 0;
        int teller = 0;

        String flettet = "";

        boolean b = false;


        do {

            if(teller < s.length){

                total += s[teller].length();

            }

            for(int i = 0; i < s.length; i++){

                char[] a = s[i].toCharArray();

                if(!(teller >= a.length)){
                    flettet += a[teller];
                }
            }

            teller++;

            if(teller == total){

                b = true;
            }

        }
        while (!b);

        return flettet;
    }    
    
    //Oppgave 8
    public static void makstest() {
        int[] a = {8, 3, 5, 7, 9, 6, 10, 2, 1, 4};
        int[] b = {645, 143, 231, 65, 213, 8987, 1, 287, 15, 659}; 
        int[] c = {0, 2, 40, 6, 9, 1, 8, 65, 2, 4}; 
        // maksverdien 10 er i posisjon 6

        if(a[tredjeMaks(a)[0]]!=a[6]||a[tredjeMaks(a)[1]]!=a[4]||
                a[tredjeMaks(a)[2]]!=a[0]){
        // kaller maks-metoden
            System.out.println("Kodefeil: Gir feil posisjon for maksverdiene!");
        }

        a = new int[0];  // en tom tabell, lengde lik 0
        boolean unntak = false;
        try{
            tredjeMaks(a);  // kaller maks-metoden 
        }
        catch(Exception e){
            unntak = true;
            if(!(e instanceof java.util.NoSuchElementException)) {
                System.out.println("Kodefeil: Feil unntak for en tom tabell!");
            }
        }
        if(!unntak){
            System.out.println("Kodefeil: Mangler unntak for en tom tabell!");
        }
    }

    public static int[] tredjeMaks(int[] a) {
        int n = a.length;     // tabellens lengde
        if (n < 3){
        // må ha minst to verdier
            throw new java.util.NoSuchElementException
            ("a.length(" + n + ") < 3!");
        }
        int m = 0;      // m er posisjonen til største verdi
        int nm = 1;     // nm er posisjonen til nest største verdi
        int tm = 2;     // nm er posisjonen til tredje største verdi
        
        if(a[1]>a[m]){
            m=1;
            if(a[2]>a[m]){
                m=2;
                nm=1;
                tm=0;
            }
        }
        else if(a[2]>a[m]){
            m=2;
            if(a[1]>a[m]){
                m=1;
                nm=2;
                tm=0;
            }
        }
        else if(a[2]>a[nm]){
            nm=2;
            tm=1;
        }
        // bytter om m og nm hvis a[1] er større enn a[0]
        int maksverdi = a[m];                // største verdi
        int nestmaksverdi = a[nm];
        int tredjemaksverdi = a[tm];// nest største verdi

        for (int i = 3; i < n; i++) {
            if (a[i] > tredjemaksverdi){
                if (a[i] > nestmaksverdi) {
                    if (a[i] > maksverdi) {  
                        tm = nm;
                        tredjemaksverdi = nestmaksverdi;
                        
                        nm = m;
                        nestmaksverdi = maksverdi;     // ny nest størst

                        m = i;
                        maksverdi = a[m];              // ny størst
                    } 
                    else {
                        tm = nm;
                        tredjemaksverdi = nestmaksverdi;
                        
                        nm = i;
                        nestmaksverdi = a[nm];         // ny nest størst
                    }
                }
                else{
                    tm = i;
                    tredjemaksverdi = a[tm];
                }
            }
        } // for
        return new int[]{m, nm, tm};    // n i posisjon 0, nm i posisjon 1

    } //tredjeMaks

    //Oppgave 9
    public static int[] kMinst(int[] a, int k){
        
        int n = a.length;     // tabellens lengde
        if (k < 1|| k > n){
        // Tester at k er minst 1 og ikke lengre enn lengden på array a.
            throw new IllegalArgumentException 
            ("Valgte antall minimums verdier samsvarer ikke med lengden på"
                    + "talliste eller er 0");
        }
        
        int[] verdier = new int[k]; //Tabellen siste tall = k-1
        for (int i = 0; i < verdier.length; i++){
            verdier[i]=a[i];
        }
        Arrays.sort(verdier);
        for (int j = k; j < a.length; j++){
            //Første for velger første a verdi
            for (int i = 0; i<verdier.length; i++){
                //Andre for velger fra "verdier"
                if(a[j]<verdier[i]){
                    verdier[--k]=a[j];
                    Arrays.sort(verdier);
                    break;
                }
            }
        }
        return verdier;
    }//kMinst
    
    //Oppgave 10
    public static boolean inneholdt(String a, String b){

        a =a.toUpperCase();
        b = b.toUpperCase();

        boolean sammeord = false;

        char[] alfabet = {'A','B','C','D','E','F','G','H','I','J',
                          'K','L','M','N','O','P','Q','R','S','T',
                          'U','V','W','X','Y','Z','Æ','Ø','Å'};

        int[] forekomstera = new int[alfabet.length];
        int[] forekomsterb = new int[alfabet.length];

        char[] A = a.toCharArray();
        char[] B = b.toCharArray();

        for(int i = 0; i < alfabet.length;i++){

            char skalsjekkes = alfabet[i];

            int antallforekomstera = 0;
            int antallforekomsterb = 0;

            for(int j = 0; j< A.length; j++){
                if(A[j] == skalsjekkes){antallforekomstera++;}
            }

            for(int j = 0; j< B.length; j++){
                if(B[j] == skalsjekkes){antallforekomsterb++;}
            }

            forekomstera[i] += antallforekomstera;
            forekomsterb[i] += antallforekomsterb;

        }//endof for

        for(int i = 0; i < alfabet.length; i++){
            if(forekomstera[i] == forekomsterb[i]){sammeord = true;}
            else{ sammeord = false; break;}
        }

        return sammeord;        
    }        
}