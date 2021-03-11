/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupparbete.programmering.grupp.pkg5;
import java.util.Random;

/**
 *
 * @author schum
 */
public class Service {
    
    //Om service väljs i huvudmenyn
    public static void ServiceVal(int menyval){ 
        
        // Random-metoderna nedanför i den "nästlade" IF-satsen ger 
        //slumpmässiga utfall om verkstaden behöver göra något arbete eller ej.
        Random randBoolean = new Random ();
        boolean random = randBoolean.nextBoolean();
    
        switch(menyval){
            case 1:
                System.out.println("Bromsservice. Nu kollar vi dina bromsar.");
                if (random == true)BromsService();
                else System.out.println("Bromsarna ser bra ut och behöver inte bytas!");                           
                break;
            case 2:
                System.out.println("Motorservice. Nu kollar vi motorns skick.");
                if (random == true)MotorService();
                else System.out.println("Motoroljan ser bra ut, behöver inte bytas. Motorn är OK.");       
                break;
            case 3:
                System.out.println("Däckservice. Nu kollar vi skicket på däcken");
                if (random == true)DackService();
                else System.out.println("Däcken behöver inte bytas. Mönsterdjupet är bra.");           
                break;
        }
    }

         
    
    // Skapar metoder för de olika servicealternativen som erbjuds
    public static void BromsService (){
    System.out.println("Bromsarna är slut och behöver bytas.");    
    }

    public static void DackService () {
    System.out.println("Nu har vi bytt till nya fina däck på bilen!"); 
    }
   
    public static void MotorService (){
    System.out.println("Motoroljan är bytt och motorn är OK!");
    }
    
}


