package sn.devOpsRoad;

import org.junit.Assert;
import org.junit.Test;

/**
 * Hello world!
 *
 */
public class OperationTest
{

    Operation operation = new Operation();

    @Test
    public void testAddition()
    {
        int valeur1, valeur2, resultat, expectedResult;

        //Given
        valeur1 = 10;
        valeur2 = 25;
        expectedResult = 35;

        //When
        resultat = operation.addition(valeur1, valeur2);

        //Then
        Assert.assertEquals(resultat, expectedResult);
    }

    @Test
    public void testSoustraction()
    {
        int valeur1, valeur2, resultat, expectedResult;

        //Given
        valeur1 = 10;
        valeur2 = 5;
        expectedResult = 5;

        //When
        resultat = operation.soustraction(valeur1, valeur2);

        //Then
        Assert.assertEquals(resultat, expectedResult);
    }

    @Test
    public void testMultiplication()
    {
        int valeur1, valeur2, resultat, expectedResult;

        //Given
        valeur1 = 10;
        valeur2 = 5;
        expectedResult = 50;

        //When
        resultat = operation.multiplication(valeur1, valeur2);

        //Then
        Assert.assertEquals(resultat, expectedResult);
    }
}
