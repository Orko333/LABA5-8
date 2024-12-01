package flowershop.commands;

import flowershop.models.Bouquet;
import flowershop.models.Flower;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static flowershop.models.Flower.FlowerType.*;

import static org.junit.jupiter.api.Assertions.*;

class AddFlowerCommandTest {
    private Bouquet bouquet;
    private AddFlowerCommand command;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        bouquet = new Bouquet();

        // Перехоплюємо консольний вивід
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void testExecuteAddFlower() {
        // Симулюємо введення для додавання троянди
        String input = "1\n50,0\n8\n30\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        command = new AddFlowerCommand(bouquet);
        command.execute();

        // Перевіряємо, що квітка була додана
        assertEquals(1, bouquet.getFlowers().size());
        Flower addedFlower = bouquet.getFlowers().get(0);
        assertEquals(ROSE, addedFlower.getType());
        assertEquals(50.0, addedFlower.getPrice());
        assertEquals(8, addedFlower.getFreshness());
        assertEquals(30, addedFlower.getStemLength());

        // Перевіряємо виведення
        String expectedOutput = "\n1. Троянда\n" +
                "2. Тюльпан\n" +
                "3. Лілія\n" +
                "Введіть ціну квітки (грн): Введіть свіжість квітки (1-10): Введіть довжину стебла (см): " +
                "Квітку успішно додано до букету.";
        assertEquals(expectedOutput.trim(), outputStreamCaptor.toString().trim().replace("\r",""));
    }

    @Test
    void testExecuteAddFlowerInvalidChoice() {
        // Симулюємо введення для некоректного вибору
        String input = "4\n50,0\n8\n30\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        command = new AddFlowerCommand(bouquet);
        command.execute();

        // Перевіряємо, що квітка не була додана
        assertEquals(0, bouquet.getFlowers().size());

        // Перевіряємо виведення
        String expectedOutput = "\n1. Троянда\n" +
                "2. Тюльпан\n" +
                "3. Лілія\n" +
                "Введіть ціну квітки (грн): Введіть свіжість квітки (1-10): Введіть довжину стебла (см): " +
                "Невірний вибір.";
        assertEquals(expectedOutput.trim(), outputStreamCaptor.toString().trim().replace("\r",""));
    }


}
