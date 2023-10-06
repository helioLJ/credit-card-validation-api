package dev.helio.CreditCardValidation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/validate")
public class CreditCardValidationController {
    @Autowired
    private CreditCardValidationService creditCardValidationService;
    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping
    public ResponseEntity<String> validateCreditCard(@RequestBody CreditCard creditCard) {
        boolean isValid = creditCardValidationService.validateCreditCard(creditCard);

        if (isValid) {
            return ResponseEntity.ok("Success!");
        } else {
            return ResponseEntity.badRequest().body("Invalid Credit Card information.");
        }
    }
}
