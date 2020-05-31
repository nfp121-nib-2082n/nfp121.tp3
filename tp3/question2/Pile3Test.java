package question2;
import java.util.Vector;
/**
 * Classe-test Pile3Test.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 * 
 *          Les classes-test sont documentées ici :
 *          http://junit.sourceforge.net/javadoc/junit/framework/TestCase.html
 *          et sont basées sur le document © 2002 Robert A. Ballance intitulé
 *          «JUnit: Unit Testing Framework».
 * 
 *          Les objets Test (et TestSuite) sont associés aux classes à tester
 *          par la simple relation yyyTest (e.g. qu'un Test de la classe
 *          Name.java se nommera NameTest.java); les deux se retrouvent dans le
 *          même paquetage. Les "engagements" (anglais : "fixture") forment un
 *          ensemble de conditions qui sont vraies pour chaque méthode Test à
 *          exécuter. Il peut y avoir plus d'une méthode Test dans une classe
 *          Test; leur ensemble forme un objet TestSuite. BlueJ découvrira
 *          automatiquement (par introspection) les méthodes Test de votre
 *          classe Test et générera la TestSuite conséquente. Chaque appel d'une
 *          méthode Test sera précédé d'un appel de setUp(), qui réalise les
 *          engagements, et suivi d'un appel à tearDown(), qui les détruit.
 */
public class Pile3Test extends junit.framework.TestCase {
	// Définissez ici les variables d'instance nécessaires à vos engagements;
	// Vous pouvez également les saisir automatiquement du présentoir
	// à l'aide du menu contextuel "Présentoir --> Engagements".
	// Notez cependant que ce dernier ne peut saisir les objets primitifs
	// du présentoir (les objets sans constructeur, comme int, float, etc.).

	/**
	 * Constructeur de la classe-test Pile3Test
	 */
	
	private Pile3 pile3;
	private Vector pileCompare;
	
	public Pile3Test() {
	}

	/**
	 * Met en place les engagements.
	 * 
	 * Méthode appelée avant chaque appel de méthode de test.
	 */
	protected void setUp() // throws java.lang.Exception
	{
		pile3 = new Pile3(4);
		try {
			pile3.empiler("Jack");
			pile3.empiler("Queen");
			pile3.empiler("joe");
			pile3.empiler("King");
		} catch (Exception e) {
			e.printStackTrace();
		}

		pileCompare = new Vector<String>();
		try {
			pileCompare.add("Jack");
			pileCompare.add("Queen");
			pileCompare.add("joe");
			pileCompare.add("King");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Supprime les engagements
	 * 
	 * M�thode appel�e apr�s chaque appel de m�thode de test.
	 */
	protected void tearDown() // throws java.lang.Exception
	{
		// Lib�rez ici les ressources engag�es par setUp()
	}

	public void test_sommet() {
		try {
			assertEquals(" Sommet ? ", "King", pile3.sommet());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void test_estVide() {
		assertEquals(" stackOfCards est vide  ? ", false, pile3.estVide());
	}

	public void test_estPleine() {
		assertEquals(" estPleine  ? ", false, pile3.estPleine());
	}

	public void test_estPleineV2() {
		try {
			pile3.empiler("jad");
			pile3.empiler("mina");
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(" estPleine2  ", true, pile3.estPleine());
	}

	public void test_equals() {
		assertEquals(" equals  ? ", true, pile3.equals(pileCompare));

	}

	public void test_equalsV2() {
		try {
			pile3.depiler();
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(" equals  ? ", false, pile3.equals(pileCompare));
	}

	public void test_taille() {
		assertEquals(" taille  ? ", 2, pile3.taille());
	}

	public void test_capacite() {
		assertEquals(" capacite  ? ", 6, pile3.capacite());
	}

	/**
	 * Il ne vous reste plus qu'à définir une ou plusieurs méthodes de test. Ces
	 * méthodes doivent vérifier les résultats attendus à l'aide d'assertions
	 * assertTrue(<boolean>). Par convention, leurs noms devraient débuter par
	 * "test". Vous pouvez ébaucher le corps grâce au menu contextuel
	 * "Enregistrer une méthode de test".
	 */

}
