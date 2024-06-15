package Model;

import java.util.*;

public class Ecuatii {
    public Polinom adunare(Polinom polinom1, Polinom polinom2) {
        TreeMap<Integer, Double> monoms1 = polinom1.getMonomsTree();
        TreeMap<Integer, Double> monoms2 = polinom2.getMonomsTree();
        TreeMap<Integer, Double> resultMonoms = new TreeMap<>();
        // Adăugăm monoamele din polinomul 1 în rezultat
        for (Map.Entry<Integer, Double> entry : monoms1.entrySet()) {
            int power = entry.getKey();
            double coefficient = entry.getValue();
            resultMonoms.put(power, resultMonoms.getOrDefault(power, 0.0) + coefficient);
        }
        // Adăugăm monoamele din polinomul 2 în rezultat
        for (Map.Entry<Integer, Double> entry : monoms2.entrySet()) {
            int power = entry.getKey();
            double coefficient = entry.getValue();
            resultMonoms.put(power, resultMonoms.getOrDefault(power, 0.0) + coefficient);
        }
        // Eliminăm monoamele cu coeficientul zero (dacă există)
        resultMonoms.entrySet().removeIf(entry -> entry.getValue() == 0.0);
        return new Polinom(resultMonoms);
    }

    public Polinom scadere(Polinom polinom1, Polinom polinom2) {
        TreeMap<Integer, Double> monoms1 = polinom1.getMonomsTree();
        TreeMap<Integer, Double> monoms2 = polinom2.getMonomsTree();
        TreeMap<Integer, Double> resultMonoms = new TreeMap<>();

        // Adăugăm monoamele din polinomul 1 în rezultat
        for (Map.Entry<Integer, Double> entry : monoms1.entrySet()) {
            int power = entry.getKey();
            double coefficient = entry.getValue();
            resultMonoms.put(power, resultMonoms.getOrDefault(power, 0.0) + coefficient);
        }

        // Adăugăm monoamele din polinomul 2 în rezultat
        for (Map.Entry<Integer, Double> entry : monoms2.entrySet()) {
            int power = entry.getKey();
            double coefficient = entry.getValue();
            resultMonoms.put(power, resultMonoms.getOrDefault(power, 0.0) - coefficient);
        }

        // Eliminăm monoamele cu coeficientul zero (dacă există)
        resultMonoms.entrySet().removeIf(entry -> entry.getValue() == 0.0);

        return new Polinom(resultMonoms);
    }

    public Polinom inmultire(Polinom polinom1, Polinom polinom2) {
        TreeMap<Integer, Double> monoms1 = polinom1.getMonomsTree();
        TreeMap<Integer, Double> monoms2 = polinom2.getMonomsTree();
        TreeMap<Integer, Double> resultMonoms = new TreeMap<>();
        // Iteram peste fiecare monom din primul polinom
        for (Map.Entry<Integer, Double> entry1 : monoms1.entrySet()) {
            int power1 = entry1.getKey();
            double coefficient1 = entry1.getValue();
            // Iteram peste al doilea polinom
            for (Map.Entry<Integer, Double> entry2 : monoms2.entrySet()) {
                int power2 = entry2.getKey();
                double coefficient2 = entry2.getValue();
                // Inmultim coeficientii si adunam puterile
                int newPower = power1 + power2;
                double newCoefficient = coefficient1 * coefficient2;
                // Adaugam in rezultat
                resultMonoms.put(newPower, resultMonoms.getOrDefault(newPower, 0.0) + newCoefficient);
            }
        }
        // eliminam toate monoamle cu coeficientul 0
        resultMonoms.entrySet().removeIf(entry -> entry.getValue() == 0.0);
        return new Polinom(resultMonoms);
    }

