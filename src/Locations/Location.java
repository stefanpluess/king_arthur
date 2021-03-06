package Locations;

import Merlin.Merlin;
import Merlin.merlinType;
import States.State;
import Player.Player;
import java.util.ArrayList;

public interface Location {
    //Variables
    public boolean markedByMerlin = false;


    //Methods
    @Override
    public String toString();
    public ArrayList<State> possibleAdventures = new ArrayList<State>();
    public ArrayList<Location> adjacent = new ArrayList<Location>();
    public boolean move(Player p);
    public void chooseAdventure(Player p);
    public void setMarkedByMerlin(merlinType m);
    public merlinType getMarkedByMerlin();
    public void removeMarkedByMerlin();
    public void setMerlinInstance(Merlin m);

}
