import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class SimpleCafe {
    public static void main(String[] args) {
        String workingTime = timeSet(10, 0, 18, 0);
        Map<Integer, String> holidays = new HashMap<>();
        holidays = addHolidays(holidays,0,0,0,0,0,1,1);
        holidays = removeHolidays(holidays, 0,0,0,0,0,1,0);
        System.out.println("    Режим работы");
        System.out.println(workingTime);
        showValuesOfMap(holidays);

    }

    public static String timeSet(int wtFromH, int wtFromM, int wtToH, int wtToM) {
        DateFormat df = new SimpleDateFormat("HH:mm");
        Calendar wtFrom = new GregorianCalendar();
        wtFrom.set(Calendar.HOUR_OF_DAY, wtFromH);
        wtFrom.set(Calendar.MINUTE, wtFromM);
        Calendar wtTo = new GregorianCalendar();
        wtTo.set(Calendar.HOUR_OF_DAY, wtToH);
        wtTo.set(Calendar.MINUTE, wtToM);
        String workingTime = "Время работы: " + df.format(wtFrom.getTime()) + " - " + df.format(wtTo.getTime());
        return workingTime;
    }

    public static Map<Integer, String> addHolidays(Map<Integer, String> holidays, int mon, int tue, int wed, int thu, int fri, int sat, int sun) {
        int n;
        String day;
        if (mon == 1) {
            n = 1;
            day = "Пн";
            holidays.put(n, day);
        }
        if (tue == 1) {
            n = 2;
            day = "Вт";
            holidays.put(n, day);
        }
        if (wed == 1) {
            n = 3;
            day = "Ср";
            holidays.put(n, day);
        }
        if (thu == 1) {
            n = 4;
            day = "Чт";
            holidays.put(n, day);
        }
        if (fri == 1) {
            n = 5;
            day = "Пт";
            holidays.put(n, day);
        }
        if (sat == 1) {
            n = 6;
            day = "Сб";
            holidays.put(n, day);
        }
        if (sun == 1) {
            n = 7;
            day = "Вс";
            holidays.put(n, day);
        }
        return holidays;
    }

    public static Map <Integer, String> removeHolidays(Map<Integer, String> holidays, int mon, int tue, int wed, int thu, int fri, int sat, int sun) {
        int n;
        String day;
        if (mon == 1) {
            n = 1;
            day = "Пн";
            holidays.remove(n, day);
        }
        if (tue == 1) {
            n = 2;
            day = "Вт";
            holidays.remove(n, day);
        }
        if (wed == 1) {
            n = 3;
            day = "Ср";
            holidays.remove(n, day);
        }
        if (thu == 1) {
            n = 4;
            day = "Чт";
            holidays.remove(n, day);
        }
        if (fri == 1) {
            n = 5;
            day = "Пт";
            holidays.remove(n, day);
        }
        if (sat == 1) {
            n = 6;
            day = "Сб";
            holidays.remove(n, day);
        }
        if (sun == 1) {
            n = 7;
            day = "Вс";
            holidays.remove(n, day);
        }
        return holidays;
    }

    public static void showValuesOfMap(Map<Integer, String> holidays) {
        System.out.print("Выходные дни: ");
        for (Map.Entry<Integer, String> item : holidays.entrySet()) {
            System.out.printf("%s ", item.getValue());
        }
        System.out.println();
    }
}
