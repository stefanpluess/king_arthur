package Merlin;

import Locations.Location;
import Player.Player;

import java.util.ArrayList;

public class Merlin {

    public Merlin(ArrayList<Location> locationList){
        int newOne = (int) (Math.random() * locationList.size());
        System.out.println("Willkommen Abenteurer, hier ein Rat für euch alle. Geht zur " + locationList.get(newOne) + " um euren Ruhm zu erhöhen");
        locationList.get(newOne).setMarkedByMerlin(merlinType.GLORY);

        while(locationList.get(newOne).getMarkedByMerlin() != merlinType.NONE){
            newOne = (int) (Math.random() * locationList.size());
        }
        System.out.println("Geht zur " + locationList.get(newOne) + "um weitere Güter zu erhalten.");
        locationList.get(newOne).setMarkedByMerlin(merlinType.GOODS);
    }
//keine burgen oder startpunkt markieren
    public Location merlinChooseNext(ArrayList<Location> locationList, merlinType m){
        int newOne = (int) (Math.random() * locationList.size());
        System.out.println("Und nun habe ich einen Rat für euch alle, geht zur " + locationList.get(newOne));
        locationList.get(newOne).setMarkedByMerlin(m);
        return locationList.get(newOne);
    }
    public void merlinGiveReward(Player p, merlinType m){
        switch(m){
            case GLORY:
                System.out.println("Du hast meinen Rat befolgt, dein Ruhm hat sich erhöht!");
                p.increaseRuhm(2);
                break;
            case GOODS:
                int freeGood = (int) (Math.random() * 3);
                System.out.print("Du hast meinen Rat befolgt, Nimm diese 2 ");
                switch (freeGood) {
                    case 0 -> {
                        p.changeShields(2);
                        System.out.println("Schilder");
                    }
                    case 1 -> {
                        p.changeSupplies(2);
                        System.out.println("Vorräte");
                    }
                    case 2 -> {
                        p.changeSwords(2);
                        System.out.println("Schwerter");
                    }
                }
                break;
        }
    }
}
