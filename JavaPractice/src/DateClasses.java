import java.sql.SQLOutput;
import java.time.DateTimeException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class DateClasses {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        String dateString = today.toString();
        LocalDate dd = LocalDate.parse(dateString);
        System.out.println(dd);

        LocalDate yesterday = today.minusDays(1);
        System.out.println(yesterday);

        LocalDate twoMonthBack = today.minusMonths(2);
        System.out.println(twoMonthBack);

        LocalDate customerDate = LocalDate.of(1995, 5, 15);
        System.out.println(customerDate);

        System.out.println(Duration.between(twoMonthBack.atStartOfDay(), yesterday.atStartOfDay()).toDays());

        System.out.println(Period.between(customerDate, today));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dd1 = LocalDate.parse("15/05/1995", formatter);
        System.out.println(dd1);
    }
}
