import java.util.ArrayList;

public class Calculator {
   ArrayList<Substance> allSubstance;

    public Calculator(ArrayList<Substance> allSubstance){
        this.allSubstance = allSubstance;
    }

    static double first_calc(ArrayList<Substance> allSubstance){
        double nominator = 0;
        double denominator = 0;
        for (Substance substance : allSubstance) {
            nominator = nominator + substance.mass * substance.chal_mass * substance.temp_init;
            denominator = denominator + substance.mass * substance.chal_mass;
        }
        return nominator/denominator;
    }
}
