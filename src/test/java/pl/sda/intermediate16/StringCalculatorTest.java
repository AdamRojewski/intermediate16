package pl.sda.intermediate16;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
    @Test
    void ShouldReturnZeroWhenStringIsEmpty() {
        // StringCalculator stringCalculator = new StringCalculator(); - zamiennie z ponizszym
        Integer result = StringCalculator.adding("");
        Assertions.assertTrue(result.equals(0));
    }

    @Test
    void ShouldReturnNumberWhenTextReturnsNumber() {
        // StringCalculator stringCalculator = new StringCalculator(); - zamiennie z ponizszym
        Integer result = StringCalculator.adding("3");
        Assertions.assertTrue(result.equals(3));
    }

    @Test
    void ShouldReturnSomeWhenTextContainsNumbersSeparatedWithComa() {
        // StringCalculator stringCalculator = new StringCalculator(); - zamiennie z ponizszym
        Integer result = StringCalculator.adding("3,2");
        Assertions.assertTrue(result.equals(5));
    }

    @Test
    void ShouldReturnSomeWhenTextContainsNumbersOrNewLineSymbol() {
        // StringCalculator stringCalculator = new StringCalculator(); - zamiennie z ponizszym
        Integer result = StringCalculator.adding("3,2 \n4");
        Assertions.assertTrue(result.equals(9));
    }

    @Test
    void ShouldReturnSomeWhenTextContainsNumbersSeparatedWithCustomDelimiter() {
        // StringCalculator stringCalculator = new StringCalculator(); - zamiennie z ponizszym
        Integer result = StringCalculator.adding("//s\n3s2s 4");
        Assertions.assertTrue(result.equals(9));
    }

    @Test
    void ShouldThrowExceptionWhenTextContainsNegativeNumbers() {
        // StringCalculator stringCalculator = new StringCalculator(); - zamiennie z ponizszym
        NegativeNumberFoundException negativeNumberFoundException = Assertions.assertThrows(
                NegativeNumberFoundException.class,
                () -> StringCalculator.adding("//s\n3s-2s -4"));// potrzebny przepis na to co ma sie wydarzyc, a nie samo wydarzenie, dlaatego lambda na pocatku

        Assertions.assertEquals("Znaleziono ujemne wartosci [-2, -4]", negativeNumberFoundException.getMessage());
    }

    @Test
    void ShouldReturnSumIgnoringBiggerNumbersThan1000() {
        // StringCalculator stringCalculator = new StringCalculator(); - zamiennie z ponizszym
        Integer result = StringCalculator.adding("//s\n3s2000s 4");
        Assertions.assertTrue(result.equals(7));
    }

    @Test
    void ShouldReturnSumWhenTextContainsSeparatedWithCustome() {
        // StringCalculator stringCalculator = new StringCalculator(); - zamiennie z ponizszym
        Integer result = StringCalculator.adding("//s\n3s2000s 4");
        Assertions.assertTrue(result.equals(7));
    }
}
