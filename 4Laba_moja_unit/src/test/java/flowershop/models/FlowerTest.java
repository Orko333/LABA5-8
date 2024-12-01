package flowershop.models;

import flowershop.models.Flower;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlowerTest {

    private Flower rose;
    private Flower lily;

    @BeforeEach
    void setUp() {
        // Створюємо квіти
        rose = new Flower(Flower.FlowerType.ROSE, 50.0, 90, 35);
        lily = new Flower(Flower.FlowerType.LILY, 60.0, 80, 40);
    }

    @Test
    void testFlowerConstructor_ValidValues() {
        assertNotNull(rose, "Троянда не була створена");
        assertEquals(Flower.FlowerType.ROSE, rose.getType(), "Тип квітки не правильний для Троянди");
        assertEquals("Троянда", rose.getName(), "Ім'я квітки не правильне для Троянди");
        assertEquals(50.0, rose.getPrice(), "Ціна троянди неправильна");
        assertEquals(90, rose.getFreshness(), "Свіжість троянди неправильна");
        assertEquals(35, rose.getStemLength(), "Довжина стебла троянди неправильна");

        assertNotNull(lily, "Лілія не була створена");
        assertEquals(Flower.FlowerType.LILY, lily.getType(), "Тип квітки не правильний для Лілії");
        assertEquals("Лілія", lily.getName(), "Ім'я квітки не правильне для Лілії");
        assertEquals(60.0, lily.getPrice(), "Ціна лілії неправильна");
        assertEquals(80, lily.getFreshness(), "Свіжість лілії неправильна");
        assertEquals(40, lily.getStemLength(), "Довжина стебла лілії неправильна");
    }

    @Test
    void testFlowerConstructor_InvalidPrice() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            new Flower(Flower.FlowerType.ROSE, -10.0, 90, 35); // Невірна ціна
        });
        assertEquals("Ціна квітки не може бути від'ємною", thrown.getMessage(), "Невірне повідомлення про помилку ціни");
    }

    @Test
    void testFlowerConstructor_InvalidFreshness() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            new Flower(Flower.FlowerType.ROSE, 50.0, -5, 35); // Невірна свіжість
        });
        assertEquals("Свіжість квітки має бути в діапазоні від 0 до 100", thrown.getMessage(), "Невірне повідомлення про помилку свіжості");

        thrown = assertThrows(IllegalArgumentException.class, () -> {
            new Flower(Flower.FlowerType.ROSE, 50.0, 105, 35); // Невірна свіжість
        });
        assertEquals("Свіжість квітки має бути в діапазоні від 0 до 100", thrown.getMessage(), "Невірне повідомлення про помилку свіжості");
    }

    @Test
    void testFlowerConstructor_InvalidStemLength() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            new Flower(Flower.FlowerType.ROSE, 50.0, 90, -5); // Невірна довжина стебла
        });
        assertEquals("Довжина стебла квітки не може бути від'ємною", thrown.getMessage(), "Невірне повідомлення про помилку довжини стебла");
    }

    @Test
    void testGetName() {
        assertEquals("Троянда", rose.getName(), "Ім'я троянди неправильне");
        assertEquals("Лілія", lily.getName(), "Ім'я лілії неправильне");
    }

    @Test
    void testGetType() {
        assertEquals(Flower.FlowerType.ROSE, rose.getType(), "Тип квітки для Троянди неправильний");
        assertEquals(Flower.FlowerType.LILY, lily.getType(), "Тип квітки для Лілії неправильний");
    }

    @Test
    void testToString() {
        String expectedRoseString = "Троянда (Ціна: 50.0, Свіжість: 90, Довжина стебла: 35)";
        String expectedLilyString = "Лілія (Ціна: 60.0, Свіжість: 80, Довжина стебла: 40)";
        assertEquals(expectedRoseString, rose.toString(), "Невірне відображення інформації для Троянди");
        assertEquals(expectedLilyString, lily.toString(), "Невірне відображення інформації для Лілії");
    }
}
