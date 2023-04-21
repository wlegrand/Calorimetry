import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        get_information();

    }

    static void get_information() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of substances that you want:");
        int number_of_substance = sc.nextInt();

        for (int i = 0; i < number_of_substance; i++) {
            System.out.println("Enter the name of the " + i + " substance");
            String name = sc.nextLine();

            System.out.println("Enter the chemical composition od the " + i + " substance");
            String chimi_comp = sc.nextLine();

            System.out.println("Enter the mass for the " + i + " substance");
            double mass = sc.nextDouble();

            System.out.println("Enter the initial temperature for the " + 1 + " substance");
            double temp_init = sc.nextDouble();


            double chal_mass = 4180;
            double LF = 33000;
            double LV = 2300000;
            double TF = 0;
            double TE = 100;


            Substance substance = new Substance(name, chimi_comp, mass, temp_init, chal_mass, LF, LV, TF, TE);


        }
    }

}