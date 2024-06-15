package Controller;

import Model.Ecuatii;
//import Model.Monom;
import Model.Polinom;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import Model.Monom;
import Model.Polinom;
import Model.Ecuatii;
import View.GUInterface;

import javax.swing.*;

public class Control {

    private GUInterface interfata;
    private Ecuatii ecuatii;

    public Control(GUInterface interfata, Ecuatii ecuatii) {
        this.interfata = interfata;
        this.ecuatii = ecuatii;

        interfata.adunare(new ClasaButonAdunare());
        interfata.scadere(new ClasaButonScadere());
        interfata.inmultire(new ClasaButonInmultire());
        interfata.derivare(new ClasaButonDerivare());
        interfata.integrare(new ClasaButonIntegrare());
        interfata.impartire(new ClasaButonImpartirea());


    }

    public class ClasaButonAdunare implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == interfata.getButonAdunare()) {
                String input1 = interfata.getPolinom1().getText();
                String input2 = interfata.getPolinom2().getText();

                TreeMap<Integer, Double> monomsTree1 = parsePolinom(input1);
                TreeMap<Integer, Double> monomsTree2 = parsePolinom(input2);

                if (!monomsTree1.isEmpty() && !monomsTree2.isEmpty()) {
                    Polinom polinomObj1 = new Polinom(monomsTree1);
                    Polinom polinomObj2 = new Polinom(monomsTree2);

                    Polinom result = ecuatii.adunare(polinomObj1, polinomObj2);

                    if (result != null) {
                        interfata.getOutput().setText(result.toString());
                    } else {
                        interfata.getOutput().setText("Invalid operation.");
                    }
                } else {
                    interfata.getOutput().setText("Invalid input format.");
                }
            }
        }
    }
    public class ClasaButonScadere implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == interfata.getButonScadere()) {
                String input1 = interfata.getPolinom1().getText();
                String input2 = interfata.getPolinom2().getText();

                TreeMap<Integer, Double> monomsTree1 = parsePolinom(input1);
                TreeMap<Integer, Double> monomsTree2 = parsePolinom(input2);

                if (!monomsTree1.isEmpty() && !monomsTree2.isEmpty()) {
                    Polinom polinomObj1 = new Polinom(monomsTree1);
                    Polinom polinomObj2 = new Polinom(monomsTree2);

                    Polinom result = ecuatii.scadere(polinomObj1, polinomObj2);

                    if (result != null) {
                        interfata.getOutput().setText(result.toString());
                    } else {
                        interfata.getOutput().setText("Invalid operation.");
                    }
                } else {
                    interfata.getOutput().setText("Invalid input format.");
                }
            }
        }
    }
    public class ClasaButonInmultire implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == interfata.getButonInmultire()) {
                String input1 = interfata.getPolinom1().getText();
                String input2 = interfata.getPolinom2().getText();

                TreeMap<Integer, Double> monomsTree1 = parsePolinom(input1);
                TreeMap<Integer, Double> monomsTree2 = parsePolinom(input2);

                if (!monomsTree1.isEmpty() && !monomsTree2.isEmpty()) {
                    Polinom polinomObj1 = new Polinom(monomsTree1);
                    Polinom polinomObj2 = new Polinom(monomsTree2);

                    Polinom result = ecuatii.inmultire(polinomObj1, polinomObj2);

                    if (result != null) {
                        interfata.getOutput().setText(result.toString());
                    } else {
                        interfata.getOutput().setText("Invalid operation.");
                    }
                } else {
                    interfata.getOutput().setText("Invalid input format.");
                }
            }
        }
    }
    public class ClasaButonDerivare implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == interfata.getButonDerivare()) {
                String input1 = interfata.getPolinom1().getText();
                String input2 = interfata.getPolinom2().getText();

                TreeMap<Integer, Double> monomsTree1 = parsePolinom(input1);
                TreeMap<Integer, Double> monomsTree2 = parsePolinom(input2);

                if (!monomsTree1.isEmpty() && !monomsTree2.isEmpty()) {
                    Polinom polinomObj1 = new Polinom(monomsTree1);

                    Polinom result = ecuatii.derivare(polinomObj1);

                    if (result != null) {
                        interfata.getOutput().setText(result.toString());
                    } else {
                        interfata.getOutput().setText("Invalid operation.");
                    }
                } else {
                    interfata.getOutput().setText("Invalid input format.");
                }
            }
        }
    }
    public class ClasaButonIntegrare implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == interfata.getButonIntegrare()) {
                String input1 = interfata.getPolinom1().getText();
                String input2 = interfata.getPolinom2().getText();

                TreeMap<Integer, Double> monomsTree1 = parsePolinom(input1);
                TreeMap<Integer, Double> monomsTree2 = parsePolinom(input2);

                if (!monomsTree1.isEmpty() && !monomsTree2.isEmpty()) {
                    Polinom polinomObj1 = new Polinom(monomsTree1);

                    Polinom result = ecuatii.integrare(polinomObj1);

                    if (result != null) {
                        interfata.getOutput().setText(result.toString());
                    } else {
                        interfata.getOutput().setText("Invalid operation.");
                    }
                } else {
                    interfata.getOutput().setText("Invalid input format.");
                }
            }
        }
    }
    public class ClasaButonImpartirea implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == interfata.getButonImpartire()) {
                String input1 = interfata.getPolinom1().getText();
                String input2 = interfata.getPolinom2().getText();

                // Parsează șirurile de intrare în TreeMap-uri pentru polinoame
                TreeMap<Integer, Double> monoms1 = parsePolinom(input1);
                TreeMap<Integer, Double> monoms2 = parsePolinom(input2);

                if (monoms1 != null && monoms2 != null) {
                    try {
                        // Realizează operația de împărțire folosind metoda impartire actualizată
                        java.util.List<Polinom> result = ecuatii.impartire(new Polinom(monoms1), new Polinom(monoms2));

                        // Afiseaza catul si restul rezultatelor
                        if (result.size() >= 2) {
                            interfata.getOutput().setText("Catul este " + result.get(0).toString() +
                                    " Restul este " + result.get(1).toString());
                        } else {
                            interfata.getOutput().setText("Nu s-au obtinut rezultate valide.");
                        }
                    } catch (ArithmeticException ex) {
                        interfata.getOutput().setText("Eroare la impartire: " + ex.getMessage());
                    }
                } else {
                    interfata.getOutput().setText("Format de intrare invalid.");
                }
            }
        }
    }
   public static TreeMap<Integer, Double> parsePolinom(String input) {
       TreeMap<Integer, Double> monomTree = new TreeMap<>();
       Pattern pattern = Pattern.compile("([-+]?(\\d*\\.?\\d*)(?:x(?:\\^(\\d+))?)?)");
       Matcher matcher = pattern.matcher(input);
       while (matcher.find()) {
           String term = matcher.group();
           double coefficient = 0.0;
           int power = 0;
           if (!term.isEmpty()) {
               if (term.contains("x")) {
                   int xIndex = term.indexOf('x');
                   String coefficientStr = term.substring(0, xIndex);
                   if (coefficientStr.isEmpty() || coefficientStr.equals("+")) {
                       coefficient = 1.0;
                   } else if (coefficientStr.equals("-")) {coefficient = -1.0;}
                   else {coefficient = Double.parseDouble(coefficientStr);}
                   if (xIndex < term.length() - 1) {
                       String powerStr = term.substring(xIndex + 2); // Skip 'x^'
                       power = powerStr.isEmpty() ? 1 : Integer.parseInt(powerStr);
                   } else {
                       power = 1;
                   }
               } else {
                   coefficient = Double.parseDouble(term);
               }
               if (monomTree.containsKey(power)) {
                   double existingCoefficient = monomTree.get(power);
                   monomTree.put(power, existingCoefficient + coefficient);
               } else {
                   monomTree.put(power, coefficient);
               }
           }
       }
       return monomTree;
   }

}