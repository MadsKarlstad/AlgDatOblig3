/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package bysykkel;

import java.sql.Time;
import java.util.Date;
import java.text.DateFormat;
/**
 *
 * @author madsmkarlstad
 */
public class Person{
    String navn;
    private int idNr;
    private static int nestenummer = 1;
    Sykkel sykkel;
    String merknad;
    Date startTid;
    
    public Person(String n,Sykkel s){
        navn = n;
        idNr = nestenummer++;
        sykkel = s;
        
    }
    
    public int getID(){
        return idNr;
    }
    
    public Sykkel getSykkel(){
        return sykkel;
    }
    
    public boolean godkjent(){
        if(sykkel==null){
            return true;
        }
        else
            return false;
    }
    
    public void setMerknad(Date t, String m){
        DateFormat df = DateFormat.getInstance();
        String print = df.format(t);
        merknad = print + "\n"+m;
    }
    
    
    public boolean leiSykkel(Sykkel s){
        if(godkjent()){
            sykkel = s;
            Date nå = new Date();
            startTid = nå;
            return true;
        }
        else
            return false;
    }
    
    public int leietid(Date sluttTid){
        Date nå = new Date();
        long varighet = sluttTid.getTime()-nå.getTime();
        int i = (int) varighet;
        return i;
    }

    public void leverInn(){
        Date levert = new Date();
        long nå = System.currentTimeMillis();
        long start = startTid.getTime();  
        long varighet = (nå-start)/100000;
        if(varighet>3){
            String merknad = "Leietiden din ("+varighet+") gikk over de tilatte 3timer";
            setMerknad(levert,merknad);
        }
        sykkel = null;
    }
    
    public String toString(){
        String print = "";
        print += "Navn: " + navn;
        print += "\nId-nummer: "+ idNr;
        if(merknad!=null){
            print += "\nMerknad: "+ merknad;
        }   
        return print;
    }
}
