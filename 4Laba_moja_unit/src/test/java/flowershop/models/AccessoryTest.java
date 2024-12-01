package flowershop.models;

import flowershop.models.Accessory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccessoryTest {

    @Test
    void testConstructorValidPrice() {
        // Створюємо аксесуар з коректною ціною
        Accessory accessory = new Accessory("Шпилька", 50.0);

        // Перевіряємо, чи коректно встановлена ціна та назва
        assertEquals("Шпилька", accessory.getName(), "Невірна назва аксесуара");
        assertEquals(50.0, accessory.getPrice(), "Невірна ціна аксесуара");
    }

    @Test
    void testConstructorNegativePrice() {
        // Перевіряємо, чи кидається виняток при від'ємній ціні
        assertThrows(IllegalArgumentException.class, () -> new Accessory("Шпилька", -50.0),
                "Ціна аксесуара не може бути від'ємною");
    }

    @Test
    void testGetName() {
        // Створюємо аксесуар і перевіряємо правильність гетера для назви
        Accessory accessory = new Accessory("Шпилька", 50.0);
        assertEquals("Шпилька", accessory.getName(), "Невірна назва аксесуара");
    }

    @Test
    void testGetPrice() {
        // Створюємо аксесуар і перевіряємо правильність гетера для ціни
        Accessory accessory = new Accessory("Шпилька", 50.0);
        assertEquals(50.0, accessory.getPrice(), "Невірна ціна аксесуара");
    }

    @Test
    void testToString() {
        // Створюємо аксесуар і перевіряємо метод toString()
        Accessory accessory = new Accessory("Шпилька", 50.0);
        String expectedString = "Аксесуар 'Шпилька' (Ціна: 50.0 грн)";
        assertEquals(expectedString, accessory.toString(), "Метод toString() працює неправильно");
    }
}
