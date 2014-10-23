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
public class Sykkel{
    int MAXTID = 3;
    private int id;
    private static int nestenummer = 1;
    
    public Sykkel(){
        id = nestenummer++;
    }
    
    public int getID(){
        return id;
    }
}
