package dev.helio.CreditCardValidation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditCard {
    private String cardNumber;
    private String expiryDate;
    private String cvv;
}
