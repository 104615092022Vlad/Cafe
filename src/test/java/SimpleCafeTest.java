import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class SimpleCafeTest {
    @Test
    public void shouldTimeSet() {
        SimpleCafe simpleCafe_1 = new SimpleCafe();
        String res = simpleCafe_1.timeSet(10, 0, 18, 0);
        Assertions.assertEquals("Время работы: 10:00 - 18:00", res);
    }

    @Test
    public void shouldAddHolidays() {
        SimpleCafe simpleCafe_2 = new SimpleCafe();
        Map<Integer, String> sample_1 = new HashMap<>();
        //sample_1.put(1, "Пн");
        //sample_1.put(2, "Вт");
        //sample_1.put(3, "Ср");
        //sample_1.put(4, "Чт");
        //sample_1.put(5, "Пт");
        sample_1.put(6, "Сб");
        sample_1.put(7, "Вс");

        Map<Integer, String> holidays = new HashMap<>();
        holidays = simpleCafe_2.addHolidays(holidays,0,0,0,0,0,1,1);
        Assertions.assertTrue(sample_1.equals(holidays));
    }

    @Test
    public void removeHolidays() {
        SimpleCafe simpleCafe_2 = new SimpleCafe();
        Map<Integer, String> sample_2 = new HashMap<>();
        //sample_2.put(1, "Пн");
        sample_2.put(2, "Вт");
        //sample_2.put(3, "Ср");
        sample_2.put(4, "Чт");
        //sample_2.put(5, "Пт");
        //sample_2.put(6, "Сб");
        //sample_2.put(7, "Вс");

        Map<Integer, String> holidays = new HashMap<>();
        holidays.put(1, "Пн");
        holidays.put(2, "Вт");
        holidays.put(3, "Ср");
        holidays.put(4, "Чт");
        holidays.put(5, "Пт");
        holidays.put(6, "Сб");
        holidays.put(7, "Вс");

        holidays = simpleCafe_2.removeHolidays(holidays,1,0,1,0,1,1,1);
        Assertions.assertTrue(sample_2.equals(holidays));
    }
}
