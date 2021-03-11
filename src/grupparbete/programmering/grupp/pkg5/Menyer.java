/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupparbete.programmering.grupp.pkg5;

/**
 *
 * @author Bax Musik
 */
public class Menyer {
    private static int val;
    //Boolean för felaktigt val i menyn
    private static boolean felaktigInput = false;
    //Objekt av ny kund
    public static Kund nyKund;
    
    public static boolean ValkommenKundEllerPersonal(){
        System.out.println("\nVälkommen till vår Bilhall!");
        System.out.println("Logga in som:");
        System.out.println("1 Kund");
        System.out.println("2 Personal stänger Bilhallen");
        System.out.print("Gör ditt val: ");
        val = BilHall.GetInput();
        if(val == 2)return false;
        else return true;
    }
    
    public static void Registrering(){
        System.out.print("\nNy kund registrering krävs.\nVad heter ni? ");
        String namn = BilHall.GetInputString();
        //Skapar ett tomt Bilar objekt
        Bilar minBil = new Bilar("", "", "", "", 0, 0, "");
        //Skapar ett nyKund objekt
        nyKund = new Kund(namn, "", minBil);
        //Lägger till i lista över kunder
        Kund.listaKunder.add(nyKund);
    }
    
    public static int HuvudMeny(){
             
        // Huvudmenyn som presenteras.
        do {            
            System.out.println("");
            System.out.println("Huvudmeny");
            System.out.println("Vad vill du göra?");
            System.out.println("_______________________________________");
            System.out.println("");
            System.out.println("1 För att serva din bil.");
            System.out.println("2 För att få din bil tvättad.");
            System.out.println("3 För att titta på bil.");
            System.out.println("4 För att köpa bil.");
            System.out.println("5 För att sälja din bil till oss.");
            
            // Användaren/kunden får göra sitt val (vad som ska göras i bilhallen idag).
            System.out.print("\nVälj en siffra 1 - 5: ");
            try {
                val = BilHall.GetInput();
                if(val < 1 || val > 5){
                    System.out.println("Välj en siffra 1 till 5 !");
                    felaktigInput = true;
                }
            } catch (Exception e) {
                System.out.println("Felaktigt val, försök igen.");
                felaktigInput = true;
            }            
        } while (felaktigInput);
        return val ;
    }
    
    public static int VerkstadsMenyn(){
        do { 
            felaktigInput = false;
            System.out.println("\nVälkommen till verkstaden!");
            System.out.println("____________________________");
            System.out.println("Vi erbjuder följande service");
            System.out.println("____________________________");
            System.out.println("Tryck 1 för Bromsservice");
            System.out.println("Tryck 2 för Motorservice");
            System.out.println("Tryck 3 för Däckservice");
            System.out.println("");
            System.out.print("Val: ");
            
            // Användaren/kunden får göra sitt val
            try {
                val = BilHall.GetInput();
                if(val < 1 || val > 3){
                    System.out.println("Välj en siffra 1 till 3 !");
                    felaktigInput = true;
                }
            } catch (Exception e) {
                System.out.println("Felaktigt val, försök igen.");
                felaktigInput = true;
            } 
            
        } while (felaktigInput);
        return val;
    }
    public static int tvattmeny(){
        do {
        felaktigInput = false;
        System.out.println();
        System.out.println("Välkommen till våran tvättavdelning!");
        System.out.println();
        System.out.println("Tvättmeny");
        System.out.println("Vad vill du göra?");
        System.out.println("_______________________________________");
        System.out.println();
        System.out.println("1 För att få en liten tvätt ");
        System.out.println("2 För att få en mellan tvätt");
        System.out.println("3 För att få en stor tvätt");

        try {
            val = BilHall.GetInput();
            if(val < 1 || val > 3){
            System.out.println();
            System.out.println("Välj en siffra 1 till 3 !");
            felaktigInput = true;
            }
        } catch (Exception e) {
            System.out.println();
            System.out.println("Felaktigt val, försök igen.");
            felaktigInput = true;
        }

        } while (felaktigInput);
        return val;
    }
    
    public static boolean HandlaMerEllerNyKund(){
        System.out.println("\n1 Gå tillbaka till huvudmenyn.");
        System.out.println("2 Ge plats åt ny kund eller personal stänger för dagen.");
        val = BilHall.GetInput();
        if(val == 2)return false;
        else return true;       
    }

    public static void Bokslut(){
        System.out.println("\nDagens kunder och bil affärer:");
        for (Kund i : Kund.listaKunder) {
            System.out.println(i.namn+" "+i.typAvAffar+" "+i.minBil.tillverkare);       
        }
        System.out.println("\nBilar i lager:");
        int j = 1;
        for (Bilar i: Lager.listaBilar){
                System.out.print(j++);
                i.Beskrivning();                   
            }
    }
    
}
