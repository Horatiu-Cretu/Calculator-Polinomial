package Model;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class OperationsTest {


    @Test
    public void testAdunare() {
        // Creeaza primul polinom (2x^2 + 3x + 1)
        TreeMap<Integer, Double> monoms1 = new TreeMap<>();
        monoms1.put(2, 2.0);  // coefficient of x^2
        monoms1.put(1, 3.0);  // coefficient of x
        monoms1.put(0, 1.0);  // constant term
        // Creeaza al doilea polinom (4x^3 + 2x^2 - 1)
        TreeMap<Integer, Double> monoms2 = new TreeMap<>();
        monoms2.put(3, 4.0);  // coefficient of x^3
        monoms2.put(2, 2.0);  // coefficient of x^2
        monoms2.put(0, -1.0); // constant term
        // creeaza polinoamele si asociazale pentru doua polinoame
        Polinom p1 = new Polinom(monoms1);
        Polinom p2 = new Polinom(monoms2);
        // instantiam clasa ecuatii
        Ecuatii ecuatii = new Ecuatii();
        // facem adunarea
        Polinom result = ecuatii.adunare(p1, p2);
        // Creeaza polinomul pentru rezultat (4x^3 + 4x^2 + 3x + 0)
        TreeMap<Integer, Double> expectedResultMonoms = new TreeMap<>(Collections.reverseOrder());
        expectedResultMonoms.put(3, 4.0); // coefficient of x^3
        expectedResultMonoms.put(2, 4.0); // coefficient of x^2
        expectedResultMonoms.put(1, 3.0); // coefficient of x
        // pune TreeMap ul in polinomul rezultat
        Polinom expectedResult = new Polinom(expectedResultMonoms);
        // Comparam rezultatul testarii cu rezultatul asteptat
        assertTreeMapsEqual(expectedResultMonoms, result.getMonomsTree());
    }

    @Test
    public void testScadere() {
        // Create the first polynomial (x^3-2x^2+6x-5)
        TreeMap<Integer, Double> monoms1 = new TreeMap<>();
        monoms1.put(3, 1.0);
        monoms1.put(2, -2.0);
        monoms1.put(1, 6.0);
        monoms1.put(0, -5.0);

        // Create the second polynomial (x^2-1)
        TreeMap<Integer, Double> monoms2 = new TreeMap<>();
        monoms2.put(2, 1.0);
        monoms2.put(1, 0.0);
        monoms2.put(0, -1.0);

        // Create Polinom instances from the TreeMap representations
        Polinom p1 = new Polinom(monoms1);
        Polinom p2 = new Polinom(monoms2);

        // Create an instance of Ecuatii class
        Ecuatii ecuatii = new Ecuatii();

        // Perform the subtraction operation
        Polinom result = ecuatii.scadere(p1, p2);

        // Define the expected result polynomial (x^3 -3x^2 + 6x -4)
        TreeMap<Integer, Double> expectedResultMonoms = new TreeMap<>(Collections.reverseOrder());
        expectedResultMonoms.put(3, 1.0);
        expectedResultMonoms.put(2, -3.0);
        expectedResultMonoms.put(1, 6.0);
        expectedResultMonoms.put(0, -4.0);

        // Create the expected result Polinom instance
        Polinom expectedResult = new Polinom(expectedResultMonoms);

        // Assert that the result of subtraction matches the expected result
        assertTreeMapsEqual(expectedResultMonoms, result.getMonomsTree());
    }

    @Test
    public void TestInmultire (){
        // Create the first polynomial (x^3-2x^2+6x-5)
        TreeMap<Integer, Double> monoms1 = new TreeMap<>();
        monoms1.put(3, 1.0);
        monoms1.put(2, -2.0);
        monoms1.put(1, 6.0);
        monoms1.put(0, -5.0);

        // Create the second polynomial (x^2-1)
        TreeMap<Integer, Double> monoms2 = new TreeMap<>();
        monoms2.put(2, 1.0);
        monoms2.put(1, 0.0);
        monoms2.put(0, -1.0);

        // Create Polinom instances from the TreeMap representations
        Polinom p1 = new Polinom(monoms1);
        Polinom p2 = new Polinom(monoms2);

        // Create an instance of Ecuatii class
        Ecuatii ecuatii = new Ecuatii();

        // Perform the subtraction operation
        Polinom result = ecuatii.inmultire(p1, p2);

        // Define the expected result polynomial (x^5 - 2x^4 + 5x^3 - 3x^2 - 6x + 5)
        TreeMap<Integer, Double> expectedResultMonoms = new TreeMap<>(Collections.reverseOrder());
        expectedResultMonoms.put(5, 1.0);
        expectedResultMonoms.put(4, -2.0);
        expectedResultMonoms.put(3, 5.0);
        expectedResultMonoms.put(2, -3.0);
        expectedResultMonoms.put(1, -6.0);
        expectedResultMonoms.put(0, 5.0);

        // Create the expected result Polinom instance
        Polinom expectedResult = new Polinom(expectedResultMonoms);

        // Assert that the result of subtraction matches the expected result
        assertTreeMapsEqual(expectedResultMonoms, result.getMonomsTree());
    }

    @Test
    public void TestDerivare(){
        // Create the first polynomial (x^3-2x^2+6x-5)
        TreeMap<Integer, Double> monoms1 = new TreeMap<>();
        monoms1.put(3, 1.0);
        monoms1.put(2, -2.0);
        monoms1.put(1, 6.0);
        monoms1.put(0, -5.0);

        // Create Polinom instances from the TreeMap representations
        Polinom p1 = new Polinom(monoms1);

        // Create an instance of Ecuatii class
        Ecuatii ecuatii = new Ecuatii();

        // Perform the subtraction operation
        Polinom result = ecuatii.derivare(p1);

        // Define the expected result polynomial (3x^2-4x+6)
        TreeMap<Integer, Double> expectedResultMonoms = new TreeMap<>(Collections.reverseOrder());
        expectedResultMonoms.put(2, 3.0);
        expectedResultMonoms.put(1, -4.0);
        expectedResultMonoms.put(0, 6.0);


        // Create the expected result Polinom instance
        Polinom expectedResult = new Polinom(expectedResultMonoms);

        // Assert that the result of subtraction matches the expected result
        assertTreeMapsEqual(expectedResultMonoms, result.getMonomsTree());
    }

    @Test
    public void TestIntegrare(){
        // Create the first polynomial (x^3-2x^2+6x-5)
        TreeMap<Integer, Double> monoms1 = new TreeMap<>();
        monoms1.put(3, 1.0);
        monoms1.put(2, -2.0);
        monoms1.put(1, 6.0);
        monoms1.put(0, -5.0);

        // Create Polinom instances from the TreeMap representations
        Polinom p1 = new Polinom(monoms1);

        // Create an instance of Ecuatii class
        Ecuatii ecuatii = new Ecuatii();

        // Perform the subtraction operation
        Polinom result = ecuatii.integrare(p1);

        // Define the expected result polynomial (0.25x^4-0.6666666666666666x^3 + 3x^2-5x)
        TreeMap<Integer, Double> expectedResultMonoms = new TreeMap<>(Collections.reverseOrder());
        expectedResultMonoms.put(4, 0.25);
        expectedResultMonoms.put(3, -0.6666666666666666);
        expectedResultMonoms.put(2, 3.0);
        expectedResultMonoms.put(1, -5.0);



        // Create the expected result Polinom instance
        Polinom expectedResult = new Polinom(expectedResultMonoms);

        // Assert that the result of subtraction matches the expected result
        assertTreeMapsEqual(expectedResultMonoms, result.getMonomsTree());
    }

    @Test
    public void testImpartire() {
        // Polinomul dividend:
        TreeMap<Integer, Double> monomsDividend = new TreeMap<>();
        monomsDividend.put(3, 1.0);  // coefficient of x^3
        monomsDividend.put(2, -2.0);  // coefficient of x^2
        monomsDividend.put(1, 6.0); // coefficient of x
        monomsDividend.put(0, -5.0);  // constant term
        Polinom dividend = new Polinom(monomsDividend);

        // Polinomul divisor:
        TreeMap<Integer, Double> monomsDivisor = new TreeMap<>();
        monomsDivisor.put(2, -1.0);   // coefficient of x
        monomsDivisor.put(1, -1.0);  // constant term
        Polinom divisor = new Polinom(monomsDivisor);

        // Creare instanță de Ecuatii
        Ecuatii ecuatii = new Ecuatii();

        // Apelăm metoda impartire pentru a obține rezultatul împărțirii
        List<Polinom> result = ecuatii.impartire(dividend, divisor);

        // Se așteaptă ca rezultatul să conțină două polinoame: câtul și restul
        assertEquals(2, result.size());

        // Verificăm polinomul cât
        Polinom cat = result.get(0);
        TreeMap<Integer, Double> expectedQuotientMap = new TreeMap<>();
        expectedQuotientMap.put(1, -1.0);
        expectedQuotientMap.put(0, 3.0);
        Polinom expectedQuotient = new Polinom(expectedQuotientMap);
        assertTreeMapsEqual(expectedQuotientMap,result.get(0).getMonomsTree());

        // Verificăm polinomul rest
        Polinom rest = result.get(1);
        TreeMap<Integer, Double> expectedRemainderMap = new TreeMap<>();
        expectedRemainderMap.put(1, 9.0);
        expectedRemainderMap.put(0, -5.0);
        Polinom expectedRemainder = new Polinom(expectedRemainderMap);
        assertTreeMapsEqual(expectedRemainderMap,result.get(1).getMonomsTree());
    }
    private void assertTreeMapsEqual(TreeMap<Integer, Double> expected, TreeMap<Integer, Double> actual) {
        assertEquals("Size mismatch", expected.size(), actual.size());

        for (Integer key : expected.keySet()) {
            assertTrue("Key mismatch", actual.containsKey(key));
            assertEquals("Value mismatch for key " + key, expected.get(key), actual.get(key), 0.0001); // Use a small delta for double comparison
        }
    }
}

