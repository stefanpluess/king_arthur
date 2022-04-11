package Locations;

import Merlin.Merlin;
import Merlin.merlinType;
import States.MalgrinState;
import States.State;
import Player.Player;
import States.Status;

import java.util.ArrayList;
import java.util.Scanner;

public class Bridge extends Location{

    //Variables
    public Merlin merlin;
    public merlinType markedByMerlin = merlinType.NONE;
    private State malgrinState;
    //Methods
    @Override
    public String toString(){return "Brücke";}
    public ArrayList<State> possibleAdventures = new ArrayList<State>();
    private ArrayList<Location> adjacent = new ArrayList<Location>();
    public Bridge(State m){
        this.malgrinState = m;
    }
    public void addadjacents(Location l){
        adjacent.add(l);
    }
    public ArrayList<Location> getAdjacent(){return this.adjacent;}
    public void move(Player p){
        adjacent = this.adjacent;
        super.move(p);
    }

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
