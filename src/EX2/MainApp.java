package EX2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    static Scanner scanner;

    static {
        try {
            scanner = new Scanner(new File("data/produse.csv"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static Scanner keyboard_scanner = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        PrintStream flux_out = new PrintStream("data/exported.txt");
        List<Produs> products = new ArrayList<Produs>();
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] Collumn = line.split(",");
            products.add(new Produs(Collumn[0], Float.parseFloat(Collumn[1]), Integer.parseInt(Collumn[2]), LocalDate.parse(Collumn[3])));
        }
        boolean isRunning = true;
        while (isRunning) {
            printMenu();
            int choice = keyboard_scanner.nextInt();
//            keyboard_scanner.next();
            switch (choice) {
                case 1:
                    displayALL(products);
                    break;
                case 2:
                    displayExpired(products);
                    break;
                case 3:
                    SellProduct(products, keyboard_scanner);
                    break;
                case 4:
                    displayMinimalPriceProduct(products);
                    break;
                case 5:
                    exportUnderQuantity(products, keyboard_scanner, flux_out);
                    break;
                case 0:
                    isRunning = false;
                    break;
            }

        }
    }

    private static void printMenu() {
        System.out.println("0.Iesire\n1.Afisare lista produse\n2.Afisare produse expirate");
        System.out.println("3.Vanzare produs\n4.Afisare produse cu pret minim\n5.Salvare in fisier produse sub cantitatea dorita");
    }

    private static void displayExpired(List<Produs> produse) {
        for (Produs produs : produse) {
            if (produs.checkExpired()) System.out.println(produs.toString());
        }
    }

    private static void displayALL(List<Produs> produse) {
        for (Produs produs : produse) {
            System.out.println(produs.toString());
        }
    }

    private static void SellProduct(List<Produs> produse, Scanner scanner) {
        System.out.println("Dati nume produs: ");
        String nume = scanner.next();
        System.out.println("Dati cantitate vanduta: ");
        int quantity = scanner.nextInt();
        for (Produs produs : produse) {
            if (produs.getProductName().equals(nume)) {
                if (produs.getQuantity() >= quantity) {
                    produs.setQuantity(produs.getQuantity() - quantity);
                    produs.incrementSales(quantity);
                    System.out.println("Vanzare produs: " + produs.toString());
                    break;
                } else System.out.println("Nu exista in stoc");
                if (produs.getQuantity() == 0) {
                    produse.remove(produs);
                    break;
                }
            } else {
                System.out.println("Nu exista");
                break;
            }
        }
    }

    private static void displayMinimalPriceProduct(List<Produs> produse) {
        float minPrice = Float.MAX_VALUE;
        for (Produs produs : produse) {
            minPrice = Math.min(minPrice, produs.getPrice());
        }
//        produse.forEach(i->(minPrice=Math.min(minPrice,i.getPrice())));

        for (Produs produs : produse) {
            if (produs.getPrice() == minPrice) {
                System.out.println(produs.toString());
            }
        }
    }

    private static void exportUnderQuantity(List<Produs> produse, Scanner scanner, PrintStream flux_out) {
        System.out.println("Dati cantitate");
        int quantity = scanner.nextInt();
        for (Produs produs : produse) {
            if (produs.getQuantity() < quantity) {
                flux_out.println(produs.toString());
            }
        }
    }


}
