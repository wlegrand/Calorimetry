public class Substance {

    String name;

    double mass;
    double temp_init;
    double chal_mass;
    double LF;
    double LV;
    double TF;
    double TE;

    public Substance(String name, double mass, double temp_init, double chal_mass, double LF, double LV, double TF, double TE) {
        this.name = name;
        this.mass = mass;
        this.temp_init = temp_init;
        this.chal_mass = chal_mass;
        this.LF = LF;
        this.LV = LV;
        this.TF = TF;
        this.TE = TE;
    }

    @Override
    public String toString() {
        return "Substance{" +
                "name='" + name + '\'' +
                ", mass=" + mass +
                ", temp_init=" + temp_init +
                ", chal_mass=" + chal_mass +
                ", LF=" + LF +
                ", LV=" + LV +
                ", TF=" + TF +
                ", TE=" + TE +
                '}';
    }

}


