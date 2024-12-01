package problemthree;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Event {
    private String eventName;
    private LocalDate eventDate;
    private LocalTime eventTime;
    private ZoneId timeZone;

    public Event(String eventName, LocalDate eventDate, LocalTime eventTime, ZoneId timeZone) {
        if (!eventDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Event date must be in the future.");
        }
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.timeZone = timeZone;
    }

    public String getEventName() {
        return eventName;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public LocalTime getEventTime() {
        return eventTime;
    }

    public DayOfWeek getDayOfWeek(){
        return (eventDate.getDayOfWeek());
    }

    public String eventOnLeapYear(LocalDate eventDate){
        if(eventDate.isLeapYear()) return ("\nAnd it is on a leap year.");
        else return ("\nAnd It is not on a leap year.");
    }

    public long remainingDayToEvent(LocalDate eventDate){
        return ChronoUnit.DAYS.between(LocalDate.now(), eventDate);
    }

    public String convertTimeZone(ZoneId targetZoneId) {
        ZonedDateTime zonedDateTime = ZonedDateTime.of(eventDate, eventTime, ZoneId.of("America/New_York"));
        ZonedDateTime targetZonedDateTime = zonedDateTime.withZoneSameInstant(targetZoneId);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        return "For [" + targetZoneId + "]  time zone --> the event will be on " + targetZonedDateTime.getDayOfWeek() + " " +targetZonedDateTime.format(dateFormatter) + " @ " + targetZonedDateTime.format(timeFormatter);
    }

    @Override
    public String toString() {
        return  "For [America/New_York] time zone --> the '" + getEventName() + "' " +
                "event will be held on '" + getDayOfWeek()+
                "' of '" + getEventDate() + "'" +
                " @ '" + getEventTime() +"'" +
                eventOnLeapYear(this.getEventDate()) +
                "It remains '" + remainingDayToEvent(this.getEventDate()) +"' days to start the event.\n" +
                "==========================================" ;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Input event name.
        System.out.println("Please, enter the event name = ");
        String inputEventName = sc.nextLine();

        //User input the event date and check if it is the future date or not
        LocalDate inputEventDate = null;
        while (inputEventDate == null || !inputEventDate.isAfter(LocalDate.now())){
            System.out.println("Please, enter the event date (yyyy-M-d) = ");
            String eDate = sc.nextLine();
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-M-d");
            try { inputEventDate = LocalDate.parse(eDate, dateFormatter);
                if (!inputEventDate.isAfter(LocalDate.now())) {
                    System.out.println("Please, enter the future date only !");
                } }
            catch (DateTimeParseException e) {
                System.out.println("Invalid date format, Please try again.");
            }
        }
        //Input the event time.
        LocalTime inputEventTime = null;
        while (inputEventTime == null) {
            System.out.print("Please, enter the event time (HH:mm) = ");
            String eTime = sc.nextLine();
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
            try { inputEventTime = LocalTime.parse(eTime, timeFormatter);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid, please enter hours (0-23) and minute (0-59) format HH:mm.");
            }
        }

        // Input the event time zone
        System.out.println("Your default time zone is \"America/Chicago\").");
        System.out.println("----------------------------------------------------");
        System.out.print("Please, enter the time zone for the event (e.g., Asia/Phnom_Penh , America/Santiago , America/Phoenix) = ");
        String inputTimeZone = sc.nextLine();
        ZoneId zd = ZoneId.of(inputTimeZone);

        System.out.println();
        Event event1 = new Event(inputEventName,inputEventDate,inputEventTime,ZoneId.of("America/New_York"));
        System.out.println(event1);
        System.out.println(event1.convertTimeZone(zd));
        sc.close();

    }
}
