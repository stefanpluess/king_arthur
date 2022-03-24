package Locations;

import States.MalgrinState;
import States.State;
import Player.Player;
import States.Status;

import java.util.ArrayList;
import java.util.Scanner;

public class Bridge implements Location{
    //Variables
    boolean markedByMerlin = false;
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
    public boolean move(Player p){
        if(malgrinState.getStats(p) != Status.UNKNOWN){
            return false;
        }
        System.out.println("-Bridge- Where would you like to move Player" + p.name);
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
        if(newLocation.getMarkedByMerlin()){
            newLocation.setMarkedByMerlin();
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
            return true;
        }
        return false;
    }
    public void chooseAdventure(Player p){
        int chosenAdventure = (int) (Math.floor(Math.random() * possibleAdventures.size()));
        p.setCurrentState(possibleAdventures.get(chosenAdventure));
        p.startAdventure();
    }
    public void setMarkedByMerlin(){
        this.markedByMerlin = !this.markedByMerlin;
    }
    public boolean getMarkedByMerlin(){return this.markedByMerlin;}
}
