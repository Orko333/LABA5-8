package flowershop.commands;

import flowershop.models.Bouquet;
import flowershop.models.Flower;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FindFlowersByLengthCommand implements Command {
    private Bouquet bouquet;
    private Scanner scanner;

    public FindFlowersByLengthCommand(Bouquet bouquet) {
        this.bouquet = bouquet;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void execute() {
        System.out.print("Введіть мінімальну довжину стебла (см): ");
        int minLength = scanner.nextInt();
        System.out.print("Введіть максимальну довжину стебла (см): ");
        int maxLength = scanner.nextInt();

        List<Flower> flowers = bouquet
                .getFlowers()
                .stream()
                .filter(f -> f.getStemLength() >= minLength && f.getStemLength() <= maxLength)
                .collect(Collectors.toList());

        System.out.println("\nКвіти з заданою довжиною стебла:");
        flowers.forEach(System.out::println);
    }
}
