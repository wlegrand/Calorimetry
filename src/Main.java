import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        get_information();
    }

    static void get_information() {
        ArrayList<Substance> allSubstance = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of substances that you want:");
        int number_of_substance = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < number_of_substance; i++) {
            //user input
            System.out.println("Enter the name of the " + (i + 1) + " substance");
            String name = sc.next().toLowerCase();
            sc.nextLine();

            System.out.println("Enter the mass for the " + (i + 1) + " substance");
            double mass = sc.nextDouble();
            sc.nextLine();

            System.out.println("Enter the initial temperature for the " + (i + 1) + " substance");
            double temp_init = sc.nextDouble();

            //read_file
            String file = "Substances.txt";

            try {
                Scanner fileReader = new Scanner(new File(file));
                boolean substanceFound = false;

                while (fileReader.hasNextLine()) {
                    String line = fileReader.nextLine();
                    String[] values = line.split(",");

                    String substanceName = values[0].trim();
                    if (substanceName.equalsIgnoreCase(name)) {
                        double chal_mass = Double.parseDouble(values[1].trim());
                        double LF = Double.parseDouble(values[2].trim());
                        double LV = Double.parseDouble(values[3].trim());
                        double TF = Double.parseDouble(values[4].trim());
                        double TE = Double.parseDouble(values[5].trim());

                        Substance substance = new Substance(name, mass, temp_init, chal_mass, LF, LV, TF, TE);
                        allSubstance.add(substance);
                        substanceFound = true;
                        break;
                    }
                }

                if (!substanceFound) {
                    System.out.println("Substance not found in the file: " + name);
                }

            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + file);
            }


        }
        for (Substance j : allSubstance) {
            System.out.println(j.toString());
        }
    }
}