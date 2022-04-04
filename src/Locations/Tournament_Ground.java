package Locations;

import Merlin.merlinType;
import Player.Player;
import States.State;
import Merlin.Merlin;
import java.util.ArrayList;
import java.util.Scanner;

public class Tournament_Ground implements Location{
    public merlinType markedByMerlin = merlinType.NONE;
    public Merlin merlin;
    @Override
    public String toString(){return "TurnierPlatz";}
    public ArrayList<State> possibleAdventures = new ArrayList<>();
    public ArrayList<Location> adjacent = new ArrayList<>();
    public boolean move(Player p){
        System.out.println("-Tournament_Ground- Where would you like to move Player" + p.name);
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
        System.out.println(chosenAdventure);
        System.out.println(possibleAdventures);
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
