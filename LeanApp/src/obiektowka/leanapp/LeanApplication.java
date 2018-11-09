package obiektowka.leanapp;

import obiektowka.leanapp.validators.IbanValidator;
import obiektowka.leanapp.validators.NipValidator;
import obiektowka.leanapp.validators.PeselValidator;

import java.util.Calendar;
import java.util.Date;

public class LeanApplication {
    private String firstName;
    private String surname;
    private String pesel;
    private String nip;
    private String bankAccountNumber;
    private Date dateOfBirth;
    private Enum<Gender> gender;

    @Override
    public String toString() {
        return "Customer info: {" +
                "firstName='" + firstName + '\'' +
                "\n surname='" + surname + '\'' +
                "\n pesel='" + pesel + '\'' +
                "\n nip='" + nip + '\'' +
                "\n bankAccountNumber='" + bankAccountNumber + '\'' +
                "\n dateOfBirth=" + dateOfBirth +
                "\n gender=" + gender +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws Exception {
        if (firstName == null || !firstName.chars().allMatch(Character::isLetter) || firstName.length() < 2) {
           throw new Exception("First name is invalid. It cannot be empty, must be at least 2 chars and contain only letters");
        }
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) throws Exception {
        if (surname == null || !surname.chars().allMatch(Character::isLetter) || surname.length() < 2) {
            throw new Exception("Surname is invalid. It cannot be empty, must be at least 2 chars and contain only letters");
        }
        this.surname = surname;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) throws Exception {
        PeselValidator peselValidator = new PeselValidator(pesel);
        if(!peselValidator.isValid())
            throw new Exception("Invalid pesel!");

        this.pesel = pesel;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) throws Exception {
        NipValidator nipValidator = new NipValidator(nip);
        if(!nipValidator.isValid())
            throw new Exception("Invalid NIP!");

        this.nip = nip;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) throws Exception {
        IbanValidator ibanValidator = new IbanValidator(bankAccountNumber);
        if(!ibanValidator.isValid()) {
            throw new Exception("Invalid bank account number!");
        }
        this.bankAccountNumber = bankAccountNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) throws Exception {
        Calendar calendar = toCalendar(dateOfBirth);

        int year = calendar.get(Calendar.YEAR);
        if(pesel.substring(0, 2) == String.valueOf(year).substring(2, 4))
            throw new Exception("Year of birth does not match pesel");

        int month = calendar.get(Calendar.MONTH);
        int peselMonth = Integer.parseInt(pesel.substring(2,4));
        if(month != peselMonth)
            throw new Exception("Month of birth does not match pesel");

        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int peselDay = Integer.parseInt(pesel.substring(4,6));
        if(day != peselDay)
            throw new Exception("Day of birth does not match pesel");

        this.dateOfBirth = dateOfBirth;
    }

    public Enum<Gender> getGender() {
        return gender;
    }

    public void setGender(Enum<Gender> gender) throws Exception {
        boolean isWoman = Character.getNumericValue(pesel.charAt(9)) % 2 == 0;

        if((gender == Gender.man && isWoman) || (gender == Gender.woman && !isWoman))
            throw new Exception("Gender does not match pesel");

        this.gender = gender;
    }

    private static Calendar toCalendar(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }
}
