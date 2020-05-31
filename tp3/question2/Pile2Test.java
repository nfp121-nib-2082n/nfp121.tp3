package question2;
import java.util.Stack;
/**
 * Classe-test Pile2Test.
 * 
 * @author (Charbel Abi Rizk)
 * @version (5/31/2020)
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
public class Pile2Test extends junit.framework.TestCase {
	// Définissez ici les variables d'instance nécessaires à vos engagements;
	// Vous pouvez également les saisir automatiquement du présentoir
	// à l'aide du menu contextuel "Présentoir --> Engagements".
	// Notez cependant que ce dernier ne peut saisir les objets primitifs
	// du présentoir (les objets sans constructeur, comme int, float, etc.).

	/**
	 * Constructeur de la classe-test Pile2Test
	 */
	private Pile2 pile2;
	private Stack pileCompare;
	
	public Pile2Test() {
	}

	/**
	 * Met en place les engagements.
	 * 
	 * Méthode appelée avant chaque appel de méthode de test.
	 */
	protected void setUp() // throws java.lang.Exception
	{
		pile2 = new Pile2(4);
		try {
			pile2.empiler("Jack");
			pile2.empiler("Queen");
			pile2.empiler("joe");
			pile2.empiler("King");
		} catch (Exception e) {
			e.printStackTrace();
		}

		pileCompare = new Stack<String>();
		try {
			pileCompare.push("Jack");
			pileCompare.push("Queen");
			pileCompare.push("joe");
			pileCompare.push("King");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Supprime les engagements
	 * 
	 * Méthode appelée après chaque appel de méthode de test.
	 */
	protected void tearDown() // throws java.lang.Exception
	{
		// Libérez ici les ressources engagées par setUp()
	}

	public void test_sommet() {
		try {
			assertEquals(" Sommet ? ", "King", pile2.sommet());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void test_estVide() {
		assertEquals(" stackOfCards est vide  ? ", false, pile2.estVide());
	}

	public void test_estPleine() {
		assertEquals(" estPleine  ? ", false, pile2.estPleine());
	}

	public void test_estPleineV2() {
		try {
			pile2.empiler("jad");
			pile2.empiler("mina");
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(" estPleine2  ", true, pile2.estPleine());
	}

	public void test_equals() {
		assertEquals(" equals  ? ", true, pile2.equals(pileCompare));

	}

	public void test_equalsV2() {
		try {
			pile2.depiler();
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(" equals  ? ", false, pile2.equals(pileCompare));
	}

	public void test_taille() {
		assertEquals(" taille  ? ", 4, pile2.taille());
	}

	public void test_capacite() {
		assertEquals(" capacite  ? ", 6, pile2.capacite());
	}

	/**
	 * Il ne vous reste plus qu'à définir une ou plusieurs méthodes de test. Ces
	 * méthodes doivent vérifier les résultats attendus à l'aide d'assertions
	 * assertTrue(<boolean>). Par convention, leurs noms devraient débuter par
	 * "test". Vous pouvez ébaucher le corps grâce au menu contextuel
	 * "Enregistrer une méthode de test".
	 */

}
