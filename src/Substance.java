public class Substance {
    String name;
    String chimie_comp;
    double mass;
    double temp_init;
    double chal_mass;
    double LF;
    double LV;
    double TF;
    double TE;

    public Substance(String name, String chimie_comp, double mass, double temp_init, double chal_mass, double LF, double LV, double TF, double TE) {
        this.name = name;
        this.chimie_comp = chimie_comp;
        this.mass = mass;
        this.temp_init = temp_init;
        this.chal_mass = chal_mass;
        this.LF = LF;
        this.LV = LV;
        this.TF = TF;
        this.TE = TE;
    }
}
