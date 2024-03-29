package Merlin;

import Locations.Location;
import Player.Player;
import Player.Goods;
import java.util.ArrayList;

import static Player.Goods.*;

/*NOT WORKING PROPERLY YET:
    found a bug where merlin chose the same location after visiting it, when moving on it with the other
    player it didn't trigger merlin, but a normal state instead
*/
/*TODO change the markedbymerlin mechanic(or finish it)
*  TODO as of now the markedbymerlin is stored in the location itself. It would probably make more sense
*   to just store it in the merlin class as we could use less variables like this and it would be easier to
*   access since we don't need to ask the location instances itself */
public class Merlin {

    //variables
    private ArrayList<Location> locationList = new ArrayList<>();
    private Location markedForGoods;
    private Location markedForGlory;


    public Merlin(ArrayList<Location> locationList){
        this.locationList = locationList;
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
    public Location merlinChooseNext(merlinType m){
        int newOne;
        do{
            newOne = (int) (Math.random() * locationList.size());
        }while(locationList.get(newOne).getMarkedByMerlin() != merlinType.NONE);
        System.out.println("Und nun habe ich einen Rat für euch alle, geht zur " + locationList.get(newOne));
        locationList.get(newOne).setMarkedByMerlin(m);
        return locationList.get(newOne);
    }

    //TODO is it necessary to give a player instance to the merlincheck method? if no how would you then change the
    // or goods value in the end.
    public merlinType merlinCheck(Location currentLocation){
        if(currentLocation == markedForGlory){
            merlinGiveReward(p, merlinType.GLORY);
        }else if(currentLocation == markedForGoods){
            merlinGiveReward(p, merlinType.GOODS);
        }else{
            
        }
    }
    public void merlinGiveReward(Player p, merlinType m){
        switch(m){
            case GLORY:
                System.out.println("Du hast meinen Rat befolgt, dein Ruhm hat sich erhöht!");
                p.changeRuhm(2);
                break;
            case GOODS:
                int freeGood = (int) (Math.random() * 3);
                System.out.print("Du hast meinen Rat befolgt, Nimm diese 2 ");
                switch (freeGood) {
                    case 0 -> {
                        p.changeGoods(SHIELDS, 2);
                        System.out.println("Schilder");
                    }
                    case 1 -> {
                        p.changeGoods(SUPPLIES,2);
                        System.out.println("Vorräte");
                    }
                    case 2 -> {
                        p.changeGoods(SWORDS,2 );
                        System.out.println("Schwerter");
                    }
                }
                break;
        }
    }
}
