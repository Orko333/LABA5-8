package flowershop.models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Bouquet {
    private List<Flower> flowers = new ArrayList<>();
    private List<Accessory> accessories = new ArrayList<>();

    public Bouquet() {
        this.flowers = flowers;
    }
    public Bouquet(List<Flower> flowers) {
        this.flowers = flowers;
    }

    public void addFlower(Flower flower) { flowers.add(flower); }
    public void addAccessory(Accessory accessory) { accessories.add(accessory); }
    public void clear() {
        flowers.clear();
        accessories.clear();
    }

    @Override
    public String toString() {
        return "Bouquet{" +
                "flowers=" + flowers +
                ", accessories=" + accessories +
                '}';
    }

    public void displayContents() {
        System.out.println("Квіти:");
        IntStream.range(0, flowers.size())
                .forEach(i -> System.out.println((i + 1) + ". " + flowers.get(i)));

        System.out.println("Аксесуари:");
        IntStream.range(0, accessories.size())
                .forEach(i -> System.out.println((i + 1) + ". " + accessories.get(i)));
    }

    public List<Flower> getFlowers() { return flowers; }

    public Flower removeFlower(int index) { return flowers.remove(index); }

    public List<Accessory> getAccessories() {
        return accessories;
    }
}