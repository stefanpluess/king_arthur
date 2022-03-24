import Locations.Location;

import java.util.ArrayList;

public class Merlin {

    public Merlin(ArrayList<Location> locationList){
        int newOne = (int) (Math.random() * locationList.size());
        System.out.println("Willkommen Abenteurer, hier ein Rat für euch alle. Geht zur " + locationList.get(newOne));
        locationList.get(newOne).setMarkedByMerlin();
    }
//keine burgen oder startpunkt markieren
    public Location merlinChooseNext(ArrayList<Location> locationList){
        int newOne = (int) (Math.random() * locationList.size());
        System.out.println("Und nun habe ich einen Rat für euch alle, geht zur " + locationList.get(newOne));
        locationList.get(newOne).setMarkedByMerlin();
        return locationList.get(newOne);
    }
}
