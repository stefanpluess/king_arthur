package Locations;

import Merlin.merlinType;
import Player.Player;
import States.State;
import Merlin.Merlin;
import java.util.ArrayList;
import java.util.Scanner;

/*
    NOT IMPLEMENTED YET
    -new move method that changes the responsibility for moving.
 */
public class Tournament_Ground extends Location{
    public merlinType markedByMerlin = merlinType.NONE;
    public Merlin merlin;
    @Override
    public String toString(){return "TurnierPlatz";}
    public ArrayList<State> possibleAdventures = new ArrayList<>();
    public ArrayList<Location> adjacent = new ArrayList<>();
    public void move(Player p){
        adjacent = this.adjacent;
        super.move(p);
    }
    public void addadjacents(Location l){
        adjacent.add(l);
    }
    public ArrayList<Location> getAdjacent(){return this.adjacent;}
    public void setMarkedByMerlin(merlinType m){
        this.markedByMerlin = m;
    }
    public merlinType getMarkedByMerlin(){return this.markedByMerlin;}
    public void setMerlinInstance(Merlin m){
        this.merlin = m;
    }
    public Merlin getMerlinInstance(){return this.merlin;}
    public void removeMarkedByMerlin(){this.markedByMerlin = merlinType.NONE;}
}
