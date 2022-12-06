package Player;

import Locations.*;
import States.State;
import GUI.*;

public class Player {

    //constructor
    public Player(String s){
        this.name = s;
    }
    public String name;

    //variables for gameflow
    public Location currentLocation;
    private Location lastLocation;
    private State currentState;

    //inventory of the player
    private int ruhm = 0;
    private int swords = 2;
    private int shields = 2;
    private int supplies = 2;
    private boolean horse = false;
    private boolean armor = false;
    private boolean lanze = false;
    private int penDragon;

    //change the **Ruhm** variable with an amount given as parameter (positive or negative)
    public void changeRuhm(int amount){
        ruhm += amount;
    }

    //standard toString method, returns player name (often just a number saved as string)
    public String toString(){return name;}

    //changes the current position of the player, saved in this.currentPosition and
    //prints the new location. the print statement will be replaced
    public void setCurrentLocation(Location newlocation){
        this.currentLocation = newlocation;
        System.out.println("new Location is: " + newlocation);
    }

    //sets the current State of the player. this will be chosen after the location was determined.
    //prints the new state. this will be replaced
    public void setCurrentState(State newstate){
        this.currentState = newstate;
        System.out.println("new State is: " + newstate);
    }

    //starts the adventure. after determining the location and the new state this method will start the
    //adventure and give the player a choice. This method might need to be outsourced to a class of its own.
    // TODO change the input method and probably implement this in another class with the input as a class of its own
    public void startAdventure(){
        this.currentState.begin(this);
        switch(InputHandler.getPlayerActionInput()){
            case EXPLORE:
                this.currentState.explore(this);
                break;
            case DONOTHING:
                this.currentState.doNothing(this);
                break;
            case FIGHT:
                this.currentState.fight(this);
                break;
            case GIVESWORDS:
                this.currentState.giveSwords(this);
                break;
            case TRADE:
                this.currentState.trade(this);
                break;
        }
    }

    //This method is used for increasing or decreasing the amount of goods a player has.
    public void changeGoods(Goods g, int amount){
        switch(g){
            case SWORDS -> this.swords += amount;
            case SHIELDS -> this.shields += amount;
            case SUPPLIES -> this.supplies += amount;
        }
    }

    public int getSwords(){return this.swords;}

    //simple getter method to display the amount of goods a player has
    public int getGoods(Goods g){
        return switch (g) {
            case SWORDS -> this.swords;
            case SHIELDS -> this.shields;
            case SUPPLIES -> this.supplies;
            default -> 0;
        };
    }

    //methods for receiving the goods that are part of the winning condition
    public void receiveArmor(){this.armor = true;}
    public void receiveHorse(){this.horse = true;}
    public void receiveLanze(){this.lanze = true;}

    //check if the player checks all conditions to have won the game. this method will probably be moved to
    //the location itself.
    public boolean checkIfWon(){
        if(this.lanze && this.horse && this.armor && this.ruhm > 50){
            System.out.println("this guy has won");
            return true;
        }
        return false;
    }


    //sets the last position so events like "going back" can be executed correctly
    public void setLastLocation(Location l){
        lastLocation = l;
    }


    //exchanges the players current and last position
    public void goback(){
        Location temp = this.currentLocation;
        this.currentLocation = this.lastLocation;
        this.lastLocation = temp;
        System.out.println("You went back to" + this.currentLocation);
    }


    public State getCurrentState(){
        return this.currentState;
    }
    public void setPenDragon(int i){
        this.penDragon += i;
    }
}

