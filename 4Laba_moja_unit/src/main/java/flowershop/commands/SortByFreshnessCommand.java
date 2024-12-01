package flowershop.commands;

import flowershop.models.Bouquet;
import flowershop.models.Flower;

import java.util.Comparator;

public class SortByFreshnessCommand implements Command {
    private Bouquet bouquet;

    public SortByFreshnessCommand(Bouquet bouquet) {
        this.bouquet = bouquet;
    }

    @Override
    public void execute() {
        Bouquet flowersCopy = new Bouquet(bouquet.getFlowers());
        flowersCopy.getFlowers().sort(Comparator.comparingInt(Flower::getFreshness).reversed());
        System.out.println("\nКвіти відсортовані за свіжістю:");
        flowersCopy.displayContents();
    }
}
