import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //ukol1
        /*System.out.println("Zadej titulek stranky");
        String titulek = sc.nextLine();
        System.out.println("Zadej nazev souboru");
        String nazev = sc.nextLine();
        Path soubor = Path.of("data", titulek);
        Path odstavce = Path.of("data", "odstavce");

        try (BufferedReader reader = Files.newBufferedReader(odstavce)){
            String radek;
            while ((radek = reader.readLine()) != null) {
                String[] cols = radek.split(".");

                String odtavec1 = cols[0].trim();
                String odtavec2 = cols[1].trim();
                String odtavec3 = cols[2].trim();


                List<String> radky = new java.util.ArrayList<>(List.of());
                radky.add("<!DOCTYPE html>");
                radky.add("<html>");
                radky.add("<head>");
                radky.add("<title>"+titulek+"</title>");
                radky.add("/head");
                radky.add("<body>");
                radky.add("<h1>"+titulek+"</h1>");
                radky.add("<p>"+odtavec1+"</p>");
                radky.add("<p>"+odtavec2+"</p>");
                radky.add("<p>"+odtavec3+"</p>");

                radky.add("</body>");
                radky.add("</html>");

                Files.write(soubor, radky);


            }




        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
        //ukol2
        Path cestaVstup = Path.of("data", "slova_opravene.txt");
        Path cestaVystup = Path.of("data", "statistika.txt");
        try {
            List<String> slova = Files.readAllLines(cestaVstup);
            if (slova.isEmpty()) {
                System.out.println("Soubor je prázdný.");
                return;
            }

            int pocetSlov = slova.size();
            long celkovaDelka = 0;
            int maxDelka = 0;
            int minDelka = 9999999;

            for (String s : slova) {
                int delka = s.length();
                celkovaDelka += delka;

                if (delka > maxDelka) {
                    maxDelka = delka;
                }

                if (delka < minDelka) {
                    minDelka = delka;
                }
            }

            double prumernaDelka = (double) celkovaDelka / pocetSlov;

            String nejdelsi = "";
            String nejkratsi = "";
            for (String s : slova) {
                if (s.length() == maxDelka) {
                    nejdelsi += " " + s+", ";
                }
                else if (s.length() == minDelka) {
                    nejkratsi += " " + s+", ";
                }
            }

            Files.writeString(cestaVystup, "Nejdelší slova: " + nejdelsi + ". Nejkratší: " + nejkratsi + ". Průměrná délka slova: "+prumernaDelka);
            System.out.println("Výpis proběhl úspěšně");



        } catch (IOException e) {
            System.err.println("Chyba" + e.getMessage());
            throw new RuntimeException(e);
        }


        //ukol3
        /*Path cestaZakazana = Path.of("data", "zakazana_slova.txt");
        Path cestaKontrola = Path.of("data", "text_ke_kontrole.txt");
        Path cestaVystup = Path.of("data", "text_cenzura.txt");

        try {
            List<String> zakazanaSlova = Files.readAllLines(cestaZakazana);

            String text = Files.readString(cestaKontrola).toLowerCase();
            for (String zakazaneSlovo : zakazanaSlova) {
                String hvezdicky = "";

                zakazaneSlovo = zakazaneSlovo.trim().toLowerCase();

                if (zakazaneSlovo.isEmpty()) {
                    continue;
                }

                for (int i = 0; i < zakazaneSlovo.length(); i++) {
                    hvezdicky += "*";
                }
                text = text.replaceAll(zakazaneSlovo, hvezdicky);
            }

            Files.writeString(cestaVystup, text);
            System.out.println("Cenzura dokončena.");

        } catch (IOException e) {
            System.err.println("Chyba" + e.getMessage());
        }*/

    }
}
