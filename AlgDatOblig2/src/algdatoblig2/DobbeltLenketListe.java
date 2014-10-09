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

        return;
    }
    else if(indeks == 0 && antall>0){ //Ny først, med indeks 0
        Node<T> p = hode;
        
        hode = new Node<>(verdi,null,p); 
        p.forrige = hode;
        antall++;
        return;

    }
    else if(indeks == antall && indeks!=0){ //Settes bakerst
        Node<T> p = hale;
        hale = new Node<>(verdi,hale,null);
        p.neste = hale;
        
        antall++;
        return;        
        }
    else{ //Settes på riktig sortert plats, danskemænd
        Node<T> p = hode;
        for(int i=1;i<indeks;i++) p = p.neste;
        p.neste = new Node<>(verdi,p,p.neste); //feil i forrige
        
        antall++;
        return;
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
        Node sjekk = hode;
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
    return gammelVerdi;
  }

  @Override
  public boolean fjern(T verdi)
  {
    throw new UnsupportedOperationException("Ikke laget ennå!");
  }

  @Override
  public T fjern(int indeks)
  {
    throw new UnsupportedOperationException("Ikke laget ennå!");
  }

  @Override
  public void nullstill()
  {
    throw new UnsupportedOperationException("Ikke laget ennå!");
  }

  @Override
  public String toString()
  {
      StringBuilder print = new StringBuilder();
      print.append("[");
      Node sjekk = hode;
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
      //System.out.println(hale.forrige.forrige.verdi);
      StringBuilder print = new StringBuilder();
      print.append("[");
      Node sjekk = hale;
      for(int i=0;i<antall;i++){
          if(sjekk == null){
              print.append("]");
              return print.toString();
          }
          else{
                print.append(sjekk.verdi);
                if(sjekk.forrige != null){
                    System.out.println("Forrigepekeren til " + sjekk.verdi +" er: " + sjekk.forrige.verdi);
                    print.append(", ");
                }
          }              
          sjekk = sjekk.forrige;
      }
      print.append("]");
      return print.toString();
  }

  @Override
  public Iterator<T> iterator()
  {
    throw new UnsupportedOperationException("Ikke laget ennå!");
  }

  public Iterator<T> iterator(int indeks)
  {
    throw new UnsupportedOperationException("Ikke laget ennå!");
  }

  private class DobbeltLenketListeIterator implements Iterator<T>
  {
    private Node<T> denne;
    private boolean fjernOK;
    private int forventetAntallEndringer;

    private DobbeltLenketListeIterator()
    {
      denne = hode;     // denne starter på den første i listen
      fjernOK = false;  // blir sann når next() kalles
      forventetAntallEndringer = antallEndringer;  // teller endringer
    }

    @Override
    public boolean hasNext()
    {
      throw new UnsupportedOperationException("Ikke laget ennå!");
    }

    @Override
    public T next()
    {
      throw new UnsupportedOperationException("Ikke laget ennå!");
    }

    @Override
    public void remove()
    {
      throw new UnsupportedOperationException("Ikke laget ennå!");
    }

  } // DobbeltLenketListeIterator  

} // DobbeltLenketListe  
