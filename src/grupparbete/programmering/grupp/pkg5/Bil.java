/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupparbete.programmering.grupp.pkg5;

/**
 *
 * @author schum
 */
public class Bil {
    
    // Attribut för klassen bilar
    public String tillverkare;
    private final String modell;
    private final String arsmodell;
    private final String farg;
    public int mil;
    public int pris;
    private final String vaxellada;
    
    // Skapar konstruktor för klassen Bil
    public Bil (String tillverkare, String modell, String arsmodell, String farg, int mil, int pris, String vaxellada){
        this.tillverkare = tillverkare;
        this.modell = modell;
        this.arsmodell = arsmodell;
        this. farg = farg;
        this.mil = mil;
        this.pris = pris;
        this.vaxellada = vaxellada;
        
        }
    
    // Metoden nedan beskriver bilen/objektet/instansen ifråga när listan för tillgängliga bilar presenteras
    public void Beskrivning(){
        System.out.println(": " +this.tillverkare + " " + this.modell + " årsmodell " +this.arsmodell + " i färgen " + this.farg + " som har gått " + this.mil + " mil" + " och kostar " + this.pris + ":- " + "Växellådan är " + this.vaxellada +".");
    }
    // Metod som bekräftar vilken bil som köparen vill köpa ifrån bilhallen
    public void Kopa (){
        System.out.println("Säljare: Vad roligt att du vill köpa denna " + this.tillverkare + " " + this.modell + " för " + this.pris + " kr av oss!");
    }
}
