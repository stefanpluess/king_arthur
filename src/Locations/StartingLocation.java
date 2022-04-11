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

public class StartingLocation extends Location{

    public Merlin merlin;
    public merlinType markedByMerlin = merlinType.NONE;

    @Override
    public String toString(){return "startingLocation";}
    public ArrayList<State> possibleAdventures = new ArrayList<State>();
    public ArrayList<Location> adjacent = new ArrayList<Location>();
    public void move(Player p){
        adjacent = this.adjacent;
        super.move(p);
    }
    public ArrayList<Location> getAdjacent(){return this.adjacent;}
    public void addadjacents(Location l){
        adjacent.add(l);
    }
    public void setMarkedByMerlin(merlinType m){
        this.markedByMerlin = m;
    }
    public merlinType getMarkedByMerlin(){return this.markedByMerlin;}
    public void setMerlinInstance(Merlin m){
        this.merlin = m;
    }
    public Merlin getMerlinInstance(){return this.merlin;}

}
