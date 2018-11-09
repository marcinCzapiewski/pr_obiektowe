package obiektowka.leanapp.validators;

public class NipValidator implements Validator {

    private byte NIP[] = new byte[10];
    private boolean valid = false;

    public NipValidator(String NIPNumber) {
        if (NIPNumber.length() != 10){
            valid = false;
        }
        else {
            for (int i = 0; i < 10; i++){
                NIP[i] = Byte.parseByte(NIPNumber.substring(i, i+1));
            }
            if (checkSum()) {
                valid = true;
            }
            else {
                valid = false;
            }
        }
    }

    public boolean isValid() {
        return valid;
    }

    private boolean checkSum() {
        int sum;
        sum = 6 * NIP[0] +
                5 * NIP[1] +
                7 * NIP[2] +
                2 * NIP[3] +
                3 * NIP[4] +
                4 * NIP[5] +
                5 * NIP[6] +
                6 * NIP[7] +
                7 * NIP[8];
        sum %= 11;

        if (NIP[9] == sum)
            return true;
        else
            return false;
    }
}