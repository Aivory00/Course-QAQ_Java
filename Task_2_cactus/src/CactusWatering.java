import java.time.LocalDate;
import java.util.Scanner;

public class CactusWatering
{
    public static void main(String... args)

    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите год последнего полива: "); // на вход одно число (например: 2022)
        int year = scanner.nextInt();

        System.out.print("Введите месяц даты последнего полива: "); // число от 1 до 12 (например: 11)
        int month = scanner.nextInt();

        System.out.print("Введите день даты последнего полива: "); //число от 1 до 12 (например: 26)
        int day = scanner.nextInt();

        LocalDate lastWateringDate = LocalDate.of(year, month, day);
        LocalDate currentDate = LocalDate.now();
        String message;

        if (currentDate.getMonthValue() == 12 || currentDate.getMonthValue() <= 2)
        {
            if (currentDate.minusMonths(1).isAfter(lastWateringDate))
                {
                message = "Кактус нужно полить. Прошло больше месяца с даты последнего полива" + "(" + lastWateringDate + ").";
                }
            else
                {
                message = "Кактус не нужно поливать. Прошло меньше месяца с даты последнего полива" + "(" + lastWateringDate + ").";
                }
        }
        else if ((currentDate.getMonthValue() <= 5 || currentDate.getMonthValue() >= 9))
            {
            message = "Кактус нужно полить. Прошло больше недели с даты последнего полива " + "(" + lastWateringDate + ").";
            }
        else
        {
            Humiditys sensor = new Sensor ();
            int humidity = sensor.getHumidity();
            if (humidity < 30)
                {
                message = "Кактус нужно полить, так как влажность воздуха ниже 30% " + "(" + humidity + "%). Дата последнего полива: "  + lastWateringDate + ".";
                }
            else if (currentDate.minusDays(2).isAfter(lastWateringDate))
                {
                message = "Кактус нужно полить, так как прошло более двух дней с даты последнего полива. Дата последнего полива: "  + lastWateringDate + ".";
                }
            else
                {
                message = "Кактус не нужно поливать, так как последний полив был менее двух дней назал. Показания датчика влажности: " + humidity + "%. Дата последнего полива: "  + lastWateringDate + ".";
                }
        }

        System.out.println(message);
    }
}