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
public class Forsakring {

    // Metoder som tecknar antingen en hel- eller halvförsäkring beroende på bilens körsträcka vid köptillfället.
    // Anropas vid köp av bil ifrån klassen Lager och metoden för att bilhallen säljer bil.
    public static void tecknaHelForsakring (){
        System.out.println("helförsäkring");
    }
    
    public static void tecknaHalvForsakring (){
        System.out.println("halvförsäkring");
    }
}
