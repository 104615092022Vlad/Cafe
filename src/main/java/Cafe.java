/*
1.Создайте новый проект авто-тестов со структурой, подобной той, что мы рассмотрели на занятии.
2.В src/main создайте класс Cafe. Добавьте в него поля “время работы” (строка в формате 10:00 - 18:00),
“выходные дни” (список с порядковыми номерами дней недели, Пн - 1-ый день). А также добавьте методы для:
    a.Установки нового времени работы (на вход поступает только 2 числа,например, для формирования строки
      10:00 - 18:00, метод принимает только числа 10 и 18);
    b.Добавления дней в список выходных;
    c.Удаления дней из списка выходных.
3.Напишите 1 позитивный тест на каждый метод.
*/

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


public class Cafe {
    public static void main(String[] args) {

        Calendar wtFrom = new GregorianCalendar();
        wtFrom.set(Calendar.HOUR_OF_DAY, 0);
        wtFrom.set(Calendar.MINUTE, 0);
        Calendar wtTo = new GregorianCalendar();
        wtTo.set(Calendar.HOUR_OF_DAY, 0);
        wtTo.set(Calendar.MINUTE, 0);

        DateFormat df = new SimpleDateFormat("HH:mm");
        String workingTime = "Время работы: " + df.format(wtFrom.getTime()) + " - " + df.format(wtTo.getTime());

        //Блок кода для установки времени работы
        System.out.println("    Установка рабочего времени");
        workingTime = timeChange(wtFrom, wtTo, df, workingTime);

        //Блок кода для установки выходных дней
        Map<Integer, String> holidays = new HashMap<>();
        System.out.println("    Установка выходных дней");
        boolean triggerHolidays = false;
        while (!triggerHolidays) {
            System.out.println("Хотите добавить ещё один выходной день? 1 -- Да, 0 -- Нет");
            Scanner sc = new Scanner(System.in);
            try {
                switch (sc.nextInt()) {
                    case 0:
                        triggerHolidays = true;
                        break;
                    case 1:
                        addHolidays(holidays);
                        break;
                    default:
                        System.out.println("Некорректный ответ");
                }
            } catch (InputMismatchException e) {
                System.out.println("Некорректный ответ");
            }
        }

        //Режим работы
        schedule(workingTime, holidays);
        System.out.println();

        //Возможность изменить режим работы перед окончательной установкой
        boolean triggerSchedule = false;
        while (!triggerSchedule) {
            System.out.println("Хотите изменить режим работы? 1 -- Да, 0 -- Нет");
            Scanner sc = new Scanner(System.in);
            try {
                switch (sc.nextInt()) {
                    case 0:
                        schedule(workingTime, holidays);
                        triggerSchedule = true;
                        break;
                    case 1:
                        System.out.println("Выберите опцию: 0 -- время, 1 -- добавить выходной, 2 -- удалить выходной");
                        switch (sc.nextInt()) {
                            case 0:
                                workingTime = timeChange(wtFrom, wtTo, df, workingTime);
                                break;
                            case 1:
                                addHolidays(holidays);
                                break;
                            case 2:
                                removeHolidays(holidays);
                                break;
                        }
                        schedule(workingTime, holidays);
                        System.out.println();
                        break;
                    default:
                        System.out.println("Некорректный ответ");
                }
            } catch (InputMismatchException e) {
                System.out.println("Некорректный ответ");
            }
        }
    }
    public static String timeChange (Calendar wtFrom, Calendar wtTo, DateFormat df, String workingTime){
        Scanner sc = new Scanner(System.in);
        boolean triggerTimeChange = false;
        System.out.println("Хотите задать время работы?");
        String answer = sc.next();
        while (triggerTimeChange == false) {
            if (answer.equals("Да") || answer.equals("да")) {
                System.out.println("Установите время начала работы: ");
                System.out.print("Введите часы: ");
                wtFrom.set(Calendar.HOUR_OF_DAY, sc.nextInt());
                System.out.print("Введите минуты: ");
                wtFrom.set(Calendar.MINUTE, sc.nextInt());
                System.out.println("Установите время конца работы: ");
                System.out.print("Введите часы: ");
                wtTo.set(Calendar.HOUR_OF_DAY, sc.nextInt());
                System.out.print("Введите минуты: ");
                wtTo.set(Calendar.MINUTE, sc.nextInt());
                workingTime = "Время работы: " + df.format(wtFrom.getTime()) + " - " + df.format(wtTo.getTime());
                triggerTimeChange = true;
                break;
            } else if (answer.equals("Нет") || answer.equals("нет")) {
                triggerTimeChange = true;
                break;
            } else {
                System.out.println("Ответьте на вопрос: \"Да\" или \"Нет\"?");
                timeChange(wtFrom, wtTo, df, workingTime);
                break;
            }
        }
        return workingTime;
    }
    public static void addHolidays (Map < Integer, String > holidays){
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите номер дня недели: ");
        int n = sc.nextInt();
        String day = "";
        switch (n - 1) {
            case 0:
                day = "Пн";
                break;
            case 1:
                day = "Вт";
                break;
            case 2:
                day = "Ср";
                break;
            case 3:
                day = "Чт";
                break;
            case 4:
                day = "Пт";
                break;
            case 5:
                day = "Сб";
                break;
            case 6:
                day = "Вс";
                break;
            default:
                System.out.println("Введите корректный номер дня недели");
                break;
        }
        holidays.put(n, day);
    }
    public static void removeHolidays (Map < Integer, String > holidays){
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите номер дня недели: ");
        int n = sc.nextInt();
        holidays.remove(n);
    }
    public static void schedule (String workingTime, Map < Integer, String > holidays){
        System.out.println("        Режим работы");
        System.out.println(workingTime);
        System.out.print("Выходные дни: ");
        if (holidays.isEmpty()) {
            System.out.println("без выходных");
        } else {
            for (Map.Entry<Integer, String> item : holidays.entrySet()) {
                System.out.printf("%s ", item.getValue());
            }
        }
        System.out.println();
    }
}

