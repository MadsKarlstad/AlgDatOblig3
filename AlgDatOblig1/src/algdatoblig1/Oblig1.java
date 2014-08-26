package algdatoblig1;

/*
* Skrevet av:
* Mads Myrbakken Karlstad, studentnr: 193949
* Erlend Westbye, studentnr: 193377
* William Benjamin Wold, studentnr:
* Christoffer Baier Jønsberg, studentnr:
*/
import java.util.*;
import javax.swing.*;

public class Oblig1{
    
    public static int maks(int[] a){
        if(a.length < 1)
            throw new java.util.NoSuchElementException("a er tom");
        
        int m = 0;

        for(int i = 1; i<a.length; i++){
            if(a[i] > a[m]) m = i;
        }
        JOptionPane.showMessageDialog(null,m);
        return m;
    }
}






