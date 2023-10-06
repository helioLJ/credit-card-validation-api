package dev.helio.CreditCardValidation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CreditCardValidationServiceTest {
    @Autowired
    private CreditCardValidationService creditCardValidationService;
    @Test
    void testValidCreditCard() {
        CreditCard validCreditCard = new CreditCard("4916011117218331", "02/27", "279");

        boolean isValid = creditCardValidationService.validateCreditCard(validCreditCard);
        assertTrue(isValid);
    }

    @Test
    void testInvalidCardNumber() {
        CreditCard invalidCreditCard = new CreditCard("340845862098539", "02/25", "386");

        boolean isValid = creditCardValidationService.validateCreditCard(invalidCreditCard);
        assertFalse(isValid);
    }

    @Test
    void testInvalidExpiryDate() {
        CreditCard invalidCreditCard = new CreditCard("340845862098537", "02/22", "386");

        boolean isValid = creditCardValidationService.validateCreditCard(invalidCreditCard);
        assertFalse(isValid);
    }

    @Test
    void testInvalidCvv() {
        CreditCard invalidCreditCard = new CreditCard("340845862098537", "02/25", "38");

        boolean isValid = creditCardValidationService.validateCreditCard(invalidCreditCard);
        assertFalse(isValid);
    }
}
