import java.util.ArrayList;
import java.util.HashMap;

public class Calculator {
    ArrayList<Substance> allSubstance;

    public Calculator(ArrayList<Substance> allSubstance) {
        this.allSubstance = allSubstance;
    }

    static double first_calc(ArrayList<Substance> allSubstance) {
        double nominator = 0;
        double denominator = 0;
        for (Substance substance : allSubstance) {
            nominator = nominator + substance.mass * substance.chal_mass * substance.temp_init;
            denominator = denominator + substance.mass * substance.chal_mass;
        }
        System.out.println(nominator / denominator);
        return nominator / denominator;
    }

    public static double calc_temp_final(ArrayList<Substance> infos, HashMap<String, Integer> checkFusion, HashMap<String, Integer> checkVaporisation) {
        double nominator = 0;
        double denominator = 0;
        for (Substance substance : infos) {
            int fusionValue = checkFusion.getOrDefault(substance.name, 0);
            int vaporisationValue = checkVaporisation.getOrDefault(substance.name, 0);
            int fValueD = 0;
            int vValueD = 0;
            System.out.println("Vvalue " + vaporisationValue);
            System.out.println("FValue " + fusionValue);
            nominator = nominator + substance.mass * substance.chal_mass * substance.temp_init
                    - substance.mass * substance.LF * fusionValue
                    - substance.mass * substance.LV * vaporisationValue
                    + substance.mass * substance.chal_mass * substance.TF * fusionValue
                    + substance.mass * substance.chal_mass * substance.TE * vaporisationValue;

            if (fusionValue != 0) fValueD = 1;
            if (vaporisationValue != 0) vValueD = 1;
            denominator += substance.mass * substance.chal_mass + substance.mass * substance.chal_mass * fValueD + substance.mass * substance.chal_mass * vValueD;
        }
        return nominator / denominator;
    }
}
