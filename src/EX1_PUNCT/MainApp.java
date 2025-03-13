package EX1_PUNCT;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    static Scanner scanner;

    static {
        try {
            scanner = new Scanner(new File("data/in.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        List<Parabola> parabolas = new ArrayList<Parabola>();
        while (scanner.hasNext()) {
            String[] parsedString = scanner.nextLine().split(" ");
//            parabolas.add(new Parabola(i->Integer.parseInt(parsedString[i])));
            parabolas.add(new Parabola(Integer.parseInt(parsedString[0]), Integer.parseInt(parsedString[1]), Integer.parseInt(parsedString[2])));
        }

        for (int i = 0; i < parabolas.size(); i++) {
            System.out.println("Parabola " + (i + 1) + ": " + parabolas.get(i)+"\nVarf: " + parabolas.get(i).getVarf());
        }
        System.out.println("Mijloc seg. care uneste vf. parabolelor 1 si 2:\nSTATIC: "+Parabola.getMijloc(parabolas.get(0), parabolas.get(1))+"\nNON_STATIC: "+parabolas.get(0).getMijloc(parabolas.get(1)));
        System.out.println("Lungime seg.:\nSTATIC: "+ Parabola.getLungimeSegment(parabolas.get(0), parabolas.get(1))+"\nNON STATIC: "+ parabolas.get(0).getLungimeSegment(parabolas.get(1)));
    }
}
