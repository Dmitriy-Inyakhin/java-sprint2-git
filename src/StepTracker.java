import java.util.Scanner;

public class StepTracker {
    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];
    int goalByStepsPerDay = 10000;
    Converter converter = new Converter();

    public StepTracker(Scanner aScanner) { //конструктор календаря -12 месяцев
        scanner = aScanner;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    public void addNewNumberStepsPerDay() { // функция ввода исходных данных
        int monthNumber, dayNumber, numberOfSteps;

        while (true) { // обработка и ввод номера месяца
            System.out.println("(Январь - 1, Февраль - 2, Март - 3, Апрель - 4, Май - 5, Июнь - 6,");
            System.out.println("Июль - 7, Август - 8, Сентябрь - 9, Октябрь - 10, Ноябрь - 11, Декабрь - 12)");
            System.out.print("Введите номер месяца (от 1 до 12): ");

            monthNumber = scanner.nextInt();
            if (monthNumber >= 1 && monthNumber <= 12) {
                break;
            }
            System.out.println("Введено не правильное число месяца - " + monthNumber + ". Повторите ввод.");
        }

        while (true) {// обработка и ввод номера дня в месяце
            System.out.print("Введите номер дня месяца (от 1 до 30): ");
            dayNumber = scanner.nextInt();
            if (dayNumber >= 1 && dayNumber <= 30) {
                break;
            }
            System.out.println("Введено не правильное число дня месяца - " + dayNumber + ". Повторите ввод.");
        }

        while (true) { // обработка и ввод количества шагов за день
            System.out.print("Введите количество шагов (больше 0): ");
            numberOfSteps = scanner.nextInt();
            if (numberOfSteps > 0) {
                break;
            }
            System.out.println("Число шагов должно быть больше 0, повторите ввод.");
        }

        // записываем число шагов в день месяца
        monthToData[monthNumber - 1].days[dayNumber - 1] = numberOfSteps;
        System.out.println((monthNumber - 1) + " " + (dayNumber - 1) + " "
                + monthToData[monthNumber - 1].days[dayNumber - 1]);
    }

    public void changeStepGoal() { // функция изменения цели шагов в день
        while (true) {
            System.out.print("Введите новую цель по шагам в день (положительное число, больше 0): ");
            goalByStepsPerDay = scanner.nextInt();
            if (goalByStepsPerDay >= 1) {
                break;
            }
            System.out.println("Введено отрицательное число или 0, повторите ввод");
        }
    }

    public void printStatistic() { // функция печати статистики по дням
        int monthNumber;
        while (true) {
            System.out.print("Введите номер месяца (от 1 до 12): ");
            monthNumber = scanner.nextInt();
            if (monthNumber >= 1 && monthNumber <= 12) {
                break;
            }
            System.out.println("Введено не правильное число месяца - " + monthNumber + ". Повторите ввод.");
        }
        System.out.println("Количество пройденных шагов по дням:");
        monthToData[monthNumber - 1].printDaysAndStepsFromMonth();
        System.out.println("Общее количество шагов за месяц: " + monthToData[monthNumber - 1].sumStepsFromMonth());
        System.out.println("Максимальное пройденное количество шагов в месяце: "
                + monthToData[monthNumber - 1].maxSteps());
        System.out.println("Среднее количество шагов: " + (monthToData[monthNumber - 1].sumStepsFromMonth() / 30));
        System.out.println("Пройденная дистанция (в километрах): "
                + converter.convertToKm(monthToData[monthNumber - 1].sumStepsFromMonth()));
        System.out.println("Количество сожжённых килокалорий: "
                + converter.convertStepsToKilocalories(monthToData[monthNumber - 1].sumStepsFromMonth()));
        System.out.println("Лучшая серия: максимальное количество подряд идущих дней, " +
                "в течение которых количество шагов за день было равно или выше целевого: "
                + monthToData[monthNumber - 1].bestSeries(goalByStepsPerDay));
    }
}