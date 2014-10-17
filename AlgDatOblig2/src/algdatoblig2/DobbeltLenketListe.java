/*
* Skrevet av:
* Mads Myrbakken Karlstad, studentnr: 193949, klasse: HINGDATA13H2AA
* Erlend Westbye, studentnr: 193377, klasse: HINGDATA13H2AA
* William Benjamin Wold, studentnr: 183670, klasse: HINGDATA13H2AA
* Christoffer Baier Jønsberg, studentnr: 193674, klasse: HINGDATA13H2AA
* Vegar Nygård, studentnr: 193362, klasse: HINGDATA13H2AA
*/

package algdatoblig2;

/**
 *
 * @author madsmkarlstad
 */
import java.util.*;
import java.util.function.*;

public class DobbeltLenketListe<T> implements Liste<T>
{
  private static final class Node<T>   // en indre nodeklasse
  {
    // instansvariabler
    private T verdi;
    private Node<T> forrige, neste;

    // konstruktør
    private Node(T verdi, Node<T> forrige, Node<T> neste)
    {
      this.verdi = verdi;
      this.forrige = forrige;
      this.neste = neste;
    }
  }

  // instansvariabler
  private Node<T> hode;          // peker til den første i listen
  private Node<T> hale;          // peker til den siste i listen
  private int antall;            // antall noder i listen
  private int antallEndringer;   // antall endringer i listen

  // hjelpemetode
  private void indeksKontroll(int indeks)
  {
    if (indeks < 0)
    {
      throw new IndexOutOfBoundsException("Indeks " +
        indeks + " er negativ!");
    }
    else if (indeks >= antall)
    {
      throw new IndexOutOfBoundsException("Indeks " +
        indeks + " >= antall(" + antall + ") noder!");
    }
  }

  // hjelpemetode
  private Node<T> finnNode(int indeks)
  {
    Node sjekk;
    int x = antall/2;
    if(indeks<=antall/2){
        sjekk = hode;
        for(int i=0;i<indeks;i++){
            sjekk=sjekk.neste;
        }
    }
    else{
        sjekk = hale;
        for(int i=indeks;i>indeks;i--){
            sjekk=sjekk.forrige;
        }
    }
    return sjekk;
  }

  // konstruktør
  public DobbeltLenketListe()
  {
    hode = hale = null;
    antall = 0;
    antallEndringer = 0;
  }

  @Override
  public int antall()
  {
      return antall;
  }

  @Override
  public boolean tom()
  {
    if(antall>0){
        return false;
    }
    else
        return true;
  }

  @Override
  public boolean leggInn(T verdi)
  {
      Objects.requireNonNull(verdi);
      if(antall == 0){
          hode = hale = new Node<T>(verdi,null,null);
      }
      else
          hale = hale.neste = new Node<T>(verdi,hale,null);
      antall++;
      antallEndringer++;
      return true;
  }

  @Override
  public void leggInn(int indeks, T verdi)
  {
         if(verdi==null){
        throw new NullPointerException("Ingen null-verdier, takk!");
    }
    if(indeks<0 || indeks>antall){
        throw new IndexOutOfBoundsException("Indeksen din ("+indeks+ ") er no go!");
    }
    if(indeks == 0 && antall == 0){ //Settes inn først
        hode = new Node<>(verdi,null,hode);
        hale = hode;
        antall++;
        antallEndringer++;
        return;
    }
    else if(indeks == 0 && antall>0){ //Ny først, med indeks 0
        Node<T> p = hode;
        
        hode = new Node<>(verdi,null,p); 
        p.forrige = hode;
        antall++;
        antallEndringer++;
        return;

    }
    else if(indeks == antall && indeks!=0){ //Settes bakerst
        Node<T> p = hale;
        hale = new Node<>(verdi,hale,null);
        p.neste = hale;
        
        antall++;
        antallEndringer++;
        return;        
        }
    else{ //Settes på riktig sortert plats, danskemænd
        Node<T> før = null;
        Node<T> etter = hode;
        while(indeks>0){
            før = etter;
            etter = etter.neste;
            indeks--;
        }
        Node<T> nåværende = new Node<>(verdi,før,etter);
        antall++;
        antallEndringer++;
        før.neste = nåværende;
        etter.forrige = nåværende;
        }
  }

