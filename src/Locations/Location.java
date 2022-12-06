package Locations;

import Merlin.Merlin;
import Merlin.merlinType;
import States.State;
import Player.Player;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Location {
    //Variables
    public ArrayList<State> possibleAdventures = new ArrayList<State>();
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
    public void chooseAdventure(Player p){
        int chosenAdventure = (int) (Math.floor(Math.random() * possibleAdventures.size()));
        p.setCurrentState(possibleAdventures.get(chosenAdventure));
        p.startAdventure();
    }

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
