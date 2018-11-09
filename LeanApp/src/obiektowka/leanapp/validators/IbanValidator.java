package obiektowka.leanapp.validators;

import java.math.BigInteger;

public final class IbanValidator implements Validator {

    private static final int IBANNUMBER_MIN_SIZE = 15;
    private static final int IBANNUMBER_MAX_SIZE = 34;
    private static final BigInteger IBANNUMBER_MAGIC_NUMBER = new BigInteger("97");

    private boolean valid = false;

    public IbanValidator(String iban) {
        String newAccountNumber = iban.trim();

        if (newAccountNumber.length() < IBANNUMBER_MIN_SIZE || newAccountNumber.length() > IBANNUMBER_MAX_SIZE) {
            valid = false;
        }

        // Move the four initial characters to the end of the string.
        newAccountNumber = newAccountNumber.substring(4) + newAccountNumber.substring(0, 4);

        // Replace each letter in the string with two digits, thereby expanding the string, where A = 10, B = 11, ..., Z = 35.
        StringBuilder numericAccountNumber = new StringBuilder();
        for (int i = 0;i < newAccountNumber.length();i++) {
            numericAccountNumber.append(Character.getNumericValue(newAccountNumber.charAt(i)));
        }

        // Interpret the string as a decimal integer and compute the remainder of that number on division by 97.
        BigInteger ibanNumber = new BigInteger(numericAccountNumber.toString());
        if(ibanNumber.mod(IBANNUMBER_MAGIC_NUMBER).intValue() == 1) {
            valid = true;
        }
    }

    public boolean isValid() {
        return valid;
    }
}