  @Override
  public boolean inneholder(T verdi)
  {
      boolean inneholder = false;
      if(indeksTil(verdi) != -1){
          inneholder = true;
      }
      return inneholder;
  }

  @Override
  public T hent(int indeks)
  {
    indeksKontroll(indeks);
    return finnNode(indeks).verdi;
  }

  @Override
  public int indeksTil(T verdi)
  {
        int indeks =-1;
        Node<T> sjekk = hode;
        if(verdi==null){
            indeks=-1;
        }
        else if(sjekk==null){
            indeks=-1;
        }
        else{
            for(int i=0;i<antall;i++){
                if(verdi.equals(sjekk.verdi)){
                    indeks = i;
                    break;
                }
                else
                    sjekk = sjekk.neste;
            }    
        }
        return indeks;
  }

  @Override
  public T oppdater(int indeks, T nyverdi)
  {
    indeksKontroll(indeks);
    if(nyverdi == null){
        throw new NullPointerException("Ikke tillatt med null-verdier!");
    }
    Node<T> gammel = finnNode(indeks);
    T gammelVerdi = gammel.verdi;
    
    gammel.verdi = nyverdi;
    antallEndringer++;

    return gammelVerdi;
  }

@Override
 public boolean fjern(T verdi)
  {
      if(antall==0||verdi==null){
          return false;
      }
      Node<T> før = hode;
      if(hode.verdi.equals(verdi)){
          før = hode;
          hode = hode.neste;
          if(hode!=null){
              hode.forrige = null;
          }
          else{
              hale = null;
          }
          før.neste = null;
          antall--;
          antallEndringer++;
          return true;
      }
      if(hale.verdi.equals(verdi)){
          før = hale;
          hale = hale.forrige;
          hale.neste = null;
          antall--;
          antallEndringer++;
          return true;
      }
      før = hode;
      Node<T> finger = før.neste;
      for(int i=0;i<antall-1;i++){
          if(finger.verdi.equals(verdi)){
              før.neste = finger.neste;
              finger.neste.forrige = før;
              antall--;
              antallEndringer++;
              return true;
          }
          før=før.neste;
          finger = før.neste;
      }
      return false;
  }

  @Override
  public T fjern(int indeks)
  {
      if(indeks<0){
          throw new IndexOutOfBoundsException("Ulovlig indeks: " + indeks );
      }
      else if(indeks>=antall){
          throw new IndexOutOfBoundsException("Ulovlig indeks: " + indeks);
      }
      else if(indeks==0){
          Node<T> temp = hode;
          hode = hode.neste;
          if(hode!=null){
              hode.forrige = null;
          }
          else{
              hale = null;
          }
          temp.neste = null;
          antall--;
          antallEndringer++;
          return temp.verdi;
      }
      else if(indeks == antall-1){
          Node<T> temp = hale;
          hale = hale.forrige;
          hale.neste = null;
          antall--;
          antallEndringer++;
          return temp.verdi;
      }
      Node<T> før = null;
      Node<T> finger = hode;
      while(indeks>0){
          før = finger;
          finger = finger.neste;
          indeks--;
      }
      før.neste = finger.neste;
      finger.neste.forrige = før;
      antall--;
      antallEndringer++;
      return finger.verdi;
  }

  @Override
  public void nullstill()
  {
      hode = hale = null;
      antall = 0;
      antallEndringer++;
  }

  @Override
  public String toString()
  {
      StringBuilder print = new StringBuilder();
      print.append("[");
      Node<T> sjekk = hode;
      for(int i=0;i<antall;i++){ 
          if(sjekk==null){
              print.append("]");
              return print.toString();
          }
          else{
              print.append(sjekk.verdi);
              if(sjekk.neste != null){
                print.append(", ");
              } 
              sjekk = sjekk.neste;
          }
      }
      print.append("]");
      return print.toString();     
  }
  
