/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konvertorvaluta;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Nemanja
 */
public class KonvertorValuta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Valuta> valute = new ArrayList<>();
        valute.add(new Valuta("Euro", "EUR", 117.231));
        valute.add(new Valuta("Americki dolar", "USD", 105.771));
        valute.add(new Valuta("Svajcarski franak", "CHF", 118.672));
        valute.add(new Valuta("Britanska funta", "GBP", 131.917));
        valute.add(new Valuta("BIH konvertabilna marka", "BAM", 59.830));

        program:
        while (true) {
            System.out.println("--- Dobrosli u konvertor valuta --- \nUnesite cifru ispred opcije za start");
            System.out.println("1 - Konvertuj iz dinara u devize");
            System.out.println("2 - Konvertuj iz deviza u dinare");
            System.out.println("3 - Izadji iz programa");
            System.out.print("Zelim opciju: ");
            int opcija = sc.nextInt();

            switch (opcija) {
                case (1):
                    System.out.println("-------------------");
                    System.out.print("Unesite iznos dinara: ");
                    double dinar = sc.nextDouble();

                    String oznaka;
                    do {
                        System.out.println("-------------------");
                        System.out.println("Unesite jednu od oznaka deviza sa spiska:");

                        for (int i = 0; i < valute.size(); i++) {
                            System.out.println((i + 1) + ". " + valute.get(i).toString());
                        }

                        System.out.print("Oznaka: ");
                        oznaka = sc.next();
                    } while (!Valuta.proveriOznaku(oznaka, valute));

                    Valuta val = null;
                    for (int i = 0; i < valute.size(); i++) {
                        if (valute.get(i).getOznaka().equalsIgnoreCase(oznaka)) {
                            val = valute.get(i);
                        }
                    }

                    System.out.println("-------------------");
                    System.out.println("Vas iznos je: " + Valuta.konvertujUDevizu(dinar, val) + " " + val.getOznaka());
                    System.out.println("-------RESET-------");

                    break;
                case (2):
                    String oznaka1;
                    do {
                        System.out.println("-------------------");
                        System.out.println("Unesite jednu od oznaka deviza sa spiska:");

                        for (int i = 0; i < valute.size(); i++) {
                            System.out.println((i + 1) + ". " + valute.get(i).toString());
                        }

                        System.out.print("Oznaka: ");
                        oznaka1 = sc.next();
                    } while (!Valuta.proveriOznaku(oznaka1, valute));

                    System.out.println("-------------------");
                    System.out.print("Unesite iznos deviza: ");
                    double dinar1 = sc.nextDouble();

                    Valuta val1 = null;
                    for (int i = 0; i < valute.size(); i++) {
                        if (valute.get(i).getOznaka().equalsIgnoreCase(oznaka1)) {
                            val = valute.get(i);
                        }
                    }

                    System.out.println("-------------------");
                    System.out.println("Vas iznos je: " + Valuta.konvertujUDinare(dinar1, val1) + " DIN");
                    System.out.println("-------RESET-------");
                    break;
                case (3):
                    break program;
                default:
                    System.out.println("-------------------");
                    System.out.println("Pogresan unos!!!");
                    System.out.println("-------RESET-------");
            }
        }
    }

}
