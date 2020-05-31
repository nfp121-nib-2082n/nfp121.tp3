package question3;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2<T> implements PileI<T>{
    /** par délégation : utilisation de la class Stack */
    private Stack<T> stk;
    /** la capacité de la pile */
    private int capacite = CAPACITE_PAR_DEFAUT;

    /** Création d'une pile.
     * @param taille la "taille maximale" de la pile, doit être > 0
     */
    public Pile2(int taille){
      if (taille > 0)
            this.stk = new Stack<T>();
    }

    public Pile2(){
           this(0);
    }

    public void empiler(T o) throws PilePleineException{
        if (estPleine())
            throw new PilePleineException();
        stk.push(o);
    }

    public T depiler() throws PileVideException{
        if (estVide())
            throw new PileVideException();
        return stk.pop();
    }

    public T sommet() throws PileVideException{
        if (estVide())
            throw new PileVideException();
        return stk.peek();
    }

    
        public int capacite() {
        return capacite;
    };

    public int taille() {
        return stk.size();
    };

    public boolean estVide() {
        return stk.size() == 0;
    };

    public boolean estPleine() {
        return stk.size() == capacite;
    };

    public boolean equals(Stack<T> o) {
        Stack<T> stkTemp = new Stack<T>();
        Stack<T> stkTemp2 = new Stack<T>();
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
            T comapre = stk.pop();
            T comapreTo = o.pop();
            stkTemp.push(comapre);
            if (comapre.getClass() == Integer.class && comapreTo.getClass() == Integer.class) {
                if (comapre != comapreTo)
                    return false;
            } else if (comapre.getClass() == String.class && comapreTo.getClass() == String.class) {
                if (comapre != comapreTo)
                    return false;
            } else {
                if (!comapre.equals(comapreTo))
                    return false;
            }
        }
        for (int i = stkTemp.size() - 1; i >= 0; i--) {
            T o2 = stkTemp.pop();
            stkTemp2.push(o2);
        }
        this.stk = stkTemp2;

        // Haven't returned yet, they must be equal
        return true;

    };

    public int hashCode() {
        return toString().hashCode();
    };

    public String toString() {
        StringBuffer sb = new StringBuffer("[");
        Stack<T> stkTemp = new Stack<T>();
        Stack<T> stkTemp2 = new Stack<T>();
        for (int i = stk.size() - 1; i >= 0; i--) {
            T o = stk.pop();
            stkTemp.push(o);
            sb.append(o);
            if (i > 0)
                sb.append(", ");
        }
        for (int i = stkTemp.size() - 1; i >= 0; i--) {
            T o2 = stkTemp.pop();
            stkTemp2.push(o2);
        }
        stk = stkTemp2;
        sb.append("]");
        return sb.toString();
    };
    // recopier ici toutes les autres méthodes
    // qui ne sont pas modifiées en fonction
    // du type des éléments de la pile

} // Pile2