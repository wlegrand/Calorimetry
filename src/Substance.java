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

    int check_state_temperature_init_fusion(double temp_init) {
        double temp_final = 0;
        if (temp_init > TF && temp_init < TE) {
            return 0;
        }
        else if (temp_init > TF && temp_final < TF){
            return -1;
        } else if (temp_init< TF && temp_final > TF) {
            return 1;

        }
        return 0;
    }
}


