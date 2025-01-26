package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.Locale;
import java.util.Scanner;

public class Task_10 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy");

        System.out.println("Введите дату в формате ДД.ММ.ГГ (например, 08.01.20).");
        System.out.println("Для выхода введите 'exit'.");

        while (true) {
            System.out.print("Введите дату: ");
            String input = scanner.nextLine();

            // Проверяем, хочет ли пользователь выйти
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Выход из программы. До свидания!");
                break;
            }

            try {
                // Преобразуем строку в объект LocalDate
                LocalDate date = LocalDate.parse(input, formatter);

                // Проверяем диапазон годов
                if (date.getYear() < 2020 || date.getYear() > 2022) {
                    System.out.println("Ошибка: введите дату в диапазоне с 2020 по 2022 год.");
                    continue;
                }

                // Получаем номер недели
                int weekNumber = getWeekNumber(date);

                // Выводим результат
                System.out.println("Неделя " + weekNumber);
            } catch (Exception e) {
                System.out.println("Ошибка: неверный формат даты. Убедитесь, что используете ДД.ММ.ГГ.");
            }
        }

        scanner.close();
    }

    private static int getWeekNumber(LocalDate date) {
        // Определяем, что неделя начинается с понедельника
        WeekFields weekFields = WeekFields.of(Locale.getDefault());

        // Вычисляем номер недели
        return date.get(weekFields.weekOfWeekBasedYear());
    }
}

