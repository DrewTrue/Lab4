package humanResources;

import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plusDays(1);
        System.out.println(ChronoUnit.DAYS.between(today, tomorrow));
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        LocalDate date1 = LocalDate.now();
        System.out.println(date1);
        System.out.println(Calendar.getInstance().getTime());
        Date date = new Date();
        System.out.println(date.getTime());
        System.out.println(date.toString());
        LocalDateTime localDateTime1 = LocalDateTime.now();
        StaffEmployee staffEmployee = new StaffEmployee("hj","gj");
        Department department = new Department("sdf", -1);
        System.out.println(department.getSize());
    }
}
