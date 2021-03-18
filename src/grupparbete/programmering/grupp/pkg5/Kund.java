/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupparbete.programmering.grupp.pkg5;

import java.util.ArrayList;

/**
 *
 * @author schum
 */
public class Kund {
    
    
    // Attribut för köparen i klassen Kund. Attribut "minBil" håller information om ev. bilobjekt som köpts eller sålts.
    // Attribut för namn är satt till final för den ändras aldrig under kundens inlogg. 
    public final String namn;
    public String typAvAffar;
    public Bil minBil; 
 
    
    // Skapar en ArrayList för olika köpare/kunder
    public static ArrayList <Kund> listaKunder = new ArrayList<>();
    
    // Konstruktor för klassen Kund. Denna används vid programmets början vid kundresgitreringen.
    // Parametrarna för "typAvAffär och "minBil" får nya värden vid en ev. affär.
    public Kund (String namn, String typAvAffar, Bil minBil){
        this.namn = namn;
        this.typAvAffar = typAvAffar;
        this.minBil = minBil;
    }
   
    // Metoder    
    public static void KundSaljaBil(){
        // Kunden vill sälja bilen till bilhallen. Denna behöver komma in i listan över bilar och för att få all information
        // om bilen som vi behöver så ställer vi några frågor om bilen som kunden får svara på. Svaren scannas av och sparas i
        // relevanta variabler. Metoden som säkrar användarens "input" finns i klassen för Bilhallen.
            
        System.out.println("Säljare: Om vi ska köpa in din bil vänligen ange mer information om din bil");
        System.out.println("Vad är det för bilmärke?"); 
        String inkopTillverkare = BilHall.GetInputString();
        System.out.println("Vad är det för modell?");
        String inkopModell = BilHall.GetInputString();
        System.out.println("Vad är det för årsmodell?");
        String inkopArsmodell = BilHall.GetInputString();
        System.out.println("Vad är det för färg på bilen?");
        String inkopFarg = BilHall.GetInputString();
        System.out.println("Hur många mil har bilen gått?");
        int inkopMil = BilHall.GetInput();
        System.out.println("Hur mycket vill ni ha för bilen?");
        int inkopPris = BilHall.GetInput();
        System.out.println("Vad är det för typ av växellåda på bilen?");
        String inkopVaxellada = BilHall.GetInputString();
        System.out.println("");
            
        // När all information är sparad i variabler används dessa i metoden KopaInBil som ligger i klassen Lager.
        // Attributet "minBil" uppdateras och håller nu information om det nya bilobjektet som köpts in och kunden sålt. 
        // Anropar sedan metoden KopaInBil i klassen Lager med objektet "minBil" som parameter.
        Bil minBil = new Bil(inkopTillverkare, inkopModell, inkopArsmodell, inkopFarg, inkopMil, inkopPris, inkopVaxellada);    
        Lager.KopaInBil(minBil);
        
        // Bekräftelse på affären till kunden skrivs ut.  
        System.out.println("Säljare: Tack för informationen! Vi köper in din bil för " + inkopPris + " kr och den finns nu i vårat lager");
        System.out.println("Ha en trevlig dag och titta gärna på de andra bilarna vi har i lager!");
    }
}

