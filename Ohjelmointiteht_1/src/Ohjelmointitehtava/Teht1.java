/**
 * 
 */
package Ohjelmointitehtava;

import java.util.Arrays;
import java.util.Random;
/**
 * @author ville
 * @version 30 Oct 2025
 *
 */
public class Teht1 {

    /**
     * @param args ei käytös
     */
    public static void main(String[] args) {
        int[] taulukko = luoTaulukko();
        System.out.println("Taulukossa: "+ Arrays.toString(taulukko) + "välille [0, 10] kuuluu: " 
                            + tarkastaTaulukko(taulukko, 0, 10) + " lukua");
        System.out.println("Taulukossa: "+ Arrays.toString(taulukko) + "välille [50, 100] kuuluu: " 
                            + tarkastaTaulukko(taulukko, 50, 100) + " lukua");
        System.out.println("Taulukossa: "+ Arrays.toString(taulukko) + "välille [67, 75] kuuluu: " 
                            + tarkastaTaulukko(taulukko, 67, 75) + " lukua");
    
    }
    
    
    /**
     * Luodaan taulukko käyttäen random arvoja
     * @return Taulukko joka juuri luotiin
     */
    public static int[] luoTaulukko() {
        Random rand = new Random();
        int min = 0;
        int max = 100;
        int maxPituus = 20;
        int randomPituus = rand.nextInt(min, maxPituus);
        int[] taulukko = new int[randomPituus];
        
        for (int i = 0; i < randomPituus; i++) {
            taulukko[i] = rand.nextInt(min, max);
        }
        
        return taulukko;
    }
    
    
    /**
     * Tarkastetaan kuinka moni luku kuuluu välille
     * @param t taulukko
     * @param min välin alaraja
     * @param max välin yläraja
     * @return välille kuuluvien lukujen määrä
     */
    public static int tarkastaTaulukko(int[] t, int min, int max) {
        int valilla = 0;
        
        for (int i = 0; i < t.length; i++) {
            if (t[i] > min && t[i] < max) valilla++;
        }
        
        return valilla;
    }

}




