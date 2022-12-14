package org.example;


import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;


import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
public class AppTest {

    private Calculator calculatorUnderTest;
    private static Instant startedAt;


    @BeforeAll
    public static void initStartingTime() {
        System.out.println("Appel avant tous les tests");
        startedAt = Instant.now();
    }


    @AfterAll
    public static void showTestDuration() {
        System.out.println("Appel après tous les tests");
        Instant endedAt = Instant.now();
        long duration = Duration.between(startedAt, endedAt).toMillis();
        System.out.println(MessageFormat.format("Durée des tests : {0} ms", duration));
    }
    @BeforeEach
    public void initCalculator() {
        calculatorUnderTest = new Calculator();
        System.out.println("Appel avant chaque test");
    }
    @AfterEach
    public void undefCalculator() {
        calculatorUnderTest = null;
        System.out.println("Appel après chaque test");
    }




    @Test
    public void testAddTwoPositiveNumbers() {
        // Arrange
        int a = 2;
        int b = 3;

        // Act
        int somme = calculatorUnderTest.Add(a, b);

        // Assert
        assertEquals(5, somme);

    }

    @Test
    public void multiply_shouldReturnTheProduct_ofTwoIntegers() {
        // Arrange
        int a = 42 ;
        int b = 11 ;

        // Act
        int produit = calculatorUnderTest.multiply(a, b);

        // Assert
        assertEquals(462, produit);
    }
@ParameterizedTest(name="{0} x 0 doit être égal à 0")
@ValueSource(ints = {1, 2, 42, 1001 })
public void multiply_shouldReturnZero_ofZeroWithMultipleIntegers(int arg) {
        // ARRANGE - Tout est prêt
        // ACT
    int actualResult = calculatorUnderTest.multiply(arg, 0 );
        // ASSERT
    assertEquals(0, actualResult);

    }
@ParameterizedTest (name = "{0} + {1} doit être égal à {2}")
@CsvSource({"1,1,2", "2,3,5", "42,57,99"})
    public void add_shouldReturnZeroofZeroWithMultipleIntegers(int arg1, int arg2, int expectResult) {
        // ARRANGE - Tout est prêt
        // ACT
       final  int actualResult = calculatorUnderTest.Add(arg1, arg2 );
        // ASSERT
        assertEquals(expectResult, actualResult);

    }

@Test
    @Timeout(1)
    public void longCalcul_shouldComputeInLessThan1Second () {
        // ARRANGE

    // ACT
    calculatorUnderTest.longCalculation();
    // ASSERT
}




}
