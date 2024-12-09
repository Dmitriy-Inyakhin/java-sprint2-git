/**
 * Финальное задание 2 спринта
 * программы вычисляющая статистику шагов по дням месяца и месяцам
 * и возвращающая пройденный путь и количество килокалорий за выбранный месяц
 * <p>
 * Код написан Иняхиным Дмитрием Андреевичем
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);

        while (true) {
            printMenu(); //функция печати меню пользователя
            String cmd = scanner.next();

            if ("1".equals(cmd)) { // обработка пользовательского меню
                stepTracker.addNewNumberStepsPerDay();
            } else if ("2".equals(cmd)) {
                stepTracker.changeStepGoal();
            } else if ("3".equals(cmd)) {
                stepTracker.printStatistic();
            } else if ("4".equals(cmd)) {
                System.out.println("Программа завершена");
                return;
            } else {
                System.out.println("Нет такой команды,повторите ввод.");
            }

            System.out.println();
            System.out.println("-".repeat(20));
            System.out.println();
        }
    }

    static void printMenu() {
        System.out.println("1. Введите количество шагов за определенный день");
        System.out.println("2. Установите цель по количеству шагов в день :");
        System.out.println("3. Напечатать статистику шагов за определенный месяц");
        System.out.println("4. Выход из программы");

    }
}