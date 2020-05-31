package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile4 implements PileI, Cloneable {
	/** la liste des Maillons/Elements */
	private Maillon stk;
	/** la capacité de la pile */
	private int capacite;
	/** le nombre */
	private int nombre;

	/**
	 * Classe interne "statique" contenant chaque élément de la chaine c'est une
	 * proposition, vous pouvez l'ignorer !
	 */
	private static class Maillon implements Cloneable {
		private Object element;
		private Maillon suivant;

		public Maillon(Object element, Maillon suivant) {
			this.element = element;
			this.suivant = suivant;
		}

		public Maillon suivant() {
			return this.suivant;
		}

		public Object element() {
			return this.element;
		}

		public Object clone() throws CloneNotSupportedException {
			Maillon m = (Maillon) super.clone();
			m.element = element;
			return m;
		}
	}

	/**
	 * Création d'une pile.
	 * 
	 * @param taille
	 *            la taille de la pile, la taille doit être > 0
	 */
	public Pile4(int taille) {
		if (taille <= 0)
			taille = CAPACITE_PAR_DEFAUT;
		this.stk = null;
		this.capacite = taille;
	}

	public Pile4() {
		this(PileI.CAPACITE_PAR_DEFAUT);
	}

	public void empiler(Object o) throws PilePleineException {
		if (estPleine())
			throw new PilePleineException();
		Maillon maillon = new Maillon(o, stk);
		stk = maillon;
		nombre++;
	}

	public Object depiler() throws PileVideException {
		if (estVide())
			throw new PileVideException();
		Object o = stk.element();
		stk = stk.suivant();
		nombre--;
		return o;
	}

	public Object sommet() throws PileVideException {
		if (estVide())
			throw new PileVideException();
		return stk.element();
	}

	/**
	 * Effectue un test de l'état de la pile.
	 * 
	 * @return vrai si la pile est vide, faux autrement
	 */
	public boolean estVide() {
		if (stk == null)
			return true;
		return false;
	}

	/**
	 * Effectue un test de l'état de la pile.
	 * 
	 * @return vrai si la pile est pleine, faux autrement
	 */
	public boolean estPleine() {
		return nombre == capacite;
	}

	/**
	 * Retourne une représentation en String d'une pile, contenant la
	 * représentation en String de chaque élément.
	 * 
	 * @return une représentation en String d'une pile
	 */
	public String toString() {
		String s = "[";
		Maillon x1 = null;
		try {
			x1 = (Maillon) stk.clone();
		} catch (Exception e) {
			e.printStackTrace();
		}
		while (x1 != null) {
			s += x1.element() + (x1.suivant() != null ? ", " : "");
			x1 = x1.suivant;
		}
		s = s + "]";
		System.out.println(s);
		return s;
	}

	public boolean equals(Object o) {
		if (o instanceof Pile4) {
			Pile4 pile = (Pile4) o;
			if (stk == o)
				return true;
			// Check for nulls
			if (stk == null || o == null)
				return false;
			// If the list are not the same length, then they won't be equal, easy first
			// test case
			if (this.capacite() != pile.capacite())
				return false;

			while (stk != null) {
				// Step through each item in both list, if any don't match return false
				Object x = stk.element();
				Object x1 = pile.stk.element();

				if (!x.equals(x1))
					return false;
				stk = stk.suivant();
				pile.stk = pile.stk.suivant();
			}

			// Haven't returned yet, they must be equal
			return true;
		}
		return false;
	}

	public int capacite() {
		return this.capacite;
	}

	public int hashCode() {
		return toString().hashCode();
	}

	public int taille() {
		return nombre;
	}
}