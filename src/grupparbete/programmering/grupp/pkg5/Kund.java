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
    
    
    // Attribut för klassen Köpare
    // namn är final för den ändras aldrig under kundens inlogg 
    public final String namn;
    public String typAvAffar;
    public Bilar minBil; 
 
    
    // Skapar en ArrayList för olika köpare
    public static ArrayList <Kund> listaKunder = new ArrayList<>();
    
    // Konstruktor för klassen Köpare
    public Kund (String namn, String typAvAffar, Bilar minBil){
        this.namn = namn;
        this.typAvAffar = typAvAffar;
        this.minBil = minBil;
    }
   
    //Metoder    
    public static void KundSaljaBil(){
        // Kunden vill sälja bilen till bilhallen. Denna behöver komma in i listan över bilar och för att få all information
        // om bilen som vi behöver så ställer vi några frågor om bilen som kunden får svara på. Svaren scannas av och sparas i
        // relevanta variabler. 
            
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
            
        // När all information är sparad i variabler används dessa i metoden KopaInBil som ligger i Bilar-klassen. 
        // minBil används för att koppla bilen till kunden
        Bilar minBil = new Bilar(inkopTillverkare, inkopModell, inkopArsmodell, inkopFarg, inkopMil, inkopPris, inkopVaxellada);    
        Lager.KopaInBil(minBil);
        
            
        System.out.println("Säljare: Tack för informationen! Vi köper in din bil för " + inkopPris + " kr och den finns nu i vårat lager");
        System.out.println("Ha en trevlig dag och titta gärna på de andra bilarna vi har i lager!");
    }
}

