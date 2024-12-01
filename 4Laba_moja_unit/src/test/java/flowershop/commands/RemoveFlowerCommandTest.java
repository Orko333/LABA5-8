package flowershop.commands;

import flowershop.models.Bouquet;
import flowershop.models.Flower;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoveFlowerCommandTest {
    private Bouquet bouquet;
    private RemoveFlowerCommand command;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();


    @BeforeEach
    void setUp() {
        bouquet = new Bouquet();

        // Додаємо квіти для тестування
        bouquet.addFlower(new Flower(Flower.FlowerType.ROSE, 10.0, 5, 40));
        bouquet.addFlower(new Flower(Flower.FlowerType.LILY, 15.0, 7, 50));

        // Перехоплюємо консольний вивід
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void testExecuteRemoveFlowerWithValidIndex() {
        // Симулюємо введення індексу 0 для видалення першої квітки
        System.setIn(new ByteArrayInputStream("0\r\n".getBytes()));
        command = new RemoveFlowerCommand(bouquet);

        command.execute();

        // Очікуваний вивід
        String expectedOutput = "\r\nОберіть квітку для видалення за індексом:" +
                "\r\nКвіти:" +
                "\r\n1. Троянда (Ціна: 10.0, Свіжість: 5, Довжина стебла: 40)" +
                "\r\n2. Лілія (Ціна: 15.0, Свіжість: 7, Довжина стебла: 50)\r\nАксесуари:" +
                "\r\nВведіть індекс квітки: " +
                "Квітку видалено: Лілія (Ціна: 15.0, Свіжість: 7, Довжина стебла: 50)";
        assertEquals(expectedOutput.trim(), outputStreamCaptor.toString().trim());
    }

    @Test
    void testExecuteRemoveFlowerWithInvalidIndex() {
        // Симулюємо введення індексу 5 (некоректний індекс)
        System.setIn(new ByteArrayInputStream("5\r\n".getBytes()));
        command = new RemoveFlowerCommand(bouquet);

        command.execute();

        // Очікуваний вивід
        String expectedOutput = "Оберіть квітку для видалення за індексом:\r\n" +
                "Квіти:\r\n" +
                "1. Троянда (Ціна: 10.0, Свіжість: 5, Довжина стебла: 40)\r\n" +
                "2. Лілія (Ціна: 15.0, Свіжість: 7, Довжина стебла: 50)\r\n" +
                "Аксесуари:\r\n" +
                "Введіть індекс квітки: Невірний індекс.";
        assertEquals(expectedOutput.trim(), outputStreamCaptor.toString().trim());
    }
}
