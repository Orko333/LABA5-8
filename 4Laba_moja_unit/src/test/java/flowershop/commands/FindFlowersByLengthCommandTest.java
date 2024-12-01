package flowershop.commands;

import flowershop.models.Bouquet;
import flowershop.models.Flower;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindFlowersByLengthCommandTest {
    private Bouquet bouquet;
    private FindFlowersByLengthCommand command;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        bouquet = new Bouquet();

        // Додаємо квіти з різною довжиною стебла
        bouquet.addFlower(new Flower(Flower.FlowerType.ROSE, 10.0, 5, 40));
        bouquet.addFlower(new Flower(Flower.FlowerType.LILY, 15.0, 7, 50));
        bouquet.addFlower(new Flower(Flower.FlowerType.TULIP, 8.0, 3, 30));

        // Перехоплюємо консольний вивід
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void testExecuteFindFlowersByLength() {
        // Симулюємо введення мінімальної довжини 30 і максимальної довжини 50
        System.setIn(new ByteArrayInputStream("30\n50\n".getBytes()));
        command = new FindFlowersByLengthCommand(bouquet);

        command.execute();

        // Очікуваний вивід
        String expectedOutput = "Введіть мінімальну довжину стебла (см): Введіть максимальну довжину стебла (см): \n" +
                "Квіти з заданою довжиною стебла:\r\n" +
                "Троянда (Ціна: 10.0, Свіжість: 5, Довжина стебла: 40)\r\n" +
                "Лілія (Ціна: 15.0, Свіжість: 7, Довжина стебла: 50)\r\n" +
                "Тюльпан (Ціна: 8.0, Свіжість: 3, Довжина стебла: 30)\r\n";
        assertEquals(expectedOutput.trim(), outputStreamCaptor.toString().trim());
    }

    @Test
    void testExecuteFindFlowersByInvalidLength() {
        // Симулюємо введення мінімальної довжини 60 і максимальної довжини 100 (не існує таких квітів)
        System.setIn(new ByteArrayInputStream("60\n100\n".getBytes()));
        command = new FindFlowersByLengthCommand(bouquet);

        command.execute();

        // Очікуваний вивід
        String expectedOutput = "Введіть мінімальну довжину стебла (см): Введіть максимальну довжину стебла (см): \n" +
                "Квіти з заданою довжиною стебла:";
        assertEquals(expectedOutput.trim(), outputStreamCaptor.toString().trim());
    }
}
