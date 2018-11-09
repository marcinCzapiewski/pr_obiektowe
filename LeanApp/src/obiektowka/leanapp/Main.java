package obiektowka.leanapp;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main {

    public static void main(String[] args) {
        LeanApplication leanApplication = new LeanApplication();

        try {
            leanApplication.setFirstName("Marcin");
            //leanApplication.setFirstName("fs!!!");

            leanApplication.setSurname("Czapiewski");
            //leanApplication.setSurname("g1g#");

            leanApplication.setPesel("90090515836");
            //leanApplication.setPesel("9999999999");

            leanApplication.setNip("7251801126");
            //leanApplication.setNip("9999996999");

            leanApplication.setBankAccountNumber("PL61109010140000071219812874");
            //leanApplication.setBankAccountNumber("PL99999999999999999999999999");

            Date date = new GregorianCalendar(1990, 9, 05).getTime();
            leanApplication.setDateOfBirth(date);

            date = new GregorianCalendar(1990, 9, 02).getTime();
            //leanApplication.setDateOfBirth(date);

            leanApplication.setGender(Gender.man);
            //leanApplication.setGender(Gender.woman);


        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(leanApplication.toString());
    }
}
