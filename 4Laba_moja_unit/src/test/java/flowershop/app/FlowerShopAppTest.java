package flowershop.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

class FlowerShopAppTest {

    private FlowerShopApp app;

    @BeforeEach
    void setUp() {
        app = new FlowerShopApp();  // Створюємо екземпляр FlowerShopApp
    }

    @Test
    void testFlowerShopAppMain() {
        // Тестуємо чи додаток працює без помилок
        String input = "8\n";  // Введення для завершення тесту
        InputStream systemInBackup = System.in;  // Резервне збереження System.in
        System.setIn(new ByteArrayInputStream(input.getBytes()));  // Перенаправлення вводу

        assertDoesNotThrow(() -> app.main(new String[0]));  // Перевірка, що програма виконується без помилок

        System.setIn(systemInBackup);  // Відновлення стандартного вводу
    }

    @Test
    void testMenuInteraction() {
        // Перевіряємо ініціалізацію меню
        String input = "8\n";  // Введення для завершення тесту
        InputStream systemInBackup = System.in;  // Резервне збереження System.in
        System.setIn(new ByteArrayInputStream(input.getBytes()));  // Перенаправлення вводу

        assertDoesNotThrow(() -> FlowerShopApp.main(new String[]{}));  // Тестуємо виконання

        System.setIn(systemInBackup);  // Відновлення стандартного вводу
    }
}
