package flowershop.commands;

import flowershop.models.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

import static flowershop.models.Flower.FlowerType.*;

public class AddFlowerCommand implements Command {
    private static final Logger logger = LoggerFactory.getLogger(AddFlowerCommand.class);
    private Bouquet bouquet;
    private Scanner scanner;

    public AddFlowerCommand(Bouquet bouquet) {
        this.bouquet = bouquet;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void execute() {
        logger.info("Розпочато додавання квітки до букету");

        System.out.println("\n1. Троянда");
        System.out.println("2. Тюльпан");
        System.out.println("3. Лілія");

        String choice = scanner.nextLine();
        logger.info("Обрано тип квітки: {}", choice);

        try {
            System.out.print("Введіть ціну квітки (грн): ");
            double price = Double.parseDouble(scanner.nextLine());

            System.out.print("Введіть свіжість квітки (1-10): ");
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
                logger.info("Квітка успішно додана: {}", flower);
                System.out.println("Квітку успішно додано до букету.");
            } else {
                logger.warn("Невірний вибір типу квітки: {}", choice);
                System.out.println("Невірний вибір.");
            }
        } catch (NumberFormatException e) {
            logger.error("Помилка введення: некоректне число", e);
            System.out.println("Помилка: Введіть коректне число.");
        }
    }
}
