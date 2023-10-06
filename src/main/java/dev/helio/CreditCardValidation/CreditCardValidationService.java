package dev.helio.CreditCardValidation;

import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class CreditCardValidationService {
    public boolean validateCreditCard(CreditCard creditCard) {
        if (!isValidExpiryDate(creditCard.getExpiryDate())) {
            return false;
        }

        if (!isValidCVV(creditCard.getCardNumber(), creditCard.getCvv())) {
            return false;
        }

        if (!isValidCardNumber(creditCard.getCardNumber())) {
            return false;
        }

        return true;
    }

    private static boolean isValidExpiryDate(String expiryDate) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/yy");
            Date expDate = sdf.parse(expiryDate);
            Date currentDate = new Date();

            return expDate.after(currentDate);
        } catch (ParseException e) {
            return false;
        }
    }

    private static boolean isValidCVV(String cardNumber, String cvv) {
        if (cardNumber.startsWith("34") || cardNumber.startsWith("37")) {
            return cvv.length() == 4;
        } else {
            return cvv.length() == 3;
        }
    }

    private static boolean isValidCardNumber(String cardNumber) {
        if (cardNumber.length() < 16 || cardNumber.length() > 19) {
            return false;
        }

        if (!isLuhnValid(cardNumber)) {
            return false;
        }

        return true;
    }

    private static boolean isLuhnValid(String cardNumber) {
        int[] digits = new int[cardNumber.length()];
        for (int i = 0; i < cardNumber.length(); i++) {
            digits[i] = Character.getNumericValue(cardNumber.charAt(i));
        }

        for (int i = digits.length - 2; i >= 0; i -= 2) {
            int doubleDigit = digits[i] * 2;
            if (doubleDigit > 9) {
                doubleDigit -= 9;
            }
            digits[i] = doubleDigit;
        }

        int sum = 0;
        for (int digit : digits) {
            sum += digit;
        }

        return sum % 10 == 0;
    }

}
