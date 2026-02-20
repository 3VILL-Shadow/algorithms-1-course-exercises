package Ohjelmointitehtava;

import java.util.Arrays;
import java.util.Random;

/**
 * @author ville
 * @version 25 Nov 2025
 *
 */
public class Teht3 {
    
    
    /**
     * @param args ei käytös
     */
    public static void main(String[] args) {
        System.out.println("Puolitushaku teki " + puolitusHaku(jarjestaTaulukko(luoTaulukko(0, 10, 7)), 4) + " vertailua");
        System.out.println("Puolitushaku teki " + puolitusHaku(jarjestaTaulukko(luoTaulukko(0, 50, 20)), 33) + " vertailua");
        System.out.println("Puolitushaku teki " + puolitusHaku(jarjestaTaulukko(luoTaulukko(0, 1000, 100)), 867) + " vertailua");
        System.out.println("Puolitushaku teki " + puolitusHaku(jarjestaTaulukko(luoTaulukko(0, 25, 15)), 10) + " vertailua");
        System.out.println("Puolitushaku teki " + puolitusHaku(jarjestaTaulukko(luoTaulukko(0, 50, 10)), 20) + " vertailua");
    }
    
    
    /**
     * Toteutetaan puolitus haku joka hakee taulukosta halutun arvon mikäli mahdollista.
     * @param t taulukkos josta etsitään
     * @param haettava etisitty luku
     * @return vertailuoperaatioiden määrä
     */
    public static int puolitusHaku(int[] t, int haettava) {
        int alaRaja = -1;
        int ylaRaja = t.length;
        int vertailut = 0;
        
        
        while (ylaRaja - alaRaja > 1) {
            int puoliVali = (alaRaja + ylaRaja) / 2;
            vertailut++;
            if (haettava <= t[puoliVali]) ylaRaja = puoliVali;
            else alaRaja = puoliVali;
        }
        vertailut++;
        if (ylaRaja < t.length && haettava == t[ylaRaja]) {
            System.out.println("Haettu: " + haettava + " löytyi");
        }
        
        else System.out.println("Haettu: " + haettava + " ei löytynyt taulukosta");
        
        return vertailut;
    }
    
    
    /**
     * Luodaan taulukko käyttäen random arvoja
     * @param min taulukon minimi arvo
     * @param max taulukon maksimi arvo
     * @param maxPituus taulukon maksimi pituus
     * @return Taulukko joka juuri luotiin
     */
    public static int[] luoTaulukko(int min, int max, int maxPituus) {
        Random rand = new Random();
        int[] taulukko = new int[maxPituus];
        
        for (int i = 0; i < taulukko.length; i++) {
            taulukko[i] = rand.nextInt(min, max);
        }
        
        return taulukko;
    }
    
    
    /**
     * Apu metodi taulukon järjestämiseksi
     * @param t taulukko joka järjestetään
     * @return järjestetty taulukko
     */
    public static int[] jarjestaTaulukko(int[] t) {
        System.out.println(Arrays.toString(t));
        Arrays.sort(t);
        System.out.println(Arrays.toString(t));
        return t;
    }
}
