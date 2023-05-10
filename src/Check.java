public class Check {
    double temp_init;
    double temp_final;
    double TF;
    double TE;

    public Check(double temp_init, double temp_final, double TF, double TE) {
        this.temp_init = temp_init;
        this.temp_final = temp_final;
        this.TF = TF;
        this.TE = TE;
    }
    static int state_temp_init_fusion(double temp_init, double temp_final, double TF, double TE){
        if (temp_init < TF &&(temp_final < TF && temp_init > TE )){
            return 0;
        } else if (temp_init > TF && temp_final < TF) {
            return -1;
        }else {
            return 1;
        }
    }
    static int state_temp_init_ebullition(double temp_init, double temp_final, double TF, double TE){
        if (temp_init < TF &&(temp_final < TF && temp_init > TE )){
            return 0;
        } else if (temp_init > TE && temp_final < TE) {
            return -1;
        }else {
            return 1;
        }
    }
}
