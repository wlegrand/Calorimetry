import java.util.ArrayList;
import java.util.HashMap;


public class Check {


    static HashMap state_temp_init_fusion(ArrayList<Substance> infos, double first_temp_final){
        HashMap<String, Integer> FusionMap = new HashMap<>();

        for(Substance i: infos){
            if(i.temp_init > i.TF && (first_temp_final > i.TF && first_temp_final < i.TE)){
                FusionMap.put(i.name, 0);
            } else if (i.temp_init > i.TF && first_temp_final < i.TF) {
                FusionMap.put(i.name, -1);
            }else if(i.temp_init < i.TF && first_temp_final > i.TF){
                FusionMap.put(i.name, 1);
            }else{
                //not correct
                FusionMap.put(i.name, 0);
            }
        }
        return FusionMap;
    }

    static HashMap state_temp_init_ebullition(ArrayList<Substance> infos, double first_temp_final){
        HashMap<String, Integer> VaporisationMap = new HashMap<>();

        for(Substance i: infos){
            if(i.temp_init > i.TF && (first_temp_final > i.TF && first_temp_final < i.TE)){
                VaporisationMap.put(i.name, 0);
            } else if (i.temp_init > i.TE && first_temp_final < i.TE) {
                VaporisationMap.put(i.name, -1);
            }else if(i.temp_init < i.TE && first_temp_final > i.TE){
                VaporisationMap.put(i.name, 1);
            }else{
                //not correct
                VaporisationMap.put(i.name, 0);
            }
        }
        return VaporisationMap;
    }




}
