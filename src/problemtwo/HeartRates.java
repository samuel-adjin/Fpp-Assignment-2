package problemtwo;

import java.time.LocalDate;
import java.time.Period;

public class HeartRates {

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private static final int RESTING_HEART_RATE = 70;
    private static final double LOWER_BOUNDARY = 0.5;
    private static final double UPPER_BOUNDARY = 0.85;
    private  int maximumHeartRate;

    public HeartRates(String firstName, String lastName, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        int age = calculateAge(dateOfBirth);
        this.maximumHeartRate = calculateMaxHeartRate(age);
    }

    public int calculateAge(LocalDate dateOfBirth) {
       return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

    public int calculateMaxHeartRate(int age) {
        return 220-age;
    }

    public void calculateHeartRateRange() {
        int averageHeartRate = this.maximumHeartRate - RESTING_HEART_RATE;
        //Lower Boundary Target Heart Rate(LBTHR)
        double lowerBoundaryTargetHeartRate = (averageHeartRate * LOWER_BOUNDARY) + RESTING_HEART_RATE;
        //Upper Boundary Target Heart Rate (UBTHR)
        double upperBoundaryTargetHeartRate = (averageHeartRate * UPPER_BOUNDARY) + RESTING_HEART_RATE;
        System.out.printf("The Target Heart Rate Range is between %.2f and %f%n",lowerBoundaryTargetHeartRate,upperBoundaryTargetHeartRate );
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "First Name : " + this.getFirstName() + '\n' +
                "Last Name : " + this.getLastName() + '\n' +
                "Age : " + calculateAge(this.dateOfBirth) + '\n' +
                "Date of Birth : " + this.getDateOfBirth() + '\n' +
                "Maximum Heart Rate : " + maximumHeartRate;
    }
}
