package flowershop.commands;

import flowershop.models.Bouquet;
import flowershop.models.Flower;
import flowershop.models.Accessory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShowBouquetPriceCommandTest {
    private Bouquet bouquet;
    private ShowBouquetPriceCommand command;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        bouquet = new Bouquet();
        command = new ShowBouquetPriceCommand(bouquet);

        // Додаємо квіти та аксесуари з певною вартістю
        bouquet.addFlower(new Flower(Flower.FlowerType.ROSE, 10.0, 5, 40));
        bouquet.addFlower(new Flower(Flower.FlowerType.LILY, 15.0, 7, 50));
        bouquet.addAccessory(new Accessory("Стрічка", 5.0));

        // Перехоплюємо консольний вивід
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void testExecuteShowBouquetPrice() {
        // Виконуємо команду для обчислення вартості
        command.execute();

        // Очікуваний вивід
        String expectedOutput = "Загальна вартість букету: 30,00 грн";
        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }
}
