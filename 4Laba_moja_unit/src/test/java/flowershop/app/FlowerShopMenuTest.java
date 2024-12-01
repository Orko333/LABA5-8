package flowershop.app;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;


public class FlowerShopMenuTest {

    private final ByteArrayInputStream inputStreamShowBouquetInfo = new ByteArrayInputStream("4\n8\n".getBytes());
    private final ByteArrayInputStream inputStreamShowBouquetPrice = new ByteArrayInputStream("5\n8\n".getBytes());
    private final ByteArrayInputStream inputStreamSortByFreshness = new ByteArrayInputStream("6\n8\n".getBytes());
    private final ByteArrayInputStream inputStreamExit = new ByteArrayInputStream("8\n".getBytes());

    private final PrintStream originalSystemOut = System.out;
    private final InputStream originalSystemIn = System.in;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(System.out));  // Для виведення в консоль
    }

    @AfterEach
    public void tearDown() {
        System.setIn(originalSystemIn);  // Відновлюємо оригінальний ввід
        System.setOut(originalSystemOut);  // Відновлюємо оригінальний вивід
    }

    @Test
    public void testShowBouquetInfo() {
        System.setIn(inputStreamShowBouquetInfo);
        FlowerShopMenu menu = new FlowerShopMenu();
        menu.displayMenu();
    }

    @Test
    public void testShowBouquetPrice() {
        System.setIn(inputStreamShowBouquetPrice);
        FlowerShopMenu menu = new FlowerShopMenu();
        menu.displayMenu();
    }

    @Test
    public void testSortByFreshness() {
        System.setIn(inputStreamSortByFreshness);
        FlowerShopMenu menu = new FlowerShopMenu();
        menu.displayMenu();
    }

    @Test
    public void testExit() {
        System.setIn(inputStreamExit);
        FlowerShopMenu menu = new FlowerShopMenu();
        menu.displayMenu();  // Викликаємо метод, що вийде після введення "8"
    }
}
