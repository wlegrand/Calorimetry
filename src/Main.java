import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println(calculate(get_information(), 0));

    }

    static ArrayList<Substance> get_information() {
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
                    System.out.println("Please provide the following information to add the substance:");
                    System.out.print("Enter chal_mass: ");
                    double chal_mass = sc.nextDouble();
                    System.out.print("Enter LF: ");
                    double LF = sc.nextDouble();
                    System.out.print("Enter LV: ");
                    double LV = sc.nextDouble();
                    System.out.print("Enter TF: ");
                    double TF = sc.nextDouble();
                    System.out.print("Enter TE: ");
                    double TE = sc.nextDouble();

                    Substance substance = new Substance(name, mass, temp_init, chal_mass, LF, LV, TF, TE);
                    allSubstance.add(substance);

                    try (FileWriter writer = new FileWriter(file, true)) {
                        writer.write("\n" + name + ", " + chal_mass + ", " + LF + ", " + LV + ", " + TF + ", " + TE);
                    } catch (IOException e) {
                        System.out.println("Error writing to the file: " + file);
                    }
                }

            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + file);
            }


        }
        for (Substance j : allSubstance) {
            System.out.println(j.toString());
        }
        return allSubstance;
    }

    static double calculate(ArrayList<Substance> substances, int check_state) {
        double mass1 = substances.get(0).mass;
        double chal_mass1 = substances.get(0).chal_mass;
        double temp_init1 = substances.get(0).temp_init;
        double LF1 = substances.get(0).LF;
        double LV1 = substances.get(0).LV;

        double mass2 = substances.get(1).mass;
        double chal_mass2 = substances.get(1).chal_mass;
        double temp_init2 = substances.get(1).temp_init;
        double LF2 = substances.get(1).LF;
        double LV2 = substances.get(1).LV;



        double temp_final = (mass1*chal_mass1*temp_init1 - mass1 * LF1 * check_state - mass1 * LV1 * check_state + mass2 * chal_mass2 * temp_init2 - mass2 * LF2 * check_state - mass2 * LV2* check_state)
                /(mass1 * chal_mass1 + mass2*chal_mass2);


        return temp_final;
    }
}