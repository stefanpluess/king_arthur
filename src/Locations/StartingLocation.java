package Locations;
import Merlin.Merlin;
import Merlin.merlinType;
import States.State;
import java.util.ArrayList;
import java.util.Scanner;
import Player.Player;

/*
This is a dummy location and will be replaced by the real starting location
 */

public class StartingLocation implements Location{

    public Merlin merlin;
    public merlinType markedByMerlin = merlinType.NONE;

    @Override
    public String toString(){return "startingLocation";}
    public ArrayList<State> possibleAdventures = new ArrayList<State>();
    private ArrayList<Location> adjacent = new ArrayList<Location>();
    public boolean move(Player p){
        System.out.println("-startingLocation- Player " + p + "Where would you like to move?");
        System.out.println(adjacent);
        Scanner in;
        in = new Scanner(System.in);
        //add a validity check here
        int userInput = Integer.parseInt(in.nextLine());
        Location newLocation = adjacent.get(userInput);
        p.setLastPosition(p.currentPosition);
        p.setCurrentPosition(newLocation);
        System.out.println("Moved to " + newLocation);
        System.out.println(p.currentPosition); //useless?
        if(newLocation.getMarkedByMerlin() != merlinType.NONE){
            merlin.merlinGiveReward(p, newLocation.getMarkedByMerlin());
            newLocation.removeMarkedByMerlin();
            return true;
        }
        return false;
    }

    public void chooseAdventure(Player p){
        int chosenAdventure = (int) (Math.floor(Math.random() * possibleAdventures.size()));
        p.setCurrentState(possibleAdventures.get(chosenAdventure));
        p.startAdventure();
    }
    public void addadjacents(Location l){
        adjacent.add(l);
    }
    public void setMarkedByMerlin(merlinType m){
        this.markedByMerlin = m;
    }
    public merlinType getMarkedByMerlin(){return this.markedByMerlin;}
    public void removeMarkedByMerlin(){this.markedByMerlin = merlinType.NONE;}
    public void setMerlinInstance(Merlin m){
        this.merlin = m;
    }
}
