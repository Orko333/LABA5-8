package flowershop.commands;

import flowershop.models.Bouquet;
import flowershop.models.Flower;
import flowershop.models.Accessory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShowBouquetInfoCommandTest {
    private Bouquet bouquet;
    private ShowBouquetInfoCommand command;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        bouquet = new Bouquet();
        command = new ShowBouquetInfoCommand(bouquet);

        // Додаємо квіти та аксесуари для тестування
        bouquet.addFlower(new Flower(Flower.FlowerType.ROSE, 10.0, 5, 40));
        bouquet.addFlower(new Flower(Flower.FlowerType.LILY, 15.0, 7, 50));
        bouquet.addAccessory(new Accessory("Стрічка", 5.0));

        // Перехоплюємо консольний вивід
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void testExecuteShowBouquetInfo() {
        // Виконуємо команду для показу інформації про букет
        command.execute();

        // Очікуваний вивід
        String expectedOutput = "Інформація про букет:\r\nКвіти:\r\n" +
                "1. Троянда (Ціна: 10.0, Свіжість: 5, Довжина стебла: 40)\r\n" +
                "2. Лілія (Ціна: 15.0, Свіжість: 7, Довжина стебла: 50)\r\n" +
                "Аксесуари:\r\n" +
                "1. Аксесуар 'Стрічка' (Ціна: 5.0 грн)";
        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }
}
