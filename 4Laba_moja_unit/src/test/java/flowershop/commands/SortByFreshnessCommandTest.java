package flowershop.commands;

import flowershop.models.Bouquet;
import flowershop.models.Flower;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static flowershop.models.Flower.FlowerType.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SortByFreshnessCommandTest {
    private Bouquet bouquet;
    private SortByFreshnessCommand command;

    @BeforeEach
    void setUp() {
        bouquet = new Bouquet();
        command = new SortByFreshnessCommand(bouquet);

        // Додаємо квіти з різною свіжістю
        bouquet.addFlower(new Flower(ROSE, 10.0, 5, 40));
        bouquet.addFlower(new Flower(LILY, 15.0, 7, 50));
        bouquet.addFlower(new Flower(TULIP, 8.0, 3, 30));
    }

    @Test
    void testExecuteSortByFreshness() {
        // Виконуємо команду сортування за свіжістю
        command.execute();

        // Перевіряємо порядок квітів після сортування
        assertEquals("Лілія", bouquet.getFlowers().get(0).getName());
        assertEquals("Троянда", bouquet.getFlowers().get(1).getName());
        assertEquals("Тюльпан", bouquet.getFlowers().get(2).getName());
    }
}
