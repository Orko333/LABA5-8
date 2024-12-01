package flowershop.app;

import flowershop.commands.*;
import flowershop.models.Bouquet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class FlowerShopMenu {
    private Bouquet bouquet;
    private Scanner scanner;
    Logger logger = LoggerFactory.getLogger(FlowerShopMenu.class);

    public FlowerShopMenu() {
        this.bouquet = new Bouquet();
        this.scanner = new Scanner(System.in);
        logger.info("Ініціалізовано FlowerShopMenu.");
    }

    public void displayMenu() {
        logger.info("Меню квіткового магазину запущено.");
        while (true) {
            try {
                System.out.println("\n--- Flower Shop Menu ---");
                System.out.println("1. Створити новий букет");
                System.out.println("2. Додати квітку до букета");
                System.out.println("3. Видалити квітку з букета");
                System.out.println("4. Показати інформацію про букет");
                System.out.println("5. Показати ціну букету");
                System.out.println("6. Відсортувати квіти за свіжістю");
                System.out.println("7. Знайти квіти за довжиною стебла");
                System.out.println("8. Вихід");

                System.out.print("Оберіть опцію: ");
                String choice = scanner.nextLine();
                logger.info("Обрано опцію: {}", choice);

                switch (choice) {
                    case "1" -> {
                        new CreateBouquetCommand(bouquet).execute();
                        logger.info("Створено новий букет.");
                    }
                    case "2" -> {
                        new AddFlowerCommand(bouquet).execute();
                        logger.info("Додано квітку до букета.");
                    }
                    case "3" -> {
                        new RemoveFlowerCommand(bouquet).execute();
                        logger.info("Видалено квітку з букета.");
                    }
                    case "4" -> {
                        new ShowBouquetInfoCommand(bouquet).execute();
                        logger.info("Показано інформацію про букет.");
                    }
                    case "5" -> {
                        new ShowBouquetPriceCommand(bouquet).execute();
                        logger.info("Показано ціну букета.");
                    }
                    case "6" -> {
                        new SortByFreshnessCommand(bouquet).execute();
                        logger.info("Відсортовано квіти за свіжістю.");
                    }
                    case "7" -> {
                        new FindFlowersByLengthCommand(bouquet).execute();
                        logger.info("Знайдено квіти за довжиною стебла.");
                    }
                    case "8" -> {
                        logger.info("Завершення роботи програми.");
                        return;
                    }
                    case "666" -> {
                        try {
                            int result = 10 / 0; // Ситуація з помилкою
                        } catch (ArithmeticException e) {
                            logger.error("Помилка ділення на нуль: ", e);
                        }
                    }
                    default -> {
                        logger.warn("Обрано невірну опцію: {}", choice);
                        System.out.println("Невірна опція. Спробуйте ще раз.");
                    }
                }
            } catch (Exception e) {
                logger.error("Сталася критична помилка: ", e);
            }
        }
    }
}