  public String omvendtString()
  {
      StringBuilder print = new StringBuilder();
      print.append("[");
      Node<T> sjekk = hale;
      for(int i=0;i<antall;i++){
          if(sjekk == null){
              print.append("]");
              return print.toString();
          }
          else{
                print.append(sjekk.verdi);
                if(sjekk.forrige != null){
                    print.append(", ");
                }
          }              
          sjekk = sjekk.forrige;
      }
      print.append("]");
      return print.toString();
  }
  @Override
  public void forEach(Consumer<? super T> handling){
      if(handling == null){
          throw new NullPointerException();
      }
      for(T t : this){
          handling.accept(t);
          
      }
  }

  @Override
  public Iterator<T> iterator()
  {
      return new DobbeltLenketListeIterator();
  }

  public Iterator<T> iterator(int indeks)
  {
      return new DobbeltLenketListeIterator(indeks);
  }
  
  private class DobbeltLenketListeIterator implements Iterator<T>
  {
    private Node<T> denne;
    private Node<T> prev;
    private boolean fjernOK;
    private int forventetAntallEndringer;
    private int cursor =0;
    
      abstract class TaggedArraySpliterator<T> implements Spliterator<T> {
        private final Object[] array;
        private int origin; // current index, advanced on split or traversal
        private final int fence; // one past the greatest index

        TaggedArraySpliterator(Object[] array, int origin, int fence) {
            this.array = array; this.origin = origin; this.fence = fence;
        } 
    
        public void forEachRemaining(Consumer<? super T> handling){
            if(handling == null){
                throw new NullPointerException();
            }
            for(; origin<fence;origin+=2){
                handling.accept((T) array[origin]);
            }
        }
    }
    
    private DobbeltLenketListeIterator(int indeks){
        this();
        if(indeks<0 || indeks>=antall){
          throw new IndexOutOfBoundsException("Indeks: " + indeks + " er feil");
        }
        else{
            while(indeksTil(denne.verdi)<indeks){
            this.next();
            }                   
        }
    }
    
    private DobbeltLenketListeIterator()
    {
      denne = hode;     // denne starter på den første i listen
      fjernOK = false;  // blir sann når next() kalles
      forventetAntallEndringer = antallEndringer;  // teller endringer
      
      
    }
   
    @Override
    public boolean hasNext()
    {
        return denne != null;
    }

    @Override
    public T next()
    {
        if(forventetAntallEndringer!=antallEndringer){
            throw new ConcurrentModificationException();
        }
        else if(!hasNext()){
            throw new NoSuchElementException();
        }
        else if(denne == null){
            throw new NoSuchElementException();
        }
        fjernOK = true;
        T item = denne.verdi;
        prev = denne;
        denne = denne.neste;
        cursor++;
        return item;
        
    }

    @Override
    public void remove() {
if (!fjernOK) {
              throw new IllegalStateException("Ulovlig tilstand!");
          }
          fjernOK = false;
          if (antall==1) {
              hode = hale=null;
              antall--;
              cursor--;
              antallEndringer++;
              forventetAntallEndringer++;
              return;
          }
          if (denne==null) {
              hale.forrige.neste=null;
              hale=hale.forrige;
              hale.forrige=hale.forrige.forrige;
              antall--;
              cursor--;
              antallEndringer++;
              forventetAntallEndringer++;
              return;
          }
          Node<T> q = hode;              // hjelpepeker
          if (denne.forrige==hode) {
              hode.neste.forrige=null;
              hode = hode.neste;
              antall--;
              cursor--;
              antallEndringer++;
              forventetAntallEndringer++;
              return;
          }
          else {
Node<T> r = hode;
              while (r.neste.neste != denne) {
                  r = r.neste;
              }
              q = r.neste;
              if(q!=hale.forrige.forrige){
                denne.forrige=q.forrige;
              }
              r.neste = denne;
          }
          q.verdi = null;                
          q.neste = null;
          antall--;                  
          cursor--;
          antallEndringer++;
          forventetAntallEndringer++;
          
      }

  } // DobbeltLenketListeIterator  

} // DobbeltLenketListe  
