package Locations;

import Merlin.Merlin;
import Merlin.merlinType;
import States.State;
import Player.Player;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Location {
    //Variables
    public ArrayList<State> possibleAdventuresExplore = new ArrayList<State>();
    public ArrayList<State> possibleAdventuresDoNothing = new ArrayList<>();
    public Merlin merlin;
    public merlinType markedByMerlin;
    public ArrayList<Location> adjacent = new ArrayList<>();

    //Methods
    public abstract ArrayList<Location> getAdjacent();
    @Override
    public String toString(){return "super method";};

    public void move(Player p){
        adjacent = getAdjacent();
        System.out.printf("- %s - Where would you like to move?", this);
        System.out.println(this.adjacent);
        Scanner in = new Scanner(System.in);
        //add validity check here
        int input = Integer.parseInt(in.nextLine());
        Location chosenLocation = this.adjacent.get(input);
        p.setLastLocation(this);
        p.setCurrentLocation(chosenLocation);
        chosenLocation.arrive(p);
    }
    //TODO change this method as we need to differentiate between explore and doing nothing
    public void chooseAdventure(Player p){
        int chosenAdventure = (int) (Math.floor(Math.random() * possibleAdventuresExplore.size()));
        p.setCurrentState(possibleAdventuresExplore.get(chosenAdventure));
        p.startAdventure();
    }
    public abstract void addadjacents(Location l);
    public abstract void setMarkedByMerlin(merlinType m);
    public abstract merlinType getMarkedByMerlin();
    public abstract void removeMarkedByMerlin();
    public abstract void setMerlinInstance(Merlin m);
    public abstract Merlin getMerlinInstance();
    public void arrive(Player p){
        if(markedByMerlin == merlinType.NONE){
            this.chooseAdventure(p);
        }else{
            this.merlin = getMerlinInstance();
            merlin.merlinChooseNext(getMarkedByMerlin());
            merlin.merlinGiveReward(p, getMarkedByMerlin());
            this.removeMarkedByMerlin();
        }
    }

}
