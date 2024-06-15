package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GUInterface extends JFrame {

    private JButton butonAdunare = new JButton();
    private JButton butonScadere = new JButton();
    private JButton butonInmultire = new JButton();
    private JButton butonDerivare = new JButton();
    private JButton butonIntegrare = new JButton();
    private JButton butonImpartire = new JButton();
    private JTextField polinom1 = new JTextField();
    private JTextField polinom2 = new JTextField();
    private JTextField output = new JTextField();
    private final Color colorBackround = Color.decode("#E7E8D1");
    private final Color colorFont = Color.decode("#B85042");
    private final Color colorButtons = Color.decode("#A7BEAE");
    private final Font font = new Font("Arial", Font.BOLD, 20);
    private final Font fontTitlu = new Font("Arial", Font.BOLD, 35);

    public GUInterface() {
        butonAdunare.setBounds(420, 50, 150, 50);
        butonAdunare.setText("Adunare");
        butonAdunare.setFocusable(false);
        butonAdunare.setFont(font);
        butonAdunare.setBackground(colorButtons);
        butonAdunare.setForeground(colorFont);

        butonScadere.setBounds(420, 150, 150, 50);
        butonScadere.setText("Scadere");
        butonScadere.setFocusable(false);
        butonScadere.setFont(font);
        butonScadere.setBackground(colorButtons);
        butonScadere.setForeground(colorFont);

        butonInmultire.setBounds(420, 250, 150, 50);
        butonInmultire.setText("Inmultire");
        butonInmultire.setFocusable(false);
        butonInmultire.setFont(font);
        butonInmultire.setBackground(colorButtons);
        butonInmultire.setForeground(colorFont);

        butonDerivare.setBounds(420, 350, 150, 50);
        butonDerivare.setText("Derivare");
        butonDerivare.setFocusable(false);
        butonDerivare.setFont(font);
        butonDerivare.setBackground(colorButtons);
        butonDerivare.setForeground(colorFont);

        butonIntegrare.setBounds(220, 350, 150, 50);
        butonIntegrare.setText("Integrare");
        butonIntegrare.setFocusable(false);
        butonIntegrare.setFont(font);
        butonIntegrare.setBackground(colorButtons);
        butonIntegrare.setForeground(colorFont);

        butonImpartire.setBounds(20, 350, 150, 50);
        butonImpartire.setText("Impartire");
        butonImpartire.setFocusable(false);
        butonImpartire.setFont(font);
        butonImpartire.setBackground(colorButtons);
        butonImpartire.setForeground(colorFont);

        JLabel labelPolinom1 = new JLabel("Introduceti primul polinom:");
        labelPolinom1.setFont(font);
        labelPolinom1.setForeground(colorFont);

        JLabel labelPolinom2 = new JLabel("Introduceti al doilea polinom:");
        labelPolinom2.setFont(font);
        labelPolinom2.setForeground(colorFont);

        JLabel labelOutput = new JLabel("Rezultat:");
        labelOutput.setFont(font);
        labelOutput.setForeground(colorFont);

        JLabel labelTitlu = new JLabel("CALCULATOR");
        labelTitlu.setFont(fontTitlu);
        labelTitlu.setForeground(colorFont);


        JLabel labelTitlu2 = new JLabel("POLINOMIAL");
        labelTitlu2.setFont(fontTitlu);
        labelTitlu2.setForeground(colorFont);

        polinom1.setBounds(50, 150, 300, 50);
        polinom1.setFont(font);
        polinom1.setForeground(colorFont);
        polinom1.setBackground(colorButtons);

        polinom2.setBounds(50, 250, 300, 50);
        polinom2.setFont(font);
        polinom2.setForeground(colorFont);
        polinom2.setBackground(colorButtons);

        output.setBounds(50, 475, 500, 50);
        output.setFont(font);
        output.setForeground(colorFont);
        output.setBackground(colorButtons);

        labelPolinom1.setBounds(50, 125, 300, 20);
        labelPolinom2.setBounds(50, 225, 300, 20);
        labelOutput.setBounds(50, 450, 300, 20);
        labelTitlu.setBounds(80,15,400,50);
        labelTitlu2.setBounds(95,50,300,50);

        setTitle("Calculator Polinomial");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(colorBackround);
        setLayout(null);
        add(butonAdunare);
        add(butonScadere);
        add(butonInmultire);
        add(butonDerivare);
        add(butonIntegrare);
        add(butonImpartire);
        add(polinom1);
        add(polinom2);
        add(output);
        add(labelPolinom1);
        add(labelPolinom2);
        add(labelOutput);
        add(labelTitlu);
        add(labelTitlu2);
        setSize(600, 600);
        setVisible(true);
    }

    public JButton getButonAdunare() {
        return butonAdunare;
    }

    public JButton getButonScadere() {
        return butonScadere;
    }
    public JButton getButonInmultire(){
        return  butonInmultire;
    }
    public JButton getButonDerivare(){
        return butonDerivare;
    }
    public JButton getButonIntegrare(){
        return butonIntegrare;
    }
    public JButton getButonImpartire(){
        return butonImpartire;
    }
    public JTextField getOutput() {
        return output;
    }

    public JTextField getPolinom1() {
        return polinom1;
    }

    public JTextField getPolinom2() {
        return polinom2;
    }

    public void adunare(ActionListener listener) {
        butonAdunare.addActionListener(listener);
    }

    public void scadere(ActionListener listener) {
        butonScadere.addActionListener(listener);
    }
    public void inmultire(ActionListener listener){
        butonInmultire.addActionListener(listener);
    }
    public void derivare(ActionListener listener){
        butonDerivare.addActionListener(listener);
    }
    public void integrare(ActionListener listener){
        butonIntegrare.addActionListener(listener);
    }
    public void impartire(ActionListener listener){
        butonImpartire.addActionListener(listener);
    }
}
