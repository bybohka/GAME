import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        // Создаем объекты для ввода и генерации случайных чисел
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Настройки игры
        int maxAttempts = 3; // Максимальное количество попыток
        int range = 50;     // Компьютер загадывает число от 1 до range

        // Главный цикл игры
        while (true) {
            // Генерируем случайное число
            int secretNumber = random.nextInt(range) + 1;
            int attempts = 0;

            System.out.println("\nЯ загадал число от 1 до " + range + "!");
            System.out.println("У вас есть " + maxAttempts + " попыток. Удачи!");

            // Цикл попыток угадывания
            while (attempts < maxAttempts) {
                System.out.print("Введите вашу догадку: ");

                // Обрабатываем некорректный ввод
                if (!scanner.hasNextInt()) {
                    System.out.println("Пожалуйста, введите целое число!");
                    scanner.next();
                    continue;
                }

                int userGuess = scanner.nextInt();
                attempts++;

                // Проверяем догадку
                if (userGuess == secretNumber) {
                    System.out.println("Поздравляю! Вы угадали число " + secretNumber + " за " + attempts + " попыток!");
                    break;
                } else if (userGuess < secretNumber) {
                    System.out.println("Слишком маленькое! Попробуйте еще.");
                } else {
                    System.out.println("Слишком большое! Попробуйте еще.");
                }

                // Показываем оставшиеся попытки
                System.out.println("Осталось попыток: " + (maxAttempts - attempts));
            }

            // Сообщение если закончились попытки
            if (attempts == maxAttempts) {
                System.out.println("Увы! Вы исчерпали все попытки. Загаданное число было: " + secretNumber);
            }

            System.out.print("Приветушки ");

            // Предложение сыграть еще раз
            System.out.print("Хотите сыграть еще раз? (да/нет): ");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("да")) {
                System.out.println("Спасибо за игру! До свидания!");
                break;
            }
        }
        scanner.close();
    }
}
