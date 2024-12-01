package flowershop.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SettingsManagerTest {

    private SettingsManager settingsManager;

    @BeforeEach
    void setUp() {
        settingsManager = new SettingsManager();
        settingsManager.loadSettings();
    }

    @Test
    void testGetUsername() {
        assertEquals("a7654837383@gmail.com", settingsManager.getUsername());
    }

    @Test
    void testGetPassword() {
        // Тестуємо повернення значення паролю
        assertEquals("tfancgscidbdifsa", settingsManager.getPassword());
    }

    @Test
    void testGetRecipient() {
        // Тестуємо отримання отримувача
        assertEquals("orestivanchuk06@gmail.com", settingsManager.getRecipient());
    }
}
