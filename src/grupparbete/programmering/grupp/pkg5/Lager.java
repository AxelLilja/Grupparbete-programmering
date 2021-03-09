/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupparbete.programmering.grupp.pkg5;

import java.util.ArrayList;

/**
 *
 * @author Bax Musik
 */
public class Lager {
    // Skapar bilar/objekt/instanser av klassen Bilar
    static Bilar bil1 = new Bilar("Volvo", "V70", "2008", "silver metallic", 9000, 95000, "manuell");
    static Bilar bil2 = new Bilar("Honda", "Accord", "2005", "vit", 20000, 45000, "manuell");
    static Bilar bil3 = new Bilar("Volkswagen", "Golf", "2013", "svart", 5000, 105000, "automat");
    static Bilar bil4 = new Bilar("Kia", "Ceed", "2004","Vit", 2400, 56000, "manuell");
    
    // Lägger till olika bilar till listan över tillgängliga bilar i bilhallen.
    // Skapar en ArrayList för bilarna som finns i lager. Denna uppdateras om användaren köper eller säljer sin bil ("byter in") till bilhallen.
    public static ArrayList <Bilar> listaBilar = new ArrayList<>();
    
    //Fyll på listaBilar med bilar i lagret
    public static void SkapaListaBilar(){
    listaBilar.add(bil1);
    listaBilar.add(bil2);
    listaBilar.add(bil3);
    listaBilar.add(bil4);
    listaBilar.add(new Bilar("BMW", "320i", "2009", "grå metallic", 9800, 150000, "automat"));        
    }
    
    public static void BilarILager(){
        // Om det inte finns några bilar i lager ges felmeddelande.
        if (Lager.listaBilar.size() < 1){
            System.out.println("Tyvärr. Vi har inga bilar i lager idag");
        } 
        else {
            System.out.println("Säljare: Vad roligt att du vill titta på en av våra bilar i lager");
            System.out.println("Vi har följande bilar att erbjuda");
            System.out.println("");

        // Skapar en räknare för att visa rätt indexposition i ArrayListan för bilar (börjar på 0, d.v.s. samma som index i listan)
        int j = 0;

        // En forEach-loop går igenom listan med bilar och anropar medtoden Beskrivning () i klassen bilar som skriver ut information
        // Samtidigt så räknas räknaren upp och skrivs ut för varje varv. På så vis får varje bil ett nummer man kan hänvisa till.
        // När första indexet i listan skrivs ut kommer räknaren dock ha värde 1, så detta behöver man hålla koll på längre ned när.
        // kunden sen ska välja bil.

        for (Bilar i: Lager.listaBilar)
            {
                j++;
                System.out.print("Alternativ " + j);
                i.Beskrivning();                   
            }
        } 
    }
    public static void SaljaBil(){
       
        // Om det inte finns några bilar i lager så ges ett felmeddelande.
        if (Lager.listaBilar.size() < 1){
            System.out.println("Tyvärr. Vi har inga bilar i lager att sälja idag");
        } 
        else {
            System.out.println("Säljare: Jag har förstått att du har bestämt dig för en bil. Vilken föll valet på?");
            System.out.print("Köpare: Jag vill köpa bil: "); 
            int kopval = BilHall.GetInput();

            // Kund gör ett val mot bakgrund av listan som presenterades i menyn ovan (valet scannas av). Observera att vi behöver "backa" kundens val 
            // med -1 p.g.a. att räknaren och Arrayen inte riktigt stämmer överens när vi anropar vilket objekt/bil som ska köpas i metoden Kopa (). Köpet genomförs. 
            // Objektet/bilen tas sedan bort ifrån ArrayListan med metoden remove.

            Lager.listaBilar.get(kopval-1).Kopa();

            System.out.println("Säljare: Stort GRATTIS till din nya fina bil!");
            System.out.println("");

            System.out.println("Till bilen INGÅR dessutom en försäkring i 3 månader!");
            System.out.println("");

            // Beroende på hur långt bilen/objektet har gått så ingår en hel eller halvförsäkring i köpet.
            // Detta kollar vi genom att anropa objektets attribut för antal mil och anropar olika metoder i
            // klassen för försäkring beroende på utfall.

            System.out.print("Eftersom bilen har gått " + Lager.listaBilar.get(kopval-1).mil + " mil så ingår det en ");

            if (Lager.listaBilar.get(kopval-1).mil < 8000){
                Forsakring.tecknaHelForsakring();
            } 
            else {
                Forsakring.tecknaHalvForsakring();
            }
            System.out.println("");

            // En nyligen köpt bil behöver tvättas innan leverans. Tvättavdelningen och deras metod för Stor tvätt anropas.
            // Även serviceavdelningen involveras. Tyvärr visar det sig att bilen inte är i det bästa skicket :)

            System.out.println("Jag ska bara ringa till våran tvättavdelning och be dem tvätta av bilen innan leverans. ");
            System.out.println("Likaså kommer vi göra en avstämning av bromsarna, däck och motorn på service-avdelningen innan leverans.");
            System.out.println("");
            System.out.println("Protokollet från dessa genomgångar syns nedanför: ");
            System.out.println("");
            Tvatt.StorTvatt();
            Service.BromsService();
            Service.DackService();
            Service.MotorService();
            System.out.println("");

            System.out.println("Säljare: Vi hörs av och stämmer av en passande dag för leverans framöver!");
            System.out.println("Köpare: Absolut, det gör vi!");
            
            //Den köpta bilen läggs till i objektet nyKund
            Menyer.nyKund.minBil = Lager.listaBilar.get(kopval-1);
            //typ av affär ändras till köpt
            Menyer.nyKund.typAvAffar = "köpt";
            // Bilen tas bort från listan över bilar i lagret
            Lager.listaBilar.remove(kopval-1);
          }
    }
    
    // Metod som "köper in" bil, med ett antal inparametrar (av samma typ som klassens konstruktor) för att kunna lägga till nya bilar till ArrayListan för bilar
    public static void KopaInBil (Bilar minBil){
        listaBilar.add(minBil);
        //Den sålda bilen läggs till objektet nyKund
        Menyer.nyKund.minBil = minBil;
        //typ av affär ändras till sålt
        Menyer.nyKund.typAvAffar = "sålt";
    }
}
