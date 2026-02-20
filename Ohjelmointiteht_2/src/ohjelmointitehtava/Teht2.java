package ohjelmointitehtava;

import java.util.Arrays;

/**
 * @author ville
 * @version 11 Nov 2025
 *
 */
public class Teht2 {
    
    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        int[] taulukko = {10, 6, 4};
        boolean tyhja = isEmpty(taulukko);
        System.out.println(tyhja);
        int koko = size(taulukko);
        System.out.println(koko);
        int ensimmainen = front(taulukko);
        System.out.println(ensimmainen);
        taulukko = enqueue(taulukko, 5);
        System.out.println(Arrays.toString(taulukko));
        Object[] tulos = dequeue(taulukko);
        int poistettuAlkio = (int) tulos[0];
        taulukko = (int[]) tulos[1];
        System.out.println(poistettuAlkio);
        System.out.println(Arrays.toString(taulukko));
    }
    
    
    /**
     * Katsotaan onko taulukko tyhjä vai onko siinä edes yksi alkio
     * @param t taulukko
     * @return true jos taulukko on tyhjä false jos taulukossa on edes yksi alkio
     */
    private static boolean isEmpty(int[] t) {
        return (t.length == 0) ? true : false;
    }
    
    
    /**
     * Tarkastetaan taulukon pituus
     * @param t taulukko
     * @return taulukon pituus
     */
   private static int size(int[] t) {
       return t.length;
   }
   
   /**
    * Katsotaan taulukon ensimmäinen alkio
    * @param t taulukko
    * @return taulukon ensimmäinen alkio
    */
   private static int front(int[] t) {
       if (!isEmpty(t)) return t[0];
    return 0;
   }


   /**
    * Lisätään taulukkoon uusia alkioita lisäämällä ne loppuun 
    * @param t taulukko jota muokataan
    * @param lisattava alkio joka lisätään 
    * @return taulukko johon on lisätty parametri lisattava 
    */
   private static int[] enqueue(int[] t, int lisattava) {
       int[] taulukko = new int[t.length + 1];
       for (int i = 0; i<t.length; i++) {
           taulukko[i] = t[i];
       }
       taulukko[taulukko.length - 1] = lisattava;
       return taulukko;
   }
   
   /**
    * Poistetaan taulukosta ensimmäinen alkio ja siirretään muita yhdellä eteenpäin
    * @param t taulukko
    * @return taulukko josta on poistettu ensimmäinen alkio
    */
   private static Object[] dequeue(int[] t) {
       if (isEmpty(t)) return new Object[]{null, t};
       
       int tEka = front(t);
       
       int[] taulukko = new int[t.length - 1];
       
       for (int i = 0; i < t.length -1; i++) {
           taulukko[i] = t[i+1];
       }
       
       return new Object[]{tEka, taulukko};
   }

   
}
