import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.SplittableRandom;


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

            System.out.println("Enter the name of the " + (i + 1) + " substance");
            String name = sc.next();
            sc.nextLine();

            System.out.println("Enter the mass for the " + (i + 1) + " substance");
            double mass = sc.nextDouble();
            sc.nextLine();

            System.out.println("Enter the initial temperature for the " + (i + 1) + " substance");
            double temp_init = sc.nextDouble();


            double chal_mass = 4180;
            double LF = 33000;
            double LV = 2300000;
            double TF = 0;
            double TE = 100;


            Substance substance = new Substance(name, mass, temp_init, chal_mass, LF, LV, TF, TE);
            allSubstance.add(substance);

        }
        for (Substance i : allSubstance) {

            System.out.println(i.toString());
        }
    }
}