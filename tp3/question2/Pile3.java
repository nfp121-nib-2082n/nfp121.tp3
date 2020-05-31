package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Vector;

/**
 * Décrivez votre classe PileVector ici.
 * 
 * @author (Charbel Abi Rizk)
 * @version (5/331/2020)
 */
public class Pile3 implements PileI {

    private Vector<Object> v;

    public Pile3() {
        this(0);
    }

    public Pile3(int taille) {
        if (taille > 0)
            this.v = new Vector<Object>();
    }

    public void empiler(Object o) throws PilePleineException {
        if (estPleine())
            throw new PilePleineException();
        v.add(o);
    }

    public Object depiler() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        return v.remove(v.size() - 1);
    }

    public Object sommet() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        return v.lastElement();
    }

    public int taille() {
        return v.size();
    }

    public int capacite() {
        return CAPACITE_PAR_DEFAUT;
    }

    public boolean estVide() {
        return v.size() == 0;
    }

    public boolean estPleine() {
        return v.size() == CAPACITE_PAR_DEFAUT;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("[");
        for (int i = v.size() - 1; i >= 0; i--) {
            // sb.append(Integer.toString(zone[i]));
            sb.append((Object) v.get(i));
            if (i > 0)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    public boolean equals(Vector<Object> o) {
        // If they point to the same object return true
        if (v == o)
            return true;
        // Check for nulls
        if (v == null || o == null)
            return false;
        // If the stacks are not the same length, then they won't be equal, easy first
        // test case
        if (v.size() != o.size())
            return false;

        for (int i = v.size() - 1; i >= 0; i--) {
            // Step through each item in both stacks, if any don't match return false
            if (!v.get(i).equals(o.get(i)))
                return false;
        }

        // Haven't returned yet, they must be equal
        return true;
    }
    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

}
