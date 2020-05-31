package question1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import question2.Pile4;

public class IHMPile extends JFrame implements ActionListener {
    private JTextField donnee = new JTextField(6);
    private JTextField sommet = new JTextField(6);
    private JLabel contenu = new JLabel("[]");

    private Pile4 p;

    public IHMPile() {
        super("IHM Pile");
        JButton boutonEmpiler = new JButton("empiler");
        JButton boutonDepiler = new JButton("depiler");

        JPanel enHaut = new JPanel();
        enHaut.add(donnee);
        enHaut.add(boutonEmpiler);
        enHaut.add(boutonDepiler);
        enHaut.add(sommet);
        setLayout(new BorderLayout(5, 5));
        add("North", enHaut);
        add("Center", contenu);
        enHaut.setBackground(Color.red);
        setLocation(100, 100);
        pack();
        setVisible(true);
        boutonEmpiler.addActionListener(this);
        boutonDepiler.addActionListener(this);

        p = new Pile4(5);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("empiler")) {
            try {
                p.empiler(donnee.getText());
                Vector<Object> objectToCompare = new Vector<Object>();
                for (int i = 1; i < 6; i--) {
                    objectToCompare.add("" + i);
                }
                System.out.println("sommet " + p.sommet());
                System.out.println("capacite " + p.capacite());
                System.out.println("taille " + p.taille());
                // System.out.println("equals " + p.equals(objectToCompare));
                // System.out.println("objectToCompare " + objectToCompare);
                System.out.println("*************");

                donnee.setText(""); // empty donnee
                contenu.setText(p.toString()); // set the new value
            } catch (Exception e) {
                contenu.setText(" estPleine !"); // set " estPleine !" in case if pile is full
                e.printStackTrace();
            }

        } else {
            try {
                p.depiler();
                System.out.println("sommet " + p.sommet());
                System.out.println("capacite " + p.capacite());
                System.out.println("taille " + p.taille());
                System.out.println("*************");
                contenu.setText(p.toString()); // set the new value.
            } catch (Exception e) {
                contenu.setText(" estVide !"); // set " estVide !" in case if pile is empty
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new IHMPile();
    }
}