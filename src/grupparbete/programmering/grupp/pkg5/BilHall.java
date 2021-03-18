/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupparbete.programmering.grupp.pkg5;

import java.util.Scanner;

/**
 *
 * @author lilja
 */
public class BilHall {

   
   
    public static void main(String[] args) { 
 
        // Fyller på listaBilar med bilar från lagret innan öppning.
        Lager.SkapaListaBilar();
        
        // Boolean för att veta om det är en kund eller ej.
        // Om det är en kund i hallen är denna true.
        boolean kund;
        
        //Boolean för om bilhallen ska vara öppen eller ej. 
        boolean fortfarandeOppet = true;
        
        // Do-while loopen håller bilhallen öppen tills personalen stänger.
        // Så länge som boolean "fortfarandeOppet" är true körs menyn. 
        do {  
            // Första val sker i klassen Menyer. Kund eller personal.
            kund = Menyer.ValkommenKundEllerPersonal();
            
            // Om inte kund kommer bilhallen så småningom att stänga.
            if(!kund) fortfarandeOppet = false;           
            
            // Om kund får kund göra en kundregistrering.
            if(kund)Menyer.Registrering();
            
            // Menystrukturen för kund ligger inne i en inre While-loop som möjligjör fortsatta köp som samma kund.           
            // Denna körs så länge det är en kund i hallen.
            while (kund){
                // Användaren/kunden får göra sitt val (vad som ska göras i bilhallen idag).
                int menyval = Menyer.HuvudMeny();
                
                // Boolean för meny hantering. Om en bilaffär gjorts tvingas
                // vi till en ny kundregistrering.              
                boolean bilAffar = false;

                // Switch-case anropar olika metoder i olika klasser beroende på kundens val.
                switch (menyval) {
                    case 1:
                        menyval = Menyer.VerkstadsMenyn();
                        Service.ServiceVal(menyval);
                        break;
                    case 2:
                        menyval = Menyer.Tvattmeny();
                        Tvatt.TvattVal(menyval);
                        break;
                    case 3:
                        Lager.BilarILager();
                        break;
                    case 4:
                        Lager.SaljaBil();
                        bilAffar = true;
                        break;
                    case 5:
                        Kund.KundSaljaBil();
                        bilAffar = true;
                        break;
                }
                if(!bilAffar)kund = Menyer.HandlaMerEllerNyKund();
                else kund = false;
            }
 
        } while (fortfarandeOppet);
        
        // Bokslut över dagens kunder och bilförsäljning. Om den yttre
        // Do-while-loopen hoppar ur körs metoden för bokslut i klassen Menyer.
        
        Menyer.Bokslut();
    }           
        
        //GetInput metod för integer används vid kundval.
    
        public static int GetInput(){
            Scanner scan = new Scanner(System.in);
            int input = Integer.parseInt(scan.next()); //Parse to int för att säkerställa exception om inte tolkbart till integer.
            return input;
        }
        //GetInputString metod för String används vid kundval.
        
        public static String GetInputString(){
            Scanner scan = new Scanner(System.in); //Försäkra om inget slask i buffertminnet.
            String input = scan.next().trim(); //Trimmar bort tomrum innan och efter text.
            return input;
        }
}
