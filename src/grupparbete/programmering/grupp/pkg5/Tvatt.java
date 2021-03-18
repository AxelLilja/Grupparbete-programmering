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
public class Tvatt {
    
    // Metod om tvätt väljs som menyval. I Switch-case nedan som är en del av metoden för TvattVal gör kunden sitt val.
    // Parametern menyval kommer ifrån klassen Bilhall och används som inparameter.
    
    public static void TvattVal(int menyval){
        switch (menyval) {
            case 1 -> {
            System.out.println();
            Tvatt.LitenTvatt();
        }
        case 2 -> {
            System.out.println();
            Tvatt.MellanTvatt();
        }
        case 3 -> {
            System.out.println();
            Tvatt.StorTvatt();
        }
        }
    }
    
    // Metoder för de olika tvättalternativen som erbjuds.
    // Beroende på kundens val anropas olika metoder.
    
    public static void LitenTvatt () {
        System.out.println("Nu är bilen avspolad och en liten tvätt är utförd");
    }

    public static void MellanTvatt () {
        System.out.println("Nu är bilen avspolad och schamponerad och en mellanstor tvätt är utförd");
    }

    public static void StorTvatt () {
        System.out.println("Nu är bilen avspolad, schamponerad, dammsugen och fönsterputs är utförd. En stor tvätt helt enkelt.");
    }  

}




