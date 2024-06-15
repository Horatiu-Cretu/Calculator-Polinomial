package Model;
import java.util.*;

public class Polinom {
    private TreeMap<Integer, Double> monomsTree;

    public Polinom(TreeMap<Integer, Double> monomsTree) {
        this.monomsTree = new TreeMap<>(Collections.reverseOrder());
        this.monomsTree.putAll(monomsTree);
    }

    public TreeMap<Integer, Double> getMonomsTree() {
        return monomsTree;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Integer, Double> entry : monomsTree.entrySet()) {
            int power = entry.getKey();
            double coefficient = entry.getValue();
            if (power == 0 && coefficient != 0) {
                if (coefficient > 0) {result.append("+");}
                if (isInteger(coefficient)) {
                    long intCoefficient = (long) coefficient;
                    result.append(intCoefficient);
                } else {
                    result.append(coefficient);
                }
            } else if (coefficient != 0) {
                if (result.length() > 0 && coefficient > 0) {result.append(" + ");}
                if (coefficient != 1 && coefficient != -1) {
                    if (isInteger(coefficient)) {
                        long intCoefficient = (long) coefficient;
                        result.append(intCoefficient);
                    } else {
                        result.append(coefficient);
                    }
                } else if (coefficient == -1) {
                    result.append("-");
                }
                result.append("x");
                if (power != 1) {
                    result.append("^").append(power);
                }
            }
        }
        return result.toString();
    }

    // Funcție auxiliară pentru a verifica dacă un număr double este echivalent cu un întreg
    private boolean isInteger(double number) {
        return number == (long) number;
    }






}
