/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bysykkel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author madsmkarlstad
 */
public class Utleiested extends JFrame{
    private Stativ stativet;
    private JTextField  personIdFelt, sykkelIdFelt;
    private JTextArea display;
    private JButton ut, inn, ok ;
    private PersonRegister personer;
    
    public Utleiested(String navn, int antall, PersonRegister p){
        super("BYSYKKEL " + navn);
        personer = p;
        stativet = new Stativ(antall);
        Lytter lytter = new Lytter();
        JLabel personLedetekst = new JLabel("PersonID");
        JLabel sykkelLedetekst = new JLabel("SykkelID");
        personIdFelt = new JTextField(12);
        sykkelIdFelt = new JTextField(12);
        display = new JTextArea(17,50);
        display.setEditable(false);
        ut = new JButton("Leie");
        inn = new JButton("Levere");
        ok = new JButton("OK");
        ut.addActionListener(lytter);
        inn.addActionListener(lytter);
        ok.addActionListener(lytter);
        Container c = getContentPane();
        setLayout(new FlowLayout());
        c.add(personLedetekst);
        c.add(personIdFelt);
        c.add(ut);
        c.add(sykkelLedetekst);
        c.add(sykkelIdFelt);
        c.add(inn);
        c.add(ok);
        c.add(display);
        setSize(642,350);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        display.setText(stativet.toString());
    }
    
    public void leiUt(){
        int id = Integer.parseInt(personIdFelt.getText());
        Person person = personer.finnPerson(id);
                if(person == null){
            display.setText("Personen med Id: " + id + " er ikke kunde hos Oslo Bysykkel");
        }
        if(person.godkjent() && person != null){            
            display.setText(stativet.leiUt(person));
            stativet.leiUt(person);
        }
    }
    
    public void leverInn(){
        int id = Integer.parseInt(sykkelIdFelt.getText());
        Person person = personer.finnSykkelBruker(id);
        if(person == null){
            display.setText("Ugyldig Sykkel-ID");
        }
        else{
            Sykkel sykkel = person.getSykkel();
            stativet.leverInn(person);
            person.leverInn();
            display.setText(stativet.leverInn(person));
        }
    }
    
    private class Lytter implements ActionListener{
            public void actionPerformed(ActionEvent e){
        if(e.getSource() == ut){
            leiUt();
            
            Person person = personer.finnPerson(Integer.parseInt(personIdFelt.getText()));
            System.out.println("Navn: " + person.navn
            +"\nID: " + person.getID()
            +"\nSykkel: " + person.sykkel.getID());
            personIdFelt.setText("");
        }
        else if(e.getSource() == inn){
            leverInn();
            sykkelIdFelt.setText("");
        }
        else if(e.getSource() == ok){
            display.setText(stativet.toString());
        }
    }
  }
}
