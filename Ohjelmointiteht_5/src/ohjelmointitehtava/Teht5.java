package ohjelmointitehtava;

import java.util.Arrays;
import java.util.Random;

/**
 * @author ville
 * @version 11 Dec 2025
 *
 */
public class Teht5 {
    
    /**
     * Pääohjelma jossa testitulostukset lajittelu algoritmeille
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        int [] taulukkoKupla = luoTaulukko(20);
        System.out.println("Järjestämätön taulukko: \n" + Arrays.toString(taulukkoKupla));
        System.out.println("Kuplalajittelulla järjestetty taulukko: \n" + Arrays.toString(kuplaLajittelu(taulukkoKupla)));
        int [] taulukkoLasku = luoTaulukko(20);
        System.out.println("Järjestämätön taulukko: \n" + Arrays.toString(taulukkoLasku));
        System.out.println("Lasketnalajittelulla järjestetty taulukko: \n" + Arrays.toString(laskentaLajittelu(taulukkoLasku)));
        
        //Omaksi iloksi suuret taulukot lajiteltu myös
        int [] taulukkoKupla1000 = luoTaulukko(1000);
        System.out.println("Järjestämätön taulukko kooltaan 1000: \n" + Arrays.toString(taulukkoKupla1000));
        System.out.println("Kuplalajittelulla järjestetty taulukko kooltaan 1000: \n" + Arrays.toString(kuplaLajittelu(taulukkoKupla1000)));
        int [] taulukkoLasku1000 = luoTaulukko(1000);
        System.out.println("Järjestämätön taulukko kooltaan 1000: \n" + Arrays.toString(taulukkoLasku1000));
        System.out.println("Lasketnalajittelulla järjestetty taulukko kooltaan 1000: \n" + Arrays.toString(laskentaLajittelu(taulukkoLasku1000)));
        
        int [] taulukkoKupla2000 = luoTaulukko(2000);
        System.out.println("Järjestämätön taulukko kooltaan 2000: \n" + Arrays.toString(taulukkoKupla2000));
        System.out.println("Kuplalajittelulla järjestetty taulukko kooltaan 2000: \n" + Arrays.toString(kuplaLajittelu(taulukkoKupla2000)));
        int [] taulukkoLasku2000 = luoTaulukko(2000);
        System.out.println("Järjestämätön taulukko kooltaan 2000: \n" + Arrays.toString(taulukkoLasku2000));
        System.out.println("Lasketnalajittelulla järjestetty taulukko kooltaan 2000: \n" + Arrays.toString(laskentaLajittelu(taulukkoLasku2000)));
        
        int [] taulukkoKupla4000 = luoTaulukko(4000);
        System.out.println("Järjestämätön taulukko kooltaan 4000: \n" + Arrays.toString(taulukkoKupla4000));
        System.out.println("Kuplalajittelulla järjestetty taulukko kooltaan 4000: \n" + Arrays.toString(kuplaLajittelu(taulukkoKupla4000)));
        int [] taulukkoLasku4000 = luoTaulukko(4000);
        System.out.println("Järjestämätön taulukko kooltaan 4000: \n" + Arrays.toString(taulukkoLasku4000));
        System.out.println("Lasketnalajittelulla järjestetty taulukko kooltaan 4000: \n" + Arrays.toString(laskentaLajittelu(taulukkoLasku4000)));
        
        int [] taulukkoKupla8000 = luoTaulukko(8000);
        System.out.println("Järjestämätön taulukko kooltaan 8000: \n" + Arrays.toString(taulukkoKupla8000));
        System.out.println("Kuplalajittelulla järjestetty taulukko kooltaan 8000: \n" + Arrays.toString(kuplaLajittelu(taulukkoKupla8000)));
        int [] taulukkoLasku8000 = luoTaulukko(8000);
        System.out.println("Järjestämätön taulukko kooltaan 8000: \n" + Arrays.toString(taulukkoLasku8000));
        System.out.println("Lasketnalajittelulla järjestetty taulukko kooltaan 8000: \n" + Arrays.toString(laskentaLajittelu(taulukkoLasku8000)));
    }
    
    
    /**
     * Järjestetään taulukko kupla lajittelulla
     * @param t järjestämätön taulukko
     * @return järjestetty taulukko
     */
    public static int[] kuplaLajittelu(int[] t) {
        for (int i = 0; i < t.length - 1; i++) {
            for (int j = t.length - 2; j > i - 1; j--) {
                if (t[j] > t[j + 1]) {
                    int apu = t[j];
                    t[j] = t[j + 1];
                    t[j + 1] = apu;
                }
            }
        }
        
        return t;
    }
    
    
    /**
     * Järjestetään taulukko laskenta lajittelulla
     * @param t järjestelemätön taulukko
     * @return järjestetty taulukko
     */
    public static int[] laskentaLajittelu(int[] t) {
        int suurin = t[0];
        for (int i = 1; i < t.length; i++) {
            if (t[i] > suurin) suurin = t[i];
        }
        
        int[] lukuMaaraT = new int[suurin + 1];
        for (int i = 0; i <= suurin; i++) {
            lukuMaaraT[i] = 0;
        }
        
        for (int i = 0; i < t.length; i++) {
            lukuMaaraT[t[i]]++;
        }

        for (int i = 1; i <= suurin; i++) {
            lukuMaaraT[i] += lukuMaaraT[i - 1];
        }

        int[] jarjTaul = new int[t.length];
        for (int i = t.length - 1; i >= 0; i--) {
            int v = t[i];
            jarjTaul[lukuMaaraT[v] - 1] = v;
            lukuMaaraT[v]--;
        }
        
        return jarjTaul;
    }
    
    
    /**
     * Luodaan taulukko käyttäen random arvoja
     * @param pituus haluttu taulukon pituus
     * @return Taulukko joka juuri luotiin
     */
    public static int[] luoTaulukko(int pituus) {
        Random rand = new Random();
        int min = 0;
        int max = 100;
        //int maxPituus = 20;
        //int randomPituus = rand.nextInt(min, maxPituus);
        int[] taulukko = new int[pituus];
        
        for (int i = 0; i < pituus; i++) {
            taulukko[i] = rand.nextInt(min, max);
        }
        
        return taulukko;
    }
}
