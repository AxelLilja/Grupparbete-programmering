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
 
        //Fyller på listaBilar med bilar från lagret
        Lager.SkapaListaBilar();
        
        //Booleans för looparna
        //Om kund eller personal
        boolean kund;
        //Personal stänger Bilhallen för dagen
        boolean fortfarandeOppet = true;

        do {         
            kund = Menyer.ValkommenKundEllerPersonal();
            if(!kund) fortfarandeOppet = false;           
            
            //Kundregistrering
            if(kund)Menyer.Registrering();
            
            // Menystrukturen ligger inne i en While-loop som möjligjör fortsatt köp som samma kund           
            while (kund){
                //Användaren/kunden får göra sitt val (vad som ska göras i bilhallen idag).
                int menyval = Menyer.HuvudMeny();
                
                //Booleans för meny hantering, om bilaffär gjorts
                //tvingas vi till ny kund registrering
                
                boolean bilAffar = false;
                //TODO snyggare att ändra dessa if-satser till switchcase
                if (menyval == 1){
                    menyval = Menyer.VerkstadsMenyn();
                    Service.ServiceVal(menyval);
                }       
                else if (menyval == 2){
                    menyval = Menyer.tvattmeny();
                    Tvatt.TvattVal(menyval);
                }     
                else if (menyval == 3){
                    Lager.BilarILager();
                }
                else if (menyval == 4){
                    Lager.SaljaBil();
                    bilAffar = true;
                }   
                else if (menyval == 5){
                    Kund.KundSaljaBil();
                    bilAffar = true;
                }    
                else {
                    //Detta allternativ kommer aldrig att kunna nås valet begränsas till 1-5 i huvudmenyns inputssäkrare
                    // Om kunden inte vill ha "hjälp" får kunden säga till och tas automatiskt tillbaka till startmenyn.
                    System.out.println("Säljare: Jag förstår om du vill fundera. Säg till om du vill ha hjälp!");
                }
                if(!bilAffar)kund = Menyer.HandlaMerEllerNyKund();
                else kund = false;
            }//While loopens slut
 
        } while (fortfarandeOppet);
        //Bokslut över dagens kunder och bilförsäljning
        Menyer.Bokslut();
    }           
        
        
  
    
        //GetInput funktion integer
        public static int GetInput(){
            Scanner scan = new Scanner(System.in);
            int input = Integer.parseInt(scan.next());//Parse to int för att säkerställa exception om inte tolkbart till integer
            return input;
        }
        //GetInputString funktion String
        public static String GetInputString(){
            Scanner scan = new Scanner(System.in);//Försäkra om inget slask i buffertminnet
            String input = scan.next().trim(); //Trimmar bort tomrum innan och efter text
            return input;
        }
}
