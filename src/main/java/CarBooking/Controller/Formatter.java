package CarBooking.Controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Formatter {
    private static final DateTimeFormatter formattedTime = DateTimeFormatter.ofPattern("HH:mm");
    private static final DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("dd-MM-yy");
    private static final DateTimeFormatter formattedDob = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private static final DateTimeFormatter formattedDateTime = DateTimeFormatter.ofPattern("HH:mm dd-MM-yy");
    private static final DateTimeFormatter formattedDateReverse = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static String formatTime(LocalTime date) {
        return date.format(formattedTime);
    }
    public static String formatDate(LocalDate date) {
        return date.format(formattedDate);
    }
    public static String formatDob(LocalDate dob) {
        return dob.format(formattedDob);
    }
    public static String formatDateTime(LocalDateTime time) {
        return time.format(formattedDateTime);
    }
    public static LocalDate parseDate(String date) {
        return LocalDate.parse(date, formattedDate);
    }
    public static LocalDate parseDob(String dob) {
        return LocalDate.parse(dob, formattedDob);
    }
    public static LocalTime parseTime(String time) {
        return LocalTime.parse(time, formattedTime);
    }
    public static LocalDateTime parseDateTime(String dateTime) {
        return LocalDateTime.parse(dateTime, formattedDateTime);
    }
    public static LocalDate parseDateReverse(String date) {
        return LocalDate.parse(date, formattedDateReverse);
    }
}
