package ohjelmointitehtava;

/**
 * @author ville
 * @version 4 Dec 2025
 *
 */
public class Teht4 {
    
    /**
     * 
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        BinaariPuu puu = new BinaariPuu();
        puu.lisaa(25);
        puu.lisaa(15);
        puu.lisaa(12);
        puu.lisaa(13);
        puu.lisaa(20);
        puu.lisaa(18);
        puu.lisaa(21);
        puu.lisaa(27);
        puu.lisaa(30);
        puu.lisaa(28);
        
        puu.esiJarj();
        puu.sisaJarj();
        puu.jalkiJarj();
        
    }
    
}


class Solmu {
    public int key;
    public Solmu left;
    public Solmu right;
    
    public Solmu(int key) {
        this.key = key;
    }
  }

class BinaariPuu {
    Solmu juuri;
    
    /**
     * lisätään arvo puuhun
     * @param key lisättävä arvo
     */
    public void lisaa(int key) {
        juuri = lisaa(juuri, key);
    }
    
    
    /**
     * Lisätään
     * @param juuriSolmu binääripuun juuri
     * @param key arvo joka lisätään
     * @return palautetaan juuri 
     */
    private Solmu lisaa(Solmu juuriSolmu, int key) {
        if (juuriSolmu == null) {
            return new Solmu(key); 
        }

        if (key < juuriSolmu.key) {
            juuriSolmu.left = lisaa(juuriSolmu.left, key);
        } else if (key > juuriSolmu.key) {
            juuriSolmu.right = lisaa(juuriSolmu.right, key);
        }

        return juuriSolmu;
    }
    
    
    /**
     * Tulostetaan alkiot esijärjestyksessä
     */
    public void esiJarj() {
        System.out.println("Esijärjestys:");
        esiJarj(juuri);
        System.out.println();
    }
    
    
    /**
     * Tulostetaan alkiot esijärjestyksessä
     * @param x puun tai alipuun juuri
     */
    private void esiJarj(Solmu x) {
        if (x != null) {
            System.out.print(x.key + " ");
            esiJarj(x.left);
            esiJarj(x.right);
        }
    }
    
    
    /**
     * Tulostetaan alkiot sisäjärjestyksessä
     */
    public void sisaJarj() {
        System.out.println("Sisäjärjestys:");
        sisaJarj(juuri);
        System.out.println();
    }
    
    
    /**
     * Tulostetaan alkiot sisäjärjestyksessä
     * @param x puun tai alipuun juuri
     */
    private void sisaJarj(Solmu x) {
        if (x != null) {
            sisaJarj(x.left);
            System.out.print(x.key + " ");
            sisaJarj(x.right);
        }
    }
    
    
    /**
     * Tulostetaan alkiot jälkijärjestyksessä
     */
    public void jalkiJarj() {
        System.out.println("Jälkijärjestys:");
        jalkiJarj(juuri);
        System.out.println();
    }
    
    
    /**
     * Tulostetaan alkiot jälkijärjestyksessä
     * @param x puun tai alipuun juuri
     */
    private void jalkiJarj(Solmu x) {
        if (x != null) {
            jalkiJarj(x.left);
            jalkiJarj(x.right);
            System.out.print(x.key + " ");
        }
    }
}