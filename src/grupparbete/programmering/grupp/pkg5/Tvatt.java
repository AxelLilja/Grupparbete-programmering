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
    //Om tvätt väljs i huvudmenyn
    public static void TvattVal(){
        System.out.println("Välkommen till våran tvättavdelning!");
    }
    
    // Skapar metoder för de olika tvättalternativen som erbjuds
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




