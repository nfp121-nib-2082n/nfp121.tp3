package question1;

import question1.PilePleineException;
import question1.PileVideException;

/**
 * A remplacer par votre classe Pile .
 * 
 * @author (Charbel Abi Rizk)
 * @version (5/31/2020)
 */
public class Pile {
    public final static int TAILLE_PAR_DEFAUT = 5;

    private Object[] zone;
    private int ptr;

    /**
     * à compléter
     * 
     */
    
    public Object sommet() throws PileVideException {
        if(estVide())
            throw new PileVideException();
        return zone[ptr - 1];
    }
    
    public int capacite(){
        int capacite = TAILLE_PAR_DEFAUT - ptr;
        return capacite;
    }
    
    public int taille(){
        return ptr;
    }
    
    public boolean equals(Object o) {
        return zone.equals(o);
    }
    
    public int hashCode() {
        return zone.hashCode();
    }
    
    public Pile(int taille) {
        if (taille < 0)
            taille = TAILLE_PAR_DEFAUT;
        this.zone = new Object[taille];
        this.ptr = 0;
    }

    public Pile() {
        this(TAILLE_PAR_DEFAUT);
    }

    public void empiler(Object i) throws PilePleineException {
        if (estPleine())
            throw new PilePleineException();
        this.zone[this.ptr] = i;
        this.ptr++;
    }

    public Object depiler() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        this.ptr--;
        return zone[ptr];
    }

    public boolean estVide() {
        return ptr == 0;
    }

    public boolean estPleine() {
        return ptr == zone.length;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("[");
        for (int i = ptr - 1; i >= 0; i--) {
           // sb.append(Integer.toString(zone[i]));
           sb.append((Object)zone[i]);
            if (i > 0)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}