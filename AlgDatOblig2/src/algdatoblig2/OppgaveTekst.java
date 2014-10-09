//Oppgave 0
//
//Flytt grensesnittene Beholder, Liste og skjelettet til klassen DobbeltLenketListe over 
//til deg selv.
//
//Oppgave 1
//
//Lag metodene int antall() og boolean tom(). Den første skal returnere antallet 
//verdier/noder i listen og den andre skal returnere true/false avhengig av om listen er tom 
//eller ikke. Lag så metoden boolean leggInn(T verdi). Det er ikke tillatt med null-verdier i 
//listen. Legg derfor inn en sjekk (bruk f.eks. en requireNonNull-metode fra klassen Objects) som 
//første programlinje. Innleggingsmetoden skal legge en ny node med oppgitt verdi bakerst i listen 
//og returnere true. Her må du skille mellom to tilfeller: 1) at listen på forhånd er tom og 2) 
//at 
//den ikke er tom. I en tom liste skal både hode og hale være null (og antall lik 0). 
//        I tilfelle 1) skal både hode og hale etter innleggingen peke på den nye noden 
//(både forrige-peker og neste-peker i noden skal da være null). I tilfelle 2) er det kun 
//hale-pekeren som skal endres etter innleggingen. Pass da på at forrige-peker og neste-peker 
//i den nye noden og i den noden som oppprinnelig lå bakerst, får korrekte verdier. Husk at 
//antallet må økes etter en innlegging. Det samme med variablen antallEndringer. Metoden skal 
//returnere true. Lag så et testprogram der du oppretter en instans av klassen, legger inn 
//noen verdier og så sjekker at metodene antall() og tom() gir korrekte verdier.
//
//Sjekkliste for metoden leggInn(T verdi):
//
//Stoppes null-verdier? Kastes i så fall en code>NullPointerException?
//Blir det korrekt hvis listen fra før er tom?
//Blir det korrekt hvis listen fra før ikke er tom?
//Blir antallet økt?
//Blir antallEndringer økt?
//Er det rett returverdi?
//Oppgave 2
//
//Lag metoden String toString(). Den skal returnere en tegnstreng med listens verdier. 
//Hvis listen f.eks. inneholder tallene 1, 2 og 3, skal metoden returnere strengen "[1, 2, 3]" 
//og kun "[]" hvis listen er tom. Du skal bruke en StringBuilder for å bygge opp tegnstrengen 
//og verdiene i listen finner du ved å traversere fra hode til hale ved hjelp av neste-pekere. 
//Lag så metoden String omvendtString(). Den skal returnere det samme som toString(), men i 
//omvendt rekkefølge. Her skal du finne verdiene i omvendt rekkefølge ved å traversere fra hale 
//til hode ved hjelp av forrige-pekere. Gå så videre med testprogrammet fra Oppgave 2 og sjekk 
//at utskriftene blir korrekte både fra toString() og fra omvendtString(). Hensikten med den 
//siste metoden er å kunne sjekke at forrige-pekerne er satt riktig. Pass spesielt på at begge 
//metodene fungerer korrekt for en tom liste, for en liste med kun ett element og for lister 
//med mange elementer.
//
//Oppgave 3
//
//Lag den private hjelpemetoden Node<T> finnNode(int indeks). Den skal returnere 
//noden med den gitte indeksen/posisjonen. Den skal kodes slik at hvis indeks er mindre 
//enn antall/2, så skal letingen etter noden starte fra hode og gå mot høyre ved hjelp 
//av neste-pekere. Hvis ikke, skal letingen starte fra halen og gå mot venstre ved hjelp 
//av forrige-pekere. Lag så metoden public T hent(int indeks) ved å bruke finnNode. Pass 
//på at indeks sjekkes (indeksKontroll). Lag også metoden T oppdater(int indeks, T nyverdi). 
//Den skal erstatte verdien på plass indeks med nyverdi og returnere det som lå der fra før. 
//Husk at indeks må sjekkes, at null-verdier ikke skal kunne legges inn (i så fall kastes 
//en code>NullPointerException) og at antallEndringer skal økes. Utvid testen ditt slik at 
//også disse metodene sjekkes.
//
//Oppgave 4
//
//Lag metoden int indeksTil(T verdi). Den skal returnere indeksen/posisjonen til verdi 
//hvis den finnes i listen og returnere -1 hvis den ikke finnes (hvis verdi er null finnes 
//den ikke i listen). Hvis verdi forekommer flere ganger, skal indeksen til den første av 
//dem (fra venstre) returneres. Lag så metoden boolean inneholder(T verdi). Den skal 
//returnere true hvis listen inneholder verdi og returnere false ellers. Her lønner det 
//seg å bruke et kall på indeksTil som en del av koden.
//
//Oppgave 5
//
//Lag metoden void leggInn(int indeks, T verdi). Den skal legge verdi inn i listen slik 
//at den får indeks/posisjon indeks. Husk at negative indekser og indekser større enn 
//antall er ulovlige (indekser fra og med 0 til og med antall er lovlige). Her må du passe 
//på de fire tilfellene 1) listen er tom, 2) verdien skal legges først, 3) verdien skal 
//legges bakerst og 4) verdien skal legges mellom to andre verdier. Sørg for at neste- og 
//forrige-pekere får korekte verdier i alle noder. Spesielt skal forrige-peker i den 
//første noden være null og neste-peker i den siste noden være null. Utvid testprogrammet 
//ditt slik at også denne metoden sjekkes. Bruk f.eks. metodene toString() og 
//omvendtString() til å sjekke at alle pekerne er satt riktig.
//
//Sjekkliste for leggInn(int indeks, T verdi):
//
//Stoppes null-verdier? Kastes i så fall en NullPointerException?
//Sjekkes indeksen?
//Blir det korrekt hvis listen fra før er tom?
//Blir pekerne (forrige og neste) korrekte i alle noder hvis ny verdi legges først?
//Blir pekerne (forrige og neste) korrekte i alle noder hvis ny verdi legges bakerst?
//Blir pekerne (forrige og neste) korrekte i alle noder hvis ny verdi legges mellom to verdier?
//Blir antallet økt?
//Blir antallet endringer økt?
//Oppgave 6
//
//Lag de to fjern-metodene, dvs. T fjern(int indeks) og boolean fjern(T verdi). 
//Den første skal fjerne (og returnere) verdien på posisjon indeks. Den andre skal 
//fjerne første forekomst av verdi i listen og så returnere true. Hvis verdi ikke er 
//i listen, skal den returnere false. Her må du passe på tilfellene 1) den første fjernes,
//2) den siste fjernes og 3) en verdi mellom to andre fjernes. Alle neste- og 
//forrige-pekere må være korrekte etter fjerningen. Antallet skal også reduseres og 
//antallet endringer økes. Sjekk også tilfellet at listen blir tom etter fjerningen, 
//blir korrekt behandlet. Utvid testprogrammet ditt slik at også disse metodene sjekkes. 
//Bruk f.eks. metodene toString() og omvendtString() til å sjekke at alle pekerne er satt riktig.
//
//Sjekkliste for fjern-metodene:
//
//Blir det korrekt hvis listen fra før er tom?
//Blir pekerne (forrige og neste) korrekte i alle noder hvis første verdi (indeks 0) fjernes?
//Blir pekerne (forrige og neste) korrekte i alle noder hvis siste verdi fjernes?
//Blir pekerne (forrige og neste) korrekte i alle noder hvis det fjernes en verdi mellom to verdier?
//Blir pekerne (forrige og neste) korrekte hvis listen etter fjerningen får kun én verdi? 
//Hva med ingen verdier?
//Blir antallet redusert?
//Blir antallet endringer økt?
//Oppgave 7
//
//Lag metoden void nullstill(). Den skal «tømme» listen og nulle alt slik at 
//«søppeltømmeren» kan hente alt som ikke lenger brukes. Antallet endringer økes med 1. 
//Sjekk etterpå at metodene antall() og tom() gir rette verdier og at toString() og 
//omvendtString() begge gir [] som utskrift.
//
//Oppgave 8
//
//Lag boolean hasNext() og T next() i klassen DobbeltLenketListeIterator. 
//Den første skal returnere true hvis det er flere i igjen i listen og false ellers. 
//Den andre skal først sjekke om antallEndringer og iteratorendringene 
//forventetAntallEndringer er like. Hvis ikke, kastes en ConcurrentModificationException. 
//Videre kastes en NoSuchElement­Exception hvis det ikke er flere igjen i listen. 
//Deretter settes fjernOK til sann/true, verdien til p returneres og p flyttes til den neste. 
//Lag også metoden Iterator<T> iterator(int indeks). Den skal returnere en iterator som er 
//slik at første kall på next() vil gi verdien med oppgitt indeks. Det må sjekkes at indeksen 
//er lovlig. For å få til dette kan du f.eks. lage en ekstra konstruktør i klassen 
//DobbeltLenketListeIterator. Sjekk at iteratorene gir riktige verdier.
//
//Oppgave 9
//
//a) Metoden void forEach(Consumer<? super T> handling) er en default-metode i 
//grensesnittet Iterable. Den vil virke så sant metodene hasNext og next er kodet. 
//Her er et eksempel på hvordan den kan brukes. Sjekk at det virker:
//
//  Liste<String> liste = new TabellListe<>();
//
//  String[] navn = {"Lars","Anders","Bodil","Kari","Per","Berit"};
//  for (String s : navn) liste.leggInn(s);
//
//  liste.forEach(s -> System.out.print(s + " "));
//Overskriv metoden void forEach(Consumer<? super T> handling), dvs. lag egen versjon av 
//den i klassen DobbeltLenketListe. Den skal traversere pekerkjeden fra hode til hale og 
//for hver verdi utføre «handling». Metoden skal kaste en NullPointerException hvis 
//handling er null.
//
//b) Metoden void forEachRemaining(Consumer<? super T> handling) er en default-metode i 
//grensesnittet Iterator. Den vil virke så sant metodene hasNext og next er kodet. 
//Her er et eksempel på hvordan den kan brukes. Sjekk at det virker:
//
//  Liste<String> liste = new TabellListe<>();
//
//  String[] navn = {"Lars","Anders","Bodil","Kari","Per","Berit"};
//  for (String s : navn) liste.leggInn(s);
//
//  Iterator<String> i = liste.iterator();
//  System.out.print(i.next() + " "); // skriver ut første verdi
//  i.forEachRemaining(s -> System.out.print(s + " ")); // tar med resten
//Overskriv metoden void forEachRemaining(Consumer<? super T> handling), dvs. 
//lag egen versjon av den i iteratorklassen DobbeltLenketListeIterator. 
//Den skal traversere pekerkjeden fra og med denne til hale og for hver verdi utføre 
//«handling». Metoden skal kaste en NullPointerException hvis handling er null.
//
//Oppgave 10
//
//a) Lag metoden void remove() i iteratorklassen. Her kan du ikke bruke noen av de 
//ordinære fjern-metodene. For det først vet vi ikke hvilken indeks det er snakk om 
//her og for andre kan verdien som skal fjernes, forkomme flere steder og dermed kan 
//gal verdi bli fjernet. Her må remove() kodes direkte.
//
//Hvis det ikke er tillatt å kalle denne metoden, skal det kastes en IllegalStateException. 
//Hvis antallEndringer og forventetAntallEndringer er forskjellige, kastes en 
//Concurrent-ModificationException. Hvis disse hindrene passeres, settes fjernOK til 
//usann/false. Så skal noden rett til venstre for p fjernes. Den finner vi lett siden 
//det går en peker dit. Her må en passe på alle tilfellene.
//
//Hvis den som skal fjernes er eneste verdi (antall == 1), så nulles hode og hale.
//Hvis den siste skal fjernes (p == null), så må hale oppdateres.
//Hvis den første skal fjernes (p.forrige == hode), så må hode oppdateres.
//Hvis en node inne i listen skal fjernes (noden p.forrige), så må pekerne i nodene på 
//hver side oppdateres.
//Til slutt reduseres antall (en mindre i listen) og både antallEndringer og 
//forventetAntallEndringer økes.
//
//b) Metoden boolean fjernHvis(Predicate<? super T> sjekk) er en default-metode i 
//grensesnittet Beholder. Den vil virke så sant metoden remove() i iteratorklassen er kodet. 
//Her er et eksempel på hvordan den kan brukes. Sjekk at det virker:
//
//  Liste<String> liste = new TabellListe<>();
//
//  String[] navn = {"Lars","Anders","Bodil","Kari","Per","Berit"};
//  for (String s : navn) liste.leggInn(s);
//
//  liste.fjernHvis(s -> s.charAt(0) == 'B'); // fjerner ord på B
//  System.out.println(liste);
////////////////////////////////////////////////////////////////////////////////
//
// import java.util.*;
//
//public class DobbeltLenketListe<T> implements Liste<T>
//{
//  private static final class Node<T>   // en indre nodeklasse
//  {
//    // instansvariabler
//    private T verdi;
//    private Node<T> forrige, neste;
//
//    // konstruktør
//    private Node(T verdi, Node<T> forrige, Node<T> neste)
//    {
//      this.verdi = verdi;
//      this.forrige = forrige;
//      this.neste = neste;
//    }
//  }
//
//  // instansvariabler
//  private Node<T> hode;          // peker til den første i listen
//  private Node<T> hale;          // peker til den siste i listen
//  private int antall;            // antall noder i listen
//  private int antallEndringer;   // antall endringer i listen
//
//  // hjelpemetode
//  private void indeksKontroll(int indeks)
//  {
//    if (indeks < 0)
//    {
//      throw new IndexOutOfBoundsException("Indeks " +
//        indeks + " er negativ!");
//    }
//    else if (indeks >= antall)
//    {
//      throw new IndexOutOfBoundsException("Indeks " +
//        indeks + " >= antall(" + antall + ") noder!");
//    }
//  }
//
//  // hjelpemetode
//  private Node<T> finnNode(int indeks)
//  {
//    throw new UnsupportedOperationException("Ikke laget ennå!");
//  }
//
//  // konstruktør
//  public DobbeltLenketListe()
//  {
//    hode = hale = null;
//    antall = 0;
//    antallEndringer = 0;
//  }
//
//  @Override
//  public int antall()
//  {
//    throw new UnsupportedOperationException("Ikke laget ennå!");
//  }
//
//  @Override
//  public boolean tom()
//  {
//    throw new UnsupportedOperationException("Ikke laget ennå!");
//  }
//
//  @Override
//  public boolean leggInn(T verdi)
//  {
//    throw new UnsupportedOperationException("Ikke laget ennå!");
//  }
//
//  @Override
//  public void leggInn(int indeks, T verdi)
//  {
//    throw new UnsupportedOperationException("Ikke laget ennå!");
//  }
//
//  @Override
//  public boolean inneholder(T verdi)
//  {
//    throw new UnsupportedOperationException("Ikke laget ennå!");
//  }
//
//  @Override
//  public T hent(int indeks)
//  {
//    throw new UnsupportedOperationException("Ikke laget ennå!");
//  }
//
//  @Override
//  public int indeksTil(T verdi)
//  {
//    throw new UnsupportedOperationException("Ikke laget ennå!");
//  }
//
//  @Override
//  public T oppdater(int indeks, T nyverdi)
//  {
//    throw new UnsupportedOperationException("Ikke laget ennå!");
//  }
//
//  @Override
//  public boolean fjern(T verdi)
//  {
//    throw new UnsupportedOperationException("Ikke laget ennå!");
//  }
//
//  @Override
//  public T fjern(int indeks)
//  {
//    throw new UnsupportedOperationException("Ikke laget ennå!");
//  }
//
//  @Override
//  public void nullstill()
//  {
//    throw new UnsupportedOperationException("Ikke laget ennå!");
//  }
//
//  @Override
//  public String toString()
//  {
//    throw new UnsupportedOperationException("Ikke laget ennå!");
//  }
//
//  public String omvendtString()
//  {
//    throw new UnsupportedOperationException("Ikke laget ennå!");
//  }
//
//  @Override
//  public Iterator<T> iterator()
//  {
//    throw new UnsupportedOperationException("Ikke laget ennå!");
//  }
//
//  public Iterator<T> iterator(int indeks)
//  {
//    throw new UnsupportedOperationException("Ikke laget ennå!");
//  }
//
//  private class DobbeltLenketListeIterator implements Iterator<T>
//  {
//    private Node<T> denne;
//    private boolean fjernOK;
//    private int forventetAntallEndringer;
//
//    private DobbeltLenketListeIterator()
//    {
//      denne = hode;     // denne starter på den første i listen
//      fjernOK = false;  // blir sann når next() kalles
//      forventetAntallEndringer = antallEndringer;  // teller endringer
//    }
//
//    @Override
//    public boolean hasNext()
//    {
//      throw new UnsupportedOperationException("Ikke laget ennå!");
//    }
//
//    @Override
//    public T next()
//    {
//      throw new UnsupportedOperationException("Ikke laget ennå!");
//    }
//
//    @Override
//    public void remove()
//    {
//      throw new UnsupportedOperationException("Ikke laget ennå!");
//    }
//
//  } // DobbeltLenketListeIterator  
//
//} // DobbeltLenketListe  
