package flowershop.commands;

import flowershop.models.Accessory;
import flowershop.models.Bouquet;
import flowershop.models.Flower;

public class ShowBouquetPriceCommand implements Command {
    private Bouquet bouquet;

    public ShowBouquetPriceCommand(Bouquet bouquet) {
        this.bouquet = bouquet;
    }

    @Override
    public void execute() {
        double flowersPrice = bouquet.getFlowers().stream().mapToDouble(Flower::getPrice).sum();
        double accessoriesPrice = bouquet.getAccessories().stream().mapToDouble(Accessory::getPrice).sum();
        System.out.printf("\nЗагальна вартість букету: %.2f грн%n", flowersPrice+accessoriesPrice);
    }

}
