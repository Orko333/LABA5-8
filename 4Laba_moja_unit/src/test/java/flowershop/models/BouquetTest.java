package flowershop.models;

import flowershop.models.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static flowershop.models.Flower.FlowerType.ROSE;
import static flowershop.models.Flower.FlowerType.TULIP;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

class BouquetTest {

    private Bouquet bouquet;
    private Flower rose;
    private Flower tulip;
    private Accessory ribbon;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();


    @BeforeEach
    void setUp() {
        bouquet = new Bouquet();
        rose = new Flower(ROSE,50.0, 8, 30);
        tulip = new Flower(TULIP,40.0, 9, 25);
        ribbon = new Accessory("Рибон", 10.0);
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void testAddFlower() {
        bouquet.addFlower(rose);
        bouquet.addFlower(tulip);

        assertEquals(2, bouquet.getFlowers().size(), "Невірна кількість квітів у букеті");
        assertTrue(bouquet.getFlowers().contains(rose), "Роза не додана до букета");
        assertTrue(bouquet.getFlowers().contains(tulip), "Тюльпан не доданий до букета");
    }

    @Test
    void testAddAccessory() {
        bouquet.addAccessory(ribbon);

        assertEquals(1, bouquet.getAccessories().size(), "Невірна кількість аксесуарів у букеті");
        assertTrue(bouquet.getAccessories().contains(ribbon), "Аксесуар не доданий до букета");
    }


    @Test
    void testRemoveFlower() {
        bouquet.addFlower(rose);
        bouquet.addFlower(tulip);

        Flower removedFlower = bouquet.removeFlower(0);

        assertEquals(rose, removedFlower, "Невірно видалена квітка");
        assertEquals(1, bouquet.getFlowers().size(), "Кількість квітів не оновлена після видалення");
    }

    @Test
    void testClear() {
        bouquet.addFlower(rose);
        bouquet.addFlower(tulip);
        bouquet.addAccessory(ribbon);

        bouquet.clear();

        assertTrue(bouquet.getFlowers().isEmpty(), "Квіти не були очищені");
        assertTrue(bouquet.getAccessories().isEmpty(), "Аксесуари не були очищені");
    }

    @Test
    void testDisplayContents_EmptyBouquet() {
        bouquet.displayContents();

        String expectedOutput = "Квіти:\r\nАксесуари:\r\n";
        assertEquals(expectedOutput, outputStreamCaptor.toString(), "Виведення для порожнього букета неправильне");
    }

    @Test
    void testDisplayContents_WithFlowersAndAccessories() {
        // Додаємо квіти та аксесуари
        bouquet.addFlower(new Flower(Flower.FlowerType.ROSE, 50.0, 90, 35));
        bouquet.addFlower(new Flower(Flower.FlowerType.LILY, 60.0, 80, 40));
        bouquet.addAccessory(new Accessory("Ваза", 100.0));
        bouquet.addAccessory(new Accessory("Пакет", 30.0));

        bouquet.displayContents();

        String expectedOutput = "Квіти:\r\n" +
                "1. Троянда (Ціна: 50.0, Свіжість: 90, Довжина стебла: 35)\r\n" +
                "2. Лілія (Ціна: 60.0, Свіжість: 80, Довжина стебла: 40)\r\n" +
                "Аксесуари:" +
                "\r\n1. Аксесуар 'Ваза' (Ціна: 100.0 грн)\r\n" +
                "2. Аксесуар 'Пакет' (Ціна: 30.0 грн)\r\n";
        assertEquals(expectedOutput, outputStreamCaptor.toString(), "Виведення для букета з квітами та аксесуарами неправильне");
    }
}
