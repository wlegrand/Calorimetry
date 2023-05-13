public class Calculator {
    double mass;
    double temp_init;
    double chal_mass;
    double LF;
    double LV;

    double temp_final;

    public Calculator(double mass, double temp_init, double chal_mass) {
        this.mass = mass;
        this.temp_init = temp_init;
        this.chal_mass = chal_mass;

    }

    static double first_calc(double mass, double temp_init, double chal_mass){
        return temp_init;
    }

}
