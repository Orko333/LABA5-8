package flowershop.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FlowerShopApp {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(FlowerShopMenu.class);

        try{
        FlowerShopMenu menu = new FlowerShopMenu();
        menu.displayMenu();}
        catch (Exception e){
            logger.error("Сталася критична помилка: ", e);
        }
    }
}
