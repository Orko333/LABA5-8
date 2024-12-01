package flowershop.commands;

import flowershop.app.FlowerShopMenu;
import flowershop.models.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

import static flowershop.models.Flower.FlowerType.*;

public class CreateBouquetCommand implements Command {
    private static final Logger logger = LoggerFactory.getLogger(CreateBouquetCommand.class);
    private Bouquet bouquet;
    private Scanner scanner;

    public CreateBouquetCommand(Bouquet bouquet) {
        this.bouquet = bouquet;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void execute() {
        logger.info("Розпочато створення нового букету");
        System.out.println("\nСтворення нового букету");
        bouquet.clear();

        addFlowers();
        addAccessories();

        logger.info("Букет створено успішно. Зміст: {}", bouquet);
        System.out.println("\nБукет створено успішно!");
        bouquet.displayContents();
    }

    private void addFlowers() {
        while (true) {
            System.out.println("\nДодавання квітів до букету:");
            System.out.println("1. Додати троянду");
            System.out.println("2. Додати тюльпан");
            System.out.println("3. Додати лілію");
            System.out.println("4. Завершити додавання квітів");

            String choice = scanner.nextLine();
            logger.info("Обрано опцію: {}", choice);

            if (choice.equals("4")) {
                logger.info("Додавання квітів завершено");
                break;
            }

            try {
                System.out.print("Введіть ціну квітки (грн): ");
                double price = Double.parseDouble(scanner.nextLine());

                System.out.print("Введіть рівень свіжості (1-10): ");
                int freshness = Integer.parseInt(scanner.nextLine());

                System.out.print("Введіть довжину стебла (см): ");
                int stemLength = Integer.parseInt(scanner.nextLine());

                Flower flower = switch (choice) {
                    case "1" -> new Flower(ROSE, price, freshness, stemLength);
                    case "2" -> new Flower(TULIP, price, freshness, stemLength);
                    case "3" -> new Flower(LILY, price, freshness, stemLength);
                    default -> null;
                };

                if (flower != null) {
                    bouquet.addFlower(flower);
                    logger.info("Додано квітку: {}", flower);
                    System.out.println("Квітку успішно додано до букету");
                }
            } catch (NumberFormatException e) {
                logger.error("Помилка введення: некоректне число", e);
                System.out.println("Помилка: Введіть коректне число");
            }
        }
    }

    private void addAccessories() {
        while (true) {
            System.out.println("\nДодавання аксесуарів до букету:");
            System.out.println("1. Додати стрічку");
            System.out.println("2. Додати упаковку");
            System.out.println("3. Додати листівку");
            System.out.println("4. Завершити додавання аксесуарів");

            String choice = scanner.nextLine();
            logger.info("Обрано опцію: {}", choice);

            if (choice.equals("4")) {
                logger.info("Додавання аксесуарів завершено");
                break;
            }

            try {
                System.out.print("Введіть ціну аксесуара (грн): ");
                double price = Double.parseDouble(scanner.nextLine());

                String name = switch (choice) {
                    case "1" -> "Стрічка";
                    case "2" -> "Упаковка";
                    case "3" -> "Листівка";
                    default -> "";
                };

                if (!name.isEmpty()) {
                    Accessory accessory = new Accessory(name, price);
                    bouquet.addAccessory(accessory);
                    logger.info("Додано аксесуар: {}", accessory);
                    System.out.println("Аксесуар успішно додано до букету");
                }
            } catch (NumberFormatException e) {
                logger.error("Помилка введення: некоректне число", e);
                System.out.println("Помилка: Введіть коректне число");
            }
        }
    }
}
