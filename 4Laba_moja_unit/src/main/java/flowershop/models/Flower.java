package flowershop.models;

public class Flower {
    private final FlowerType type;
    private final double price;
    private final int freshness;
    private final int stemLength;

    public enum FlowerType {
        ROSE("Троянда"),
        LILY("Лілія"),
        TULIP("Тюльпан");

        private final String name;

        FlowerType(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public Flower(FlowerType type, double price, int freshness, int stemLength) {
        if (price < 0) {
            throw new IllegalArgumentException("Ціна квітки не може бути від'ємною");
        }
        if (freshness < 0 || freshness > 100) {
            throw new IllegalArgumentException("Свіжість квітки має бути в діапазоні від 0 до 100");
        }
        if (stemLength < 0) {
            throw new IllegalArgumentException("Довжина стебла квітки не може бути від'ємною");
        }

        this.type = type;
        this.price = price;
        this.freshness = freshness;
        this.stemLength = stemLength;
    }

    public FlowerType getType() {
        return type;
    }

    public String getName() {
        return type.getName();
    }

    public double getPrice() {
        return price;
    }

    public int getFreshness() {
        return freshness;
    }

    public int getStemLength() {
        return stemLength;
    }

    @Override
    public String toString() {
        return getName() + " (Ціна: " + price + ", Свіжість: " + freshness + ", Довжина стебла: " + stemLength + ")";
    }
}