    public Polinom derivare(Polinom polinom) {
        TreeMap<Integer, Double> resultMonoms = new TreeMap<>(Comparator.reverseOrder());
        TreeMap<Integer, Double> monoms = polinom.getMonomsTree();
        for (Map.Entry<Integer, Double> entry : monoms.entrySet()) {
            Integer currentPower = entry.getKey();
            Double coefficient = entry.getValue();
            // Calculează derivata monomului curent
            if (currentPower > 0) {
                double derivativeCoefficient = coefficient * currentPower;
                int derivativePower = currentPower - 1;
                // Adaugă monomul derivat în rezultat
                resultMonoms.put(derivativePower, derivativeCoefficient);
            }
        }
        // Elimină monoamele cu coeficientul zero (dacă există)
        resultMonoms.entrySet().removeIf(entry -> entry.getValue() == 0.0);
        // Construiește un nou obiect Polinom pe baza rezultatului derivării
        return new Polinom(resultMonoms);
    }

    public Polinom integrare(Polinom polinom) {
        TreeMap<Integer, Double> resultMonoms = new TreeMap<>(Comparator.reverseOrder());
        TreeMap<Integer, Double> monoms = polinom.getMonomsTree();
        for (Map.Entry<Integer, Double> entry : monoms.entrySet()) {
            Integer currentPower = entry.getKey();
            Double coefficient = entry.getValue();
            // Calculează integrala monomului curent
                double derivativeCoefficient = coefficient / (currentPower+1);
                int derivativePower = currentPower + 1;
                // Adaugă monomul derivat în rezultat
                resultMonoms.put(derivativePower, derivativeCoefficient);
        }
        // Elimină monoamele cu coeficientul zero (dacă există)
        resultMonoms.entrySet().removeIf(entry -> entry.getValue() == 0.0);
        // Construiește un nou obiect Polinom pe baza rezultatului derivării
        return new Polinom(resultMonoms);
    }

    public List<Polinom> impartire(Polinom dividend, Polinom divisor) {
        TreeMap<Integer, Double> P = new TreeMap<>(dividend.getMonomsTree());
        TreeMap<Integer, Double> Q = new TreeMap<>(divisor.getMonomsTree());
        TreeMap<Integer, Double> quotientMap = new TreeMap<>(Comparator.reverseOrder());
        if (Q.isEmpty() || Q.firstKey() == null || Q.firstKey() == 0) {
            throw new ArithmeticException("Division by zero or invalid divisor");
        }
        while (!P.isEmpty() && !Q.isEmpty() && P.firstKey() != null && P.firstKey() >= Q.firstKey()) {
            Integer PLeadingPower = P.firstKey();
            Double PLeadingCoefficient = P.get(PLeadingPower);
            Integer QLeadingPower = Q.firstKey();
            Double QLeadingCoefficient = Q.get(QLeadingPower);
            Double quotientCoefficient = PLeadingCoefficient / QLeadingCoefficient;
            Integer quotientPower = PLeadingPower - QLeadingPower;
            quotientMap.put(quotientPower, quotientCoefficient);
            // Create a copy of Q as a Polinom to use in the multiplication
            Polinom QPolinom = new Polinom(new TreeMap<>(Q));
            // Create a Polinom for the quotient term to use in multiplication
            TreeMap<Integer, Double> QTimesQuotientMap = new TreeMap<>(Comparator.reverseOrder());
            QTimesQuotientMap.put(quotientPower, quotientCoefficient);
            Polinom QTimesQuotient = new Polinom(QTimesQuotientMap);
            // Perform the subtraction P - (Q * QTimesQuotient)
            P = scadere(new Polinom(P), inmultire(QTimesQuotient, QPolinom)).getMonomsTree();
            // Remove monomials with coefficient 0 from P
            P.entrySet().removeIf(entry -> entry.getValue() == 0.0);
        }
        // Create the quotient polynomial from the quotientMap
        Polinom quotientPolynomial = new Polinom(quotientMap);
        // Create the remainder polynomial from the remaining terms in P
        Polinom remainderPolynomial = new Polinom(P);
        // Store both the quotient and remainder polynomials in a list
        List<Polinom> result = new ArrayList<>();
        result.add(quotientPolynomial);
        result.add(remainderPolynomial);
        return result;
    }


}
