package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2 implements PileI {
    /** par delegation : utilisation de la class Stack */
    private Stack<Object> stk;

    /** la capacite de la pile */
    private int capacite = CAPACITE_PAR_DEFAUT;

    /**
     * Creation d'une pile.
     * 
     * @param taille
     *            la taille de la pile, la taille doit etre > 0
     */
    public Pile2(int taille) {
        if (taille > 0)
            this.stk = new Stack<Object>();
    }

    // constructeur fourni
    public Pile2() {
        this(0);
    }

    public void empiler(Object o) throws PilePleineException {
        if (estPleine())
            throw new PilePleineException();
        stk.push(o);
    }

    public Object depiler() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        return stk.pop();
    }

    public Object sommet() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        return stk.peek();
    }

    /**
     * Effectue un test de l'etat de la pile.
     * 
     * @return vrai si la pile est vide, faux autrement
     */
    public boolean estVide() {
        return stk.size() == 0;
    }

    /**
     * Effectue un test de l'etat de la pile.
     * 
     * @return vrai si la pile est pleine, faux autrement
     */
    public boolean estPleine() {
         return stk.size() == capacite;
    }

    /**
     * Retourne une representation en String d'une pile, contenant la
     * representation en String de chaque element.
     * 
     * @return une representation en String d'une pile
     */
    public String toString() {
        StringBuffer sb = new StringBuffer("[");
        Stack<Object> stkTemp = new Stack<Object>();
        Stack<Object> stkTemp2 = new Stack<Object>();
        for (int i = stk.size() - 1; i >= 0; i--) {
            Object o = stk.pop();
            stkTemp.push(o);
            sb.append(o);
            if (i > 0)
                sb.append(", ");
        }
        for (int i = stkTemp.size() - 1; i >= 0; i--) {
            Object o2 = stkTemp.pop();
            stkTemp2.push(o2);
        }
        stk = stkTemp2;
        sb.append("]");
        return sb.toString();
    }

    public boolean equals(Stack<Object> o) {
        Stack<Object> stkTemp = new Stack<Object>();
        Stack<Object> stkTemp2 = new Stack<Object>();
        // If they point to the same object return true
        if (stk == o)
            return true;
        // Check for nulls
        if (stk == null || o == null)
            return false;
        // If the stacks are not the same length, then they won't be equal, easy first
        // test case
        if (stk.size() != o.size())
            return false;
        for (int i = stk.size() - 1; i >= 0; i--) {
            // Step through each item in both stacks, if any don't match return false
            Object comapre = stk.pop();
            Object comapreTo = o.pop();
            stkTemp.push(comapre);
            if (comapre.getClass() == Integer.class && comapreTo.getClass() == Integer.class) {
                if (comapre != comapreTo)
                    return false;
            } else if (comapre.getClass() == String.class && comapreTo.getClass() == String.class) {
                if (comapre != comapreTo)
                    return false;
            }
            // else {
            // if(!comapre.equals(comapreTo)) return false;
            // }
        }
        for (int i = stkTemp.size() - 1; i >= 0; i--) {
            Object o2 = stkTemp.pop();
            stkTemp2.push(o2);
        }
        this.stk = stkTemp2;

        // Haven't returned yet, they must be equal
        return true;
    }

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

    /**
     * Retourne le nombre d'element d'une pile.
     * 
     * @return le nombre d'element
     */
    public int taille() {
        return stk.size();
    }

    /**
     * Retourne la capacite de cette pile.
     * 
     * @return le nombre d'element
     */
    public int capacite() {
         return capacite;
    }

} // Pile2.java
