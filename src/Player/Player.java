package Player;

import Locations.*;
import Locations.StartingLocation;
import States.State;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    public Location currentPosition;
    private int ruhm = 0;
    private int swords = 0;
    private int shields = 0;
    private int supplies = 0;
    private State currentState;
    private boolean horse = false;
    private boolean armor = false;
    private boolean lanze = false;
    private int penDragon;
    public String name;
    private Location lastPosition;

    public Player(String s){
        this.name = s;
    }
    public void increaseRuhm(int amount){
        ruhm += amount;
    }

    public String toString(){return name;}
    public void setCurrentPosition(Location newlocation){
        this.currentPosition = newlocation;
        System.out.println("new Location is: " + newlocation);
    }
    public void setCurrentState(State newstate){
        this.currentState = newstate;
        System.out.println("new State is: " + newstate);
    }
    public void startAdventure(){
        this.currentState.begin(this);
        Scanner in = new Scanner(System.in);
        System.out.println("Would you like to explore or do Nothing? Press 0 for explore, 1 for doNothing 2 for Fighting or 3 if you want to giveSwords");
        int choice = Integer.parseInt(in.nextLine());
        switch(choice){
            case 0:
                this.currentState.explore(this);
                break;
            case 1:
                this.currentState.doNothing(this);
                break;
            case 2:
                this.currentState.fight(this);
                break;
            case 3:
                this.currentState.giveSwords(this);
        }
    }
    public void changeSwords(int amount){this.swords += amount;}
    public void changeSupplies(int amount){this.supplies += amount;}
    public void changeShields(int amount){this.shields += amount;}
    public void receiveArmor(){this.armor = true;}
    public void receiveHorse(){this.horse = true;}
    public void receiveLanze(){this.lanze = true;}
    public boolean checkIfWon(){
        if(this.lanze && this.horse && this.armor && ruhm > 50){
            System.out.println("this guy has won");
            return true;
        }
        return false;
    }
    public void setLastPosition(Location l){
        lastPosition = l;
    }

    public void goback(){
        this.currentPosition = lastPosition;
        System.out.println("You went back to" + this.currentPosition);
    }
    public State getCurrentState(){
        return this.currentState;
    }
    public void setPenDragon(int i){
        this.penDragon += i;
    }
    public int getSwords(){return this.swords;}
}

