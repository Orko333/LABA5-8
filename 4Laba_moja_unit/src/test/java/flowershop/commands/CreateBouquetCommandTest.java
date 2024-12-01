package flowershop.commands;

import flowershop.models.Bouquet;
import flowershop.models.Flower;
import flowershop.models.Accessory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static flowershop.models.Flower.FlowerType.*;

class CreateBouquetCommandTest {
    private Bouquet bouquet;
    private CreateBouquetCommand command;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        bouquet = new Bouquet();

        // Перехоплюємо консольний вивід
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void testExecuteCreateBouquet() {
        // Симулюємо введення для додавання квітів і аксесуарів
        String input = "1\r\n100.0\r\n8\r\n40\r\n2\r\n200.0\r\n10\r\n50\r\n4\r\n1\r\n50.0\r\n4\r\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        command = new CreateBouquetCommand(bouquet);
        command.execute();

        // Перевіряємо, що букет був успішно створений
        String expectedOutput = "\n" +
                "Створення нового букету\n" +
                "\n" +
                "Додавання квітів до букету:\n" +
                "1. Додати троянду\n" +
                "2. Додати тюльпан\n" +
                "3. Додати лілію\n" +
                "4. Завершити додавання квітів\n" +
                "Введіть ціну квітки (грн): Введіть рівень свіжості (1-10): Введіть довжину стебла (см): Квітку успішно додано до букету\n" +
                "\n" +
                "Додавання квітів до букету:\n" +
                "1. Додати троянду\n" +
                "2. Додати тюльпан\n" +
                "3. Додати лілію\n" +
                "4. Завершити додавання квітів\n" +
                "Введіть ціну квітки (грн): Введіть рівень свіжості (1-10): Введіть довжину стебла (см): Квітку успішно додано до букету\n" +
                "\n" +
                "Додавання квітів до букету:\n" +
                "1. Додати троянду\n" +
                "2. Додати тюльпан\n" +
                "3. Додати лілію\n" +
                "4. Завершити додавання квітів\n" +
                "\n" +
                "Додавання аксесуарів до букету:\n" +
                "1. Додати стрічку\n" +
                "2. Додати упаковку\n" +
                "3. Додати листівку\n" +
                "4. Завершити додавання аксесуарів\n" +
                "Введіть ціну аксесуара (грн): Аксесуар успішно додано до букету\n" +
                "\n" +
                "Додавання аксесуарів до букету:\n" +
                "1. Додати стрічку\n" +
                "2. Додати упаковку\n" +
                "3. Додати листівку\n" +
                "4. Завершити додавання аксесуарів\n" +
                "\n" +
                "Букет створено успішно!\n" +
                "Квіти:\n" +
                "1. Троянда (Ціна: 100.0, Свіжість: 8, Довжина стебла: 40)\n" +
                "2. Тюльпан (Ціна: 200.0, Свіжість: 10, Довжина стебла: 50)\n" +
                "Аксесуари:\n" +
                "1. Аксесуар 'Стрічка' (Ціна: 50.0 грн)\n";

        assertEquals(expectedOutput.trim(), outputStreamCaptor.toString().trim().replace("\r",""));
    }
}
