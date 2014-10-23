/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bysykkel;

import java.util.Random;

/**
 *
 * @author madsmkarlstad
 */
public class PersonRegister{
    private Person[] personer;
    
    public PersonRegister(int antall){
        personer = new Person[antall];
        opprettPersonregister();
    }
    
    public void opprettPersonregister(){
        String[] navn = {"Mads","Erlend","Benjamin","Christoffer","Peder"};
        Random generator = new Random();
        for(int i=0;i<personer.length;i++){
            int n = generator.nextInt(navn.length);
            String name = navn[n];
            Person p = new Person(name,null);
            personer[i] = p;
        }
    }
    
    public Person finnPerson(int personId){
        for(int i=0;i<personer.length;i++){
            Person sjekk = personer[i];
            if(sjekk.getID() == personId){
                return sjekk;
            }          
        }
        return null;
    }
    
    public Person finnSykkelBruker(int sykkelId){
        for(int i=0;i<personer.length;i++){
            Person person = personer[i];
            Sykkel sykkel = person.getSykkel();
            int id = sykkel.getID();
            if(id == sykkelId){
                return person;
            }
        }   
        return null;
    }
    
    public int length(){
        return personer.length;
    }
}
