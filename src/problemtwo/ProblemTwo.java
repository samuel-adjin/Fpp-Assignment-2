package problemtwo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ProblemTwo {

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");
        LocalDate dateOfBirth = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please, enter your first name:");
        String firstName = sc.nextLine();
        System.out.println("Please, enter your last name:");
        String lastName = sc.nextLine();
        while(dateOfBirth == null) {
            System.out.println("Please, enter your date of birth in the format-(yyyy-mm-dd)-Example 1989-4-14:");
            String dateOfBirthString = sc.nextLine();
            try {
                dateOfBirth = LocalDate.parse(dateOfBirthString, formatter);
            } catch(DateTimeParseException e) {
                System.out.println("Error! Please try again");
            }
        }

        HeartRates heartRates = new HeartRates(firstName, lastName, dateOfBirth);
        heartRates.calculateHeartRateRange();
        System.out.println(heartRates);
    }
